package src;

import java.time.LocalDate;

/**
 *
 * @author pfn3947
 */
public enum Command {

    //Function: open the add student menu
    ADDMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.addStudent();
        }
    },
    //Function: Validates inputs then adds student to database
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
    //Function: Validates inputs then adds order to database
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
    //Function: Finds the list of students for any of the four classes
    CHECKCLASS {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            String desiredClass = (String) view.classComboBox.getSelectedItem();
            model.checkClassList(desiredClass);
        }
    },
    //Function: Validates the inputs then deletes the student from the database
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
    //Function: Validates the inputs then deletes the order from the database
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
    //Function: Opens the edit student menu
    EDITMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.editStudent();
        }
    },
    //Function: Validates the input then edits the chosen student's details
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
    //Function: Open the menu
    MENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.openMenu();
        }
    },
    //Function: Quit the program
    QUIT {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.quitApp();
        }
    },
    //Function: Opens the student list menu
    STUDENTMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.checkStudentList();
        }
    },
    //Function: Open the uniform order menu
    UNIFORMMENU {
        @Override
        public void execute(TaekwondoModel model, TaekwondoView view) {
            model.checkUniformList();
        }
    };

    public abstract void execute(TaekwondoModel model, TaekwondoView view);
}
