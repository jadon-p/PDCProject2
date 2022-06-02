package src;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pfn3947
 */
public class DatabaseWriter {

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

    public void editStudent(String name, String detail, String newDetail, Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            if (detail.matches("Name")) {
                statement.executeUpdate("UPDATE studentDetails SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("UPDATE littlekiwi SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("UPDATE dragon SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("UPDATE tiger SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("UPDATE adults SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
            } else if (detail.matches("Phone")) {
                statement.executeUpdate("UPDATE studentDetails SET " + detail + "=" + newDetail + " WHERE name ='" + name.toUpperCase() + "'");
            } else if (detail.matches("Class")) {
                statement.executeUpdate("DELETE FROM littlekiwi WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("DELETE FROM dragon WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("DELETE FROM tiger WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("DELETE FROM adults WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("INSERT INTO " + newDetail + " VALUES ('" + name.toUpperCase() + "')");
            } else {
                statement.executeUpdate("UPDATE studentDetails SET " + detail + "='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
            }
            System.out.println("Student Edited");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

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
}
