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
        this.getCommand(model, view, Command.valueOf(command));

    }

    //Helper function that executes the correct command based on the action command
    private void getCommand(TaekwondoModel model, TaekwondoView view, Command command) {
        command.execute(model, view);
    }
}
