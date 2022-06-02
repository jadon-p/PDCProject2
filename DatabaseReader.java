package src;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pfn3947
 */
public class DatabaseReader {

    public boolean checkName(String name, Connection conn) {
        boolean studentFound = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM studentDetails WHERE name = '" + name.toUpperCase() + "'");
            if (rs.next()) {
                System.out.println("Student exists!");
                studentFound = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return studentFound;
    }

    public boolean checkTableExisting(String newTableName, Connection conn) {
        boolean flag = false;
        try {
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    flag = true;
                }
            }
            rsDBMeta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    }

    public boolean checkOrder(String name, int size, Connection conn) {
        boolean uniformFound = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name, size FROM uniformList WHERE name = '" + name.toUpperCase() + "' AND size =" + size);
            if (rs.next()) {
                System.out.println("Order exists!");
                uniformFound = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return uniformFound;
    }

    public ResultSet getClassList(String chosenClass, Connection conn) {
        ResultSet rs = null;
        Statement statement;
        try {
            System.out.println("Getting class");
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT name FROM " + chosenClass);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    public ResultSet getUniformList(Connection conn) {
        ResultSet rs = null;
        Statement statement;
        try {
            System.out.println("Getting uniform list");
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT name,size FROM uniformList");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }
}
