package src;

import java.time.LocalDate;

/**
 *
 * @author pfn3947
 */
public class DataValidator {

    private static boolean checkDate(String dob) {
        boolean dateValid = false;
        try {
            String[] temp = dob.split("-");
            int day = Integer.parseInt(temp[0]);
            int month = Integer.parseInt(temp[1]);
            int year = Integer.parseInt(temp[2]);
            if (year < LocalDate.now().getYear()) {
                LocalDate dateOfBirth = LocalDate.of(year, month, day);
                dateValid = true;
            }
        } catch (NumberFormatException E) {
            dateValid = false;
        }
        return dateValid;
    }

    private static boolean checkEmail(String email) {
        boolean emailValid = false;
        if (!isEmpty(email) && email.length() < 30) {
            emailValid = true;
        }
        return emailValid;
    }

    private static boolean isEmpty(String input) {
        return input.length() == 0;
    }

    private static boolean checkName(String name) {
        boolean nameValid = false;
        if (!isEmpty(name) && name.length() < 30) {
            nameValid = true;
        }
        return nameValid;
    }

    private static boolean checkPhone(int phone) {
        boolean phoneValid = false;
        if (phone < 999999999) {
            phoneValid = true;
        }
        return phoneValid;
    }

    public static boolean checkData(String dob, String email, String name, int phone) {
        boolean valid = false;
        if (checkDate(dob) && checkEmail(email) && checkName(name) && checkPhone(phone)) {
            valid = true;
        }
        return valid;
    }
}
