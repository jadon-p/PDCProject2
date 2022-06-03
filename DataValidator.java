package src;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author pfn3947
 */
public class DataValidator {

    //Function: validates all the data, if all are true, this function returns true
    public static boolean checkData(String dob, String email, String name, String phone) {
        boolean valid = false;
        if (checkDate(dob) && checkEmail(email) && checkName(name) && checkPhone(phone)) {
            valid = true;
        }
        return valid;
    }

    //Function: Ensures the input matches the wanted date format
    protected static boolean checkDate(String dob) {
        boolean dateValid = false;
        try {
            String[] temp = dob.split("-");
            if (temp.length == 3) {
                int day = Integer.parseInt(temp[0]);
                int month = Integer.parseInt(temp[1]);
                int year = Integer.parseInt(temp[2]);
                if (year < LocalDate.now().getYear()) {
                    LocalDate dateOfBirth = LocalDate.of(year, month, day);
                    dateValid = true;
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | DateTimeException E) {
            dateValid = false;
        }
        return dateValid;
    }
    //Function: Ensures that the input mathes the wanted email format
    protected static boolean checkEmail(String email) {
        boolean emailValid = false;
        if (!isEmpty(email) && email.length() < 30 && email.contains("@")) {
            emailValid = true;
        }
        return emailValid;
    }
    //Function: Ensures that the input matches the wanted name format
    public static boolean checkName(String name) {
        boolean nameValid = false;
        if (!isEmpty(name) && name.length() < 30) {
            nameValid = true;
        }
        return nameValid;
    }

    //Function: Ensures that the input matches the wanted phone format
    protected static boolean checkPhone(String phone) {
        boolean phoneValid = false;
        try {
            int temp = Integer.parseInt(phone);
            if (temp < 999999999) {
                phoneValid = true;
            }
        } catch (NumberFormatException e) {
            phoneValid = false;
        }

        return phoneValid;
    }

    //Helper function to check if input is empty
    private static boolean isEmpty(String input) {
        return input.length() == 0;
    }

}
