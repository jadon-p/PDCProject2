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

    //Function: Tells the Update enum to open the add student menu
    public void addStudent() {
        data.update = "ADDMENU";
        this.changeData();
    }

    //Function: Checks if the order already exists, then tells the Update enum what to do based on this 
    public void addUniformOrder(String orderName, int orderSize) {
        boolean orderFound = this.database.checkOrder(orderName, orderSize);
        if (!orderFound) {
            this.database.addOrder(orderName, orderSize);
            ResultSet rs = this.database.getUniformList();
            this.addOrderList();
            data.update = "ADDORDER";
            data.status = "SUCCESS";
        } else {
            data.status = "FAIL";
            data.error = "UNIFORM ORDER ALREADY EXISTS";
            data.update = "ERROR";
        }
        this.changeData();
    }

    //Function: Updates the class list then gives this information to the Update enum
    public void checkClassList(String desiredClass) {
        ResultSet rs = this.database.getClassList(desiredClass);
        try {
            while (rs.next()) {
                data.classList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        data.update = "CHECKCLASS";
        this.changeData();
    }

    //Function: Tells the Update enum to open the student list menu
    public void checkStudentList() {
        data.update = "STUDENTMENU";
        this.changeData();
    }

    //Function: Tells the Update enum to open the order list menu
    public void checkUniformList() {
        this.addOrderList();
        data.update = "UNIFORMMENU";
        this.changeData();
    }

    //Function: Checks if the student exists then tells the Update Enum what to do based on this
    public void deleteStudent(String name) {
        boolean studentFound = this.database.checkName(name);
        if (studentFound) {
            this.database.removeStudent(name);
            data.update = "DELETESTUDENT";
            data.status = "SUCCESS";
        } else {
            data.status = "FAIL";
            data.error = "STUDENT DOES NOT EXIST";
            data.update = "ERROR";
        }
        this.changeData();
    }

    //Function: Checks if the order exists, then tells the update Enum what to do based on this
    public void deleteUniformOrder(String orderName, int orderSize) {
        boolean orderFound = this.database.checkOrder(orderName, orderSize);
        if (orderFound) {
            this.database.deleteOrder(orderName, orderSize);
            this.addOrderList();
            data.status = "SUCCESS";
            data.update = "DELETEORDER";
        } else {
            data.status = "FAIL";
            data.error = "UNIFORM ORDER DOES NOT EXIST";
            data.update = "ERROR";
        }
        this.changeData();
    }

    //Function: Tells the Update enum to open the edit student menu
    public void editStudent() {
        data.update = "EDITMENU";
        this.changeData();
    }

    //Function: Checks if the student exists then tells the update enum what to do based on this
    public void editStudentDetail(String name, String detail, String newDetail) {
        boolean studentFound = this.database.checkName(name);
        if (studentFound) {
            this.database.editStudent(name, detail, newDetail);
            data.update = "EDITSTUDENT";
            data.status = "SUCCESS";
        } else {
            data.status = "FAIL";
            data.error = "STUDENT DOES NOT EXIST";
            data.update = "ERROR";
        }

        this.changeData();
    }

    //Function: Tells the Update enum to open the menu
    public void openMenu() {
        data.update = "MENU";
        this.changeData();
    }

    //Function: Tells the Update enum to print an error
    public void printError(String error) {
        data.error = error.toUpperCase();
        data.update = "ERROR";
        this.changeData();
    }

    //Function: Tells the Update enum to open the quit page
    public void quitApp() {
        data.update = "QUIT";
        this.changeData();
    }

    public void saveStudent(String name, String dob, String email, int phone, String belt, String joiningDate, String chosenClass) {
        boolean studentFound = this.database.checkName(name);
        if (!studentFound) {
            this.database.saveStudent(name, dob, email, phone, belt, joiningDate, chosenClass);
            data.update = "SAVE";
            data.status = "SUCCESS";
        } else {
            data.status = "FAIL";
            data.error = "STUDENT ALREADY EXISTS";
            data.update = "ERROR";
        }
        this.changeData();
    }

    //Helper function that notifies observers
    private void changeData() {
        this.setChanged();
        this.notifyObservers(this.data);
    }

    //Helper function to add uniforms from database to arraylist
    private void addOrderList() {
        ResultSet rs = this.database.getUniformList();
        try {
            while (rs.next()) {
                data.uniformOrders.add(rs.getString(1) + " " + rs.getString(2) + "cm");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
