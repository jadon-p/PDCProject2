package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pfn3947
 */
public class TaekwondoDatabase {

    private Connection conn = null;
    private String url = "jdbc:derby:TaekwondoDB;create=true";
    private String dbUser = "admin";
    private String dbPass = "admin";
    private DatabaseReader dbRead;
    private DatabaseWriter dbWrite;

    public TaekwondoDatabase() {
        try {
            conn = DriverManager.getConnection(url, dbUser, dbPass);
            Statement statement = conn.createStatement();
            String tableName = "studentDetails";
            dbRead = new DatabaseReader();
            dbWrite = new DatabaseWriter();

            if (!checkTableExisting(tableName) && !checkTableExisting("littleKiwi") && !checkTableExisting("tiger") && !checkTableExisting("dragon") && !checkTableExisting("adults") && !checkTableExisting("uniformList")) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (name VARCHAR(30), dateOfBirth VARCHAR(10), email VARCHAR(40), phone INT, belt VARCHAR(10), joiningDate VARCHAR(10))");
                statement.executeUpdate("CREATE TABLE littleKiwi (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE dragon (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE tiger (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE adults (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE uniformList (name VARCHAR (30), size INT)");
            } else {
                System.out.println("Tables exists");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addOrder(String name, int size) {
        dbWrite.addUniformOrder(name, size, conn);
    }

    public boolean checkName(String name) {
        return dbRead.checkName(name, conn);
    }

    private boolean checkTableExisting(String newTableName) {
        return dbRead.checkTableExisting(newTableName, conn);
    }

    public boolean checkOrder(String name, int size) {
        return dbRead.checkOrder(name, size, conn);
    }

    public void deleteOrder(String name, int size) {
        dbWrite.deleteUniformOrder(name, size, conn);
    }

    public void editStudent(String name, String detail, String newDetail) {
        dbWrite.editStudent(name, detail, newDetail, conn);
    }

    public ResultSet getClassList(String chosenClass) {
        return dbRead.getClassList(chosenClass, conn);
    }

    public ResultSet getUniformList() {
        return dbRead.getUniformList(conn);
    }

    public void removeStudent(String name) {
        dbWrite.removeStudent(name, conn);
    }

    public void saveStudent(String name, String dob, String email, int phone, String belt, String joiningDate, String chosenClass) {
        dbWrite.saveStudent(name, dob, email, phone, belt, joiningDate, chosenClass, conn);
    }

}
