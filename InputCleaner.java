package src;

/**
 *
 * @author GGPC
 */
public class InputCleaner {

    //Function: Cleans the add student menu so theres no data in the fields
    public static void cleanAddStudent(TaekwondoView view) {
        view.addName.setText("");
        view.addDOB.setText("");
        view.addEmail.setText("");
        view.addPhone.setText("");
        view.promptLabel.setText("");
    }
    //Function: Cleans the edit student meny so theres no data in the fields
    public static void cleanEditStudent(TaekwondoView view) {
        view.studentSearch.setText("");
        view.detailInput.setText("");
    }
    //Function: Cleans the order menu so theres no data in the fields
    public static void cleanOrderMenu(TaekwondoView view) {
        view.uniformOrder.setText("");
        view.promptLabel.setText("");
    }
}
