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
        this.database.dbSetup();
        this.data = new TaekwondoData();
    }

    public void addStudent() {
        data.addStu = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void editStudent() {
        data.editStu = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void checkStudentList() {
        data.checkStuList = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void checkUniformList() {
        data.checkUniList = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void openMenu() {
        data.openMenu = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void saveStudent(String name, String dob, String email, int phone, String belt, String joiningDate, String chosenClass) {
        boolean studentFound = this.database.checkName(name);
        if (!studentFound) {
            this.database.saveStudent(name, dob, email, phone, belt, joiningDate, chosenClass);
            data.studentSaved = true;
            this.setChanged();
            this.notifyObservers(this.data);
        }
    }

    public void editStudentDetail(String name, String detail, String newDetail) {
        boolean studentFound = this.database.checkName(name);
        if (studentFound) {
            if (!detail.equals("Delete Student")) {
                this.database.editStudent(name, detail, newDetail);
            } else {
                this.database.removeStudent(name);
            }
            data.studentEdited = true;
            this.setChanged();
            this.notifyObservers(this.data);
        }
    }

    public void checkClassList(String desiredClass) {
        ResultSet rs = this.database.getClassList(desiredClass);
        String classList = "";
        try {
            while (rs.next()) {
                classList = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        data.classFound = true;
        data.classList = classList;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void quitApp() {
        data.didQuit = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
}
