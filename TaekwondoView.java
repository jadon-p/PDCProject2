package src;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pfn3947
 */
public class TaekwondoView extends JFrame implements Observer {

    private final JPanel menuPanel = new JPanel();

    private final JButton addUniformButton = new JButton("Add Uniform Order");
    private final JButton backButton = new JButton("Return to Menu");
    private final JButton checkStuButton = new JButton("Check Student List");
    private final JButton checkUniButton = new JButton("Check Uniform Orders");
    private final JButton confirmCheckButton = new JButton("Check Class");
    private final JButton confirmEditButton = new JButton("Confirm Edit Student");
    private final JButton deleteUniformButton = new JButton("Delete Uniform Order");
    private final JButton editStuButton = new JButton("Edit Student");
    private final JButton newStuButton = new JButton("Add Student");
    private final JButton quitButton = new JButton("Quit");
    private final JButton saveButton = new JButton("Save Student");

    public JTextField addName = new JTextField(30);
    public JTextField addDOB = new JTextField(10);
    public JTextField addEmail = new JTextField(40);
    public JTextField addPhone = new JTextField(10);
    public JTextField studentSearch = new JTextField(30);
    public JTextField uniformOrder = new JTextField(30);
    public JTextField detailInput = new JTextField(30);

    public final JComboBox beltComboBox = new JComboBox();
    public final JComboBox classComboBox = new JComboBox();
    public final JComboBox detailComboBox = new JComboBox();
    public final JComboBox uniformComboBox = new JComboBox();

    public JLabel errorLabel = new JLabel();
    public JLabel stuList = new JLabel("(Student List will appear here)");
    public JLabel uniformList = new JLabel();

    public TaekwondoView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.menu();
        this.add(menuPanel);
        this.setVisible(true);

        ComboBoxInitializer.beltComboBox(beltComboBox);
        ComboBoxInitializer.classComboBox(classComboBox);
        ComboBoxInitializer.detailComboBox(detailComboBox);
        ComboBoxInitializer.uniformComboBox(uniformComboBox);
    }

    public void menu() {
        this.menuPanel.setLayout(new GridLayout(5, 1));
        this.menuPanel.add(newStuButton);
        this.menuPanel.add(editStuButton);
        this.menuPanel.add(checkStuButton);
        this.menuPanel.add(checkUniButton);
        this.menuPanel.add(quitButton);
        this.refresh(menuPanel);
    }

    public void addStudentMenu() {
        JLabel addNameLabel = new JLabel("Enter Name below");
        addNameLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addDobLabel = new JLabel("Enter Date of Birth below (Format dd-mm-yyyy)");
        addDobLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addEmailLabel = new JLabel("Enter Email below");
        addEmailLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addPhoneLabel = new JLabel("Enter Phone below (Max 10 digits)");
        addPhoneLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addBeltLabel = new JLabel("Select Belt from list");
        addBeltLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addClassLabel = new JLabel("Select Class from list");
        addClassLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JPanel addStuPanel = new JPanel();
        addStuPanel.setLayout(new GridLayout(0, 1));
        addStuPanel.add(addNameLabel);
        addStuPanel.add(addName);
        addStuPanel.add(addDobLabel);
        addStuPanel.add(addDOB);
        addStuPanel.add(addEmailLabel);
        addStuPanel.add(addEmail);
        addStuPanel.add(addPhoneLabel);
        addStuPanel.add(addPhone);
        addStuPanel.add(addBeltLabel);
        addStuPanel.add(beltComboBox);
        addStuPanel.add(addClassLabel);
        addStuPanel.add(classComboBox);
        addStuPanel.add(errorLabel);
        addStuPanel.add(saveButton);
        addStuPanel.add(backButton);
        this.refresh(addStuPanel);
    }

    public void editStudentMenu() {
        JLabel editStuMsg = new JLabel("Enter Student Name to Edit");
        JLabel edtitDetailLabel = new JLabel("Select detail to edit from list or delete student:");
        JLabel detailInputLabel = new JLabel("Enter new value below:");
        JPanel editStuPanel = new JPanel();
        editStuPanel.setLayout(new GridLayout(0, 1));
        editStuPanel.add(editStuMsg);
        editStuPanel.add(studentSearch);
        editStuPanel.add(edtitDetailLabel);
        editStuPanel.add(detailComboBox);
        editStuPanel.add(detailInputLabel);
        editStuPanel.add(detailInput);
        editStuPanel.add(confirmEditButton);
        editStuPanel.add(backButton);
        this.refresh(editStuPanel);
    }

    public void checkStudentListMenu() {
        JLabel checkStuList = new JLabel("Check Student List");
        JPanel checkStuPanel = new JPanel();
        checkStuPanel.setLayout(new GridLayout(0, 1));
        checkStuPanel.add(checkStuList);
        checkStuPanel.add(classComboBox);
        checkStuPanel.add(confirmCheckButton);
        checkStuPanel.add(stuList);
        checkStuPanel.add(backButton);
        this.refresh(checkStuPanel);
    }

    public void checkUniformListMenu() {
        JLabel checkUniList = new JLabel("Check Uniform List");
        JLabel uniformOrderLabel = new JLabel("Enter uniform order you wish to add/delete");
        JLabel uniformSizeLabel = new JLabel("Select Uniform below (in cm):");
        JPanel checkUniPanel = new JPanel();
        checkUniPanel.setLayout(new GridLayout(0, 1));
        checkUniPanel.add(checkUniList);
        checkUniPanel.add(uniformList);
        checkUniPanel.add(uniformOrderLabel);
        checkUniPanel.add(uniformOrder);
        checkUniPanel.add(uniformSizeLabel);
        checkUniPanel.add(uniformComboBox);
        checkUniPanel.add(addUniformButton);
        checkUniPanel.add(deleteUniformButton);
        checkUniPanel.add(backButton);
        this.refresh(checkUniPanel);
    }

    public void addActionListener(ActionListener listener) {
        this.newStuButton.addActionListener(listener);
        this.newStuButton.setActionCommand("ADDMENU");

        this.editStuButton.addActionListener(listener);
        this.editStuButton.setActionCommand("EDITMENU");

        this.checkStuButton.addActionListener(listener);
        this.checkStuButton.setActionCommand("STUDENTMENU");

        this.checkUniButton.addActionListener(listener);
        this.checkUniButton.setActionCommand("UNIFORMMENU");

        this.quitButton.addActionListener(listener);
        this.quitButton.setActionCommand("QUIT");

        this.backButton.addActionListener(listener);
        this.backButton.setActionCommand("MENU");

        this.saveButton.addActionListener(listener);
        this.saveButton.setActionCommand("ADDSTUDENT");

        this.confirmCheckButton.addActionListener(listener);
        this.confirmCheckButton.setActionCommand("CHECKCLASS");

        this.confirmEditButton.addActionListener(listener);
        this.confirmEditButton.setActionCommand("EDITSTUDENT");

        this.addUniformButton.addActionListener(listener);
        this.addUniformButton.setActionCommand("ADDUNIFORM");

        this.deleteUniformButton.addActionListener(listener);
        this.deleteUniformButton.setActionCommand("DELETEUNIFORM");
    }

    public void quitApp() {
        JLabel quitMsg = new JLabel("Program has exited");
        quitMsg.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new GridLayout(1, 1));
        exitPanel.add(quitMsg);
        this.refresh(exitPanel);
    }

    //Helper Function that updates the GUI for the user's perspective
    private void refresh(JPanel panel) {
        this.getContentPane().removeAll();
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        TaekwondoData data = (TaekwondoData) arg;
        this.getUpdate(data, this, Update.valueOf(data.update));
    }

    private void getUpdate(TaekwondoData data, TaekwondoView view, Update update) {
        update.execute(data, view);
    }
}
