package src;

/**
 *
 * @author GGPC
 */
public class InputCleaner {

    public static void cleanAddStudent(TaekwondoView view) {
        view.addName.setText("");
        view.addDOB.setText("");
        view.addEmail.setText("");
        view.addPhone.setText("");
        view.promptLabel.setText("");
    }

    public static void cleanEditStudent(TaekwondoView view) {
        view.studentSearch.setText("");
        view.detailInput.setText("");
    }

    public static void cleanOrderMenu(TaekwondoView view) {
        view.uniformOrder.setText("");
        view.promptLabel.setText("");
    }
}
