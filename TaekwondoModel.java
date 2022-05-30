package src;

import java.util.Observable;

/**
 *
 * @author pfn3947
 */
public class TaekwondoModel extends Observable {

    public TaekwondoData data;
    public TaekwondoDatabase database;

    public String name;

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

    public void saveStudent() {
        boolean studentFound = this.database.checkName(data.name);
        if (!studentFound) {
            this.database.saveStudent();
            data.studentSaved = true;
            this.setChanged();
            this.notifyObservers(this.data);
        }
    }

    public void quitApp() {
        data.didQuit = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
}
