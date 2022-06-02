package src;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public ArrayList classList = new ArrayList();
    public ArrayList uniformOrders = new ArrayList();

    public String update;
}
