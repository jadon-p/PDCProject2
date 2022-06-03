package src;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pfn3947
 */
public class DatabaseWriter {

    //Function: Adds order to database
    public void addUniformOrder(String name, int size, Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO uniformList VALUES('" + name.toUpperCase() + "'," + size + ")");
            System.out.println("Order added");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Function: Deletes order from database
    public void deleteUniformOrder(String name, int size, Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM uniformList WHERE name ='" + name.toUpperCase() + "' AND size =" + size);
            System.out.println("Order deleted");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Function: Edits the desired student's detail
    public void editStudent(String name, String detail, String newDetail, Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            System.out.println(detail);
            if (detail.equalsIgnoreCase("Date of Birth")) detail = "DATEOFBIRTH";
            this.getDetail(name, detail, newDetail, statement, Detail.valueOf(detail.toUpperCase()));
            System.out.println("Student Edited");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Function: Removes the desired student from the database
    public void removeStudent(String name, Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM studentDetails WHERE name ='" + name.toUpperCase() + "'");
            statement.executeUpdate("DELETE FROM littlekiwi WHERE name ='" + name.toUpperCase() + "'");
            statement.executeUpdate("DELETE FROM dragon WHERE name ='" + name.toUpperCase() + "'");
            statement.executeUpdate("DELETE FROM tiger WHERE name ='" + name.toUpperCase() + "'");
            statement.executeUpdate("DELETE FROM adults WHERE name ='" + name.toUpperCase() + "'");
            System.out.println("Student Deleted");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Function: Adds the student to the corresponding class and saves the details in a separate table
    public void saveStudent(String name, String dob, String email, int phone, String belt, String joiningDate, String chosenClass, Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO studentDetails VALUES('" + name.toUpperCase() + "','" + dob + "','" + email.toUpperCase() + "'," + phone + ",'" + belt + "','" + joiningDate + "')");
            statement.executeUpdate("INSERT INTO " + chosenClass + " VALUES('" + name.toUpperCase() + "')");
            System.out.println("Student added");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void getDetail(String name, String detail, String newDetail, Statement statement, Detail detailCommand) {
        detailCommand.execute(name, detail, newDetail, statement);
    }
}
