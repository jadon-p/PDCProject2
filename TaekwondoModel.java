package src;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

/**
 *
 * @author pfn3947
 */
public class TaekwondoModel extends Observable {

    public TaekwondoData data;
    public TaekwondoDatabase database;

    public TaekwondoModel() {
        this.database = new TaekwondoDatabase();
        this.data = new TaekwondoData();
    }

    public void addStudent() {
        data.update = "ADDMENU";
        this.changeData();
    }

    public void addUniformOrder(String orderName, int orderSize) {
        boolean orderFound = this.database.checkOrder(orderName, orderSize);
        if (!orderFound) {
            this.database.addOrder(orderName, orderSize);
            data.update = "ADDORDER";
            this.changeData();
        }
    }

    public void checkClassList(String desiredClass) {
        ResultSet rs = this.database.getClassList(desiredClass);
        try {
            while (rs.next()) {
                data.classList.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        data.update = "CHECKCLASS";
        this.changeData();
    }

    public void checkStudentList() {
        data.update = "STUDENTMENU";
        this.changeData();
    }

    public void checkUniformList() {
        ResultSet rs = this.database.getUniformList();
        try {
            while (rs.next()) {
                data.uniformOrders.add(rs.getString(1) + " " + rs.getString(2) + "cm");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        data.update = "UNIFORMMENU";
        this.changeData();
    }

    public void deleteUniformOrder(String orderName, int orderSize) {
        boolean orderFound = this.database.checkOrder(orderName, orderSize);
        if (orderFound) {
            this.database.deleteOrder(orderName, orderSize);
            data.update = "DELETEORDER";
            this.changeData();
        }
    }

    public void editStudent() {
        data.update = "EDITMENU";
        this.changeData();
    }

    public void editStudentDetail(String name, String detail, String newDetail) {
        boolean studentFound = this.database.checkName(name);
        if (studentFound) {
            if (!detail.equals("Delete Student")) {
                this.database.editStudent(name, detail, newDetail);
            } else {
                this.database.removeStudent(name);
            }
            data.update = "EDITSTUDENT";
            this.changeData();
        }
    }

    public void openMenu() {
        data.update = "MENU";
        this.changeData();
    }

    public void quitApp() {
        data.update = "QUIT";
        this.changeData();
    }

    public void saveStudent(String name, String dob, String email, int phone, String belt, String joiningDate, String chosenClass) {
        boolean studentFound = this.database.checkName(name);
        if (!studentFound) {
            this.database.saveStudent(name, dob, email, phone, belt, joiningDate, chosenClass);
            data.update = "SAVE";
            this.changeData();
        }
    }

    //Helper function that notifies observers
    private void changeData() {
        this.setChanged();
        this.notifyObservers(this.data);
    }
}
