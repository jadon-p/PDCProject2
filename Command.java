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
    ADDSTUDENT {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String name;
            String dateOfBirth;
            String email;
            int phone;
            if (DataValidator.checkData(view.addDOB.getText(), view.addEmail.getText(), view.addName.getText(), view.addPhone.getText())) {
                name = view.addName.getText();
                dateOfBirth = view.addDOB.getText();
                email = view.addEmail.getText();
                phone = Integer.parseInt(view.addPhone.getText());
                String belt = (String) view.beltComboBox.getSelectedItem();
                String joiningDate = LocalDate.now().toString();
                String chosenClass = (String) view.classComboBox.getSelectedItem();
                model.saveStudent(name, dateOfBirth, email, phone, belt, joiningDate, chosenClass);
            } else {
                model.printError("Data invalid! Please ensure data has correct format");
            }
        }
    },
    ADDUNIFORM {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String uniformOrderName = view.uniformOrder.getText();
            if (DataValidator.checkName(uniformOrderName)) {
                int uniformSize = Integer.parseInt((String) view.uniformComboBox.getSelectedItem());
                model.addUniformOrder(uniformOrderName, uniformSize);
            } else {
                model.printError("Name is empty");
            }
        }
    },
    CHECKCLASS {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String desiredClass = (String) view.classComboBox.getSelectedItem();
            model.checkClassList(desiredClass);
        }
    },
    DELETESTUDENT {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String name = view.studentSearch.getText();
            if (DataValidator.checkName(name)) {
                model.deleteStudent(name);
            } else {
                model.printError("Name is empty");
            }
        }
    },
    DELETEUNIFORM {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String uniformOrderName = view.uniformOrder.getText();
            if (DataValidator.checkName(uniformOrderName)) {
                int uniformSize = Integer.parseInt((String) view.uniformComboBox.getSelectedItem());
                model.deleteUniformOrder(uniformOrderName, uniformSize);
            } else {
                model.printError("Name is empty");
            }

        }
    },
    EDITMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.editStudent();
        }
    },
    EDITSTUDENT {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String name = view.studentSearch.getText();
            if (DataValidator.checkName(name)) {
                String detail = (String) view.detailComboBox.getSelectedItem();
                String newDetail = view.detailInput.getText();
                model.editStudentDetail(name, detail, newDetail);
            } else {
                model.printError("Name is empty");
            }
        }
    },
    MENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.openMenu();
        }
    },
    QUIT {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.quitApp();
        }
    },
    STUDENTMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.checkStudentList();
        }
    },
    UNIFORMMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.checkUniformList();
        }
    };

    public abstract void execute(TaekwondoModel model, TaekwondoView view);
}
