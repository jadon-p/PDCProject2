package src;

import java.util.ArrayList;

/**
 *
 * @author pfn3947
 */
public enum Update {
    //Function: Opens the add student menu
    ADDMENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.addStudentMenu();
            data.update = "";
        }
    },
    //Function: Tells the user the order was successful if the model has told the update enum
    ADDORDER {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            if (data.status.matches("SUCCESS")) {
                view.uniformList.setText(!data.uniformOrders.isEmpty() ? data.uniformOrders.toString() : "");
                view.checkUniformListMenu();
                view.promptLabel.setText("Order Was Added");
                data.uniformOrders = new ArrayList();
            }
            data.update = "";
            data.status = "";
        }
    },
    //Function: Shows the student list if the list is not empty 
    CHECKCLASS {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.stuList.setText(!data.classList.isEmpty() ? data.classList.toString() : "");
            data.classList = new ArrayList();
            view.checkStudentListMenu();
            data.update = "";
        }
    },
    //Function: Tells the user the order was successfully deleted if the model has told the update enum
    DELETEORDER {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            if (data.status.matches("SUCCESS")) {
                view.uniformList.setText(!data.uniformOrders.isEmpty() ? data.uniformOrders.toString() : "");
                view.checkUniformListMenu();
                view.promptLabel.setText("Order Was Deleted");
                data.uniformOrders = new ArrayList();
            }
            data.update = "";
            data.status = "";
        }
    },
    //Function: Tells the user the student was successfully deleted if the model has told the update enum
    DELETESTUDENT {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            if (data.status.matches("SUCCESS")) {
                view.editStudentMenu();
                view.promptLabel.setText("Student was deleted");
                data.status = "";
            }
            data.update = "";
        }
    },
    //Function: Tells the user the student was successfully edited if the model has told the update enum
    EDITSTUDENT {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            if (data.status.matches("SUCCESS")) {
                view.editStudentMenu();
                view.promptLabel.setText("Edit was saved");
                data.status = "";
            }
            data.update = "";
        }
    },
    //Function: Opens the edit student menu
    EDITMENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.editStudentMenu();
            data.update = "";
        }
    },
    //Function: Prints the corresponding error in the prompt label
    ERROR {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.promptLabel.setText(data.error);
            this.clearData(data);
        }
    },
    //Function: Opens the menu
    MENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.menu();
            data.update = "";
        }
    },
    //Function: Opens the quit panel
    QUIT {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view
        ) {
            view.quitApp();
            data.update = "";
        }
    },
     //Function: Tells the user the student was successfully added with the model has told the update enum 
    SAVE {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            if (data.status.matches("SUCCESS")) {
                view.addStudentMenu();
                view.promptLabel.setText("Student was saved");
                data.status = "";
            }
            data.update = "";
        }
    },
    //Function: Opens the student menu
    STUDENTMENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.checkStudentListMenu();
            view.stuList.setText("");
            data.update = "";
        }
    },
    //Function: Opens the uniform menu
    UNIFORMMENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.uniformList.setText(!data.uniformOrders.isEmpty() ? data.uniformOrders.toString() : "");
            view.checkUniformListMenu();
            data.uniformOrders = new ArrayList();
            data.update = "";
        }
    };

    public abstract void execute(TaekwondoData data, TaekwondoView view);

     //Function: Clears the data so it can be replaced with new data
    protected void clearData(TaekwondoData data) {
        data.error = "";
        data.update = "";
        data.status = "";
    }
}
