package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pfn3947
 */
public class TaekwondoController implements ActionListener {

    public TaekwondoModel model;
    public TaekwondoView view;

    public TaekwondoController(TaekwondoView view, TaekwondoModel model) {
        this.model = model;
        this.view = view;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("Add Student")) {
            this.model.addStudent();
        } else if (command.matches("Edit Student")) {
            this.model.editStudent();
        } else if (command.matches("Check Student List")) {
            this.model.checkStudentList();
        } else if (command.matches("Check Uniform Orders")) {
            this.model.checkUniformList();
        } else if (command.matches("Quit")) {
            this.model.quitApp();
        } else if (command.matches("Return to Menu")) {
            this.model.openMenu();
        } else if (command.matches("Save Student")) {
            this.model.saveStudent();
        }
    }
}
