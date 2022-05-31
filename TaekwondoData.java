package src;

import java.time.LocalDate;

/**
 *
 * @author Jadon
 */
public class TaekwondoData {

    public int studentID;
    public String name;
    public LocalDate dateOfBirth;
    public String email;
    public int phone;
    public String belt;
    public LocalDate joiningDate;

    public boolean openMenu = false;
    public boolean addStu = false;
    public boolean editStu = false;
    public boolean checkStuList = false;
    public boolean checkUniList = false;
    public boolean didQuit = false;
    public boolean studentSaved = false;
    public boolean studentEdited = false;
}
