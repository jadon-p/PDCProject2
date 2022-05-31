package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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
        System.out.println(command);
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
            String name = this.view.addName.getText();
            String dateOfBirth = this.view.addDOB.getText();
            String email = this.view.addEmail.getText();
            int phone = Integer.parseInt(this.view.addPhone.getText());
            String belt = (String) this.view.beltComboBox.getSelectedItem();
            String joiningDate = LocalDate.now().toString();
            String chosenClass = (String) this.view.classComboBox.getSelectedItem();
            this.model.saveStudent(name, dateOfBirth, email, phone, belt, joiningDate, chosenClass);
        } else if (command.matches("Confirm Edit Student")) {
            String name = this.view.studentSearch.getText();
            String detail = (String) this.view.detailComboBox.getSelectedItem();
            String newDetail = this.view.detailInput.getText();
            this.model.editStudentDetail(name, detail, newDetail);
        } else if (command.matches("Check Class")) {
            String desiredClass = (String) this.view.classComboBox.getSelectedItem();
            this.model.checkClassList(desiredClass);
        } else if (command.matches("Add Uniform Order")) {
            String uniformOrderName = this.view.uniformOrder.getText();
            int uniformSize = Integer.parseInt((String) this.view.uniformComboBox.getSelectedItem());
            this.model.addUniformOrder(uniformOrderName, uniformSize);
        } else if (command.matches("Delete Uniform Order")) {
            String uniformOrderName = this.view.uniformOrder.getText();
            int uniformSize = Integer.parseInt((String) this.view.uniformComboBox.getSelectedItem());
            this.model.deleteUniformOrder(uniformOrderName, uniformSize);
        }
    }
}
