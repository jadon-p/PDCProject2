package src;

import java.util.ArrayList;

/**
 *
 * @author GGPC
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
            view.menu();
            data.update = "";
        }
    },
    STUDENTMENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.checkStudentListMenu();
            data.update = "";
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
            view.menu();
            data.update = "";
        }
    },
    MENU {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.menu();
            data.update = "";
        }
    },
    EDITSTUDENT {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.editStudentMenu();
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
    SAVE {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view) {
            view.menu();
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
    },
    QUIT {
        @Override
        public void execute(TaekwondoData data, TaekwondoView view
        ) {
            view.quitApp();
            data.update = "";
        }
    };

    public abstract void execute(TaekwondoData data, TaekwondoView view);
}
