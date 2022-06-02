package src;

import java.time.LocalDate;

/**
 *
 * @author pfn3947
 */
public enum Command {

    ADDMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.addStudent();
        }
    },
    EDITMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.editStudent();
        }
    },
    QUIT {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.quitApp();
        }
    },
    UNIFORMMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.checkUniformList();
        }
    },
    STUDENTMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.checkStudentList();
        }
    },
    ADDSTUDENT {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String name = view.addName.getText();
            String dateOfBirth = view.addDOB.getText();
            String email = view.addEmail.getText();
            int phone = Integer.parseInt(view.addPhone.getText());
            if (DataValidator.checkData(dateOfBirth, email, name, phone)) {
                String belt = (String) view.beltComboBox.getSelectedItem();
                String joiningDate = LocalDate.now().toString();
                String chosenClass = (String) view.classComboBox.getSelectedItem();
                model.saveStudent(name, dateOfBirth, email, phone, belt, joiningDate, chosenClass);
            }
        }
    },
    EDITSTUDENT {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String name = view.studentSearch.getText();
            String detail = (String) view.detailComboBox.getSelectedItem();
            String newDetail = view.detailInput.getText();
            model.editStudentDetail(name, detail, newDetail);
        }
    },
    CHECKCLASS {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String desiredClass = (String) view.classComboBox.getSelectedItem();
            model.checkClassList(desiredClass);
        }
    },
    ADDUNIFORM {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String uniformOrderName = view.uniformOrder.getText();
            int uniformSize = Integer.parseInt((String) view.uniformComboBox.getSelectedItem());
            model.addUniformOrder(uniformOrderName, uniformSize);
        }
    },
    DELETEUNIFORM {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String uniformOrderName = view.uniformOrder.getText();
            int uniformSize = Integer.parseInt((String) view.uniformComboBox.getSelectedItem());
            model.deleteUniformOrder(uniformOrderName, uniformSize);
        }
    },
    MENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.openMenu();
        }
    };

    public abstract void execute(TaekwondoModel model, TaekwondoView view);
}
