package src;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pfn3947
 */
public enum Detail {

    //Function: Validates name then adds it to the database if valid
    NAME {
        @Override
        public void execute(String name, String detail, String newDetail, Statement statement) {
            try {
                if (DataValidator.checkName(newDetail)) {
                    statement.executeUpdate("UPDATE studentDetails SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                    statement.executeUpdate("UPDATE littlekiwi SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                    statement.executeUpdate("UPDATE dragon SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                    statement.executeUpdate("UPDATE tiger SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                    statement.executeUpdate("UPDATE adults SET name ='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                }
            } catch (SQLException e) {
            }
        }
    },
    //Function: Validates date of birth then adds it to the database if valid
    DATEOFBIRTH {
        @Override
        public void execute(String name, String detail, String newDetail, Statement statement) {
            try {
                if (DataValidator.checkDate(newDetail)) {
                    statement.executeUpdate("UPDATE studentDetails SET " + detail + "='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                }
            } catch (SQLException e) {
            }
        }

    },
    //Function: Validates email then adds it to the database if valid
    EMAIL {
        @Override
        public void execute(String name, String detail, String newDetail, Statement statement) {
            try {
                if (DataValidator.checkEmail(newDetail)) {
                    statement.executeUpdate("UPDATE studentDetails SET " + detail + "='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
                }
            } catch (SQLException e) {
            }
        }
    },
    //Function: Validates phone then adds it to the database if valid
    PHONE {
        @Override
        public void execute(String name, String detail, String newDetail, Statement statement) {
            try {
                if (DataValidator.checkPhone(newDetail)) {
                    statement.executeUpdate("UPDATE studentDetails SET " + detail + "=" + newDetail + " WHERE name ='" + name.toUpperCase() + "'");
                }
            } catch (SQLException e) {
            }
        }
    },
    //Function: Validates belt then adds it to the database if valid
    BELT {
        @Override
        public void execute(String name, String detail, String newDetail, Statement statement) {
            try {
                statement.executeUpdate("UPDATE studentDetails SET " + detail + "='" + newDetail.toUpperCase() + "' WHERE name ='" + name.toUpperCase() + "'");
            } catch (SQLException e) {
            }
        }
    },
    //Function: Validates class then adds it to the database if valid
    CLASS {
        @Override
        public void execute(String name, String detail, String newDetail, Statement statement) {
            try {
                statement.executeUpdate("DELETE FROM littlekiwi WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("DELETE FROM dragon WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("DELETE FROM tiger WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("DELETE FROM adults WHERE name ='" + name.toUpperCase() + "'");
                statement.executeUpdate("INSERT INTO " + newDetail + " VALUES ('" + name.toUpperCase() + "')");
            } catch (SQLException e) {
            }
        }
    };

    public abstract void execute(String name, String detail, String newDetail, Statement statement);
}
