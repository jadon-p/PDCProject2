package src;

import java.util.ArrayList;

/**
 *
 * @author pfn3947
 */
public enum Update {
    ADDMENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.addStudentMenu();
            data.update = "";
        }
    },
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
    CHECKCLASS {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.stuList.setText(!data.classList.isEmpty() ? data.classList.toString() : "");
            data.classList = new ArrayList();
            view.checkStudentListMenu();
            data.update = "";
        }
    },
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
    EDITMENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.editStudentMenu();
            data.update = "";
        }
    },
    ERROR {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.promptLabel.setText(data.error);
            this.clearData(data);
        }
    },
    MENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.menu();
            data.update = "";
        }
    },
    QUIT {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view
        ) {
            view.quitApp();
            data.update = "";
        }
    },
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
    STUDENTMENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.checkStudentListMenu();
            view.stuList.setText("");
            data.update = "";
        }
    },
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

    protected void clearData(TaekwondoData data) {
        data.error = "";
        data.update = "";
        data.status = "";
    }
}
