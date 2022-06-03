package src;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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
    private final JButton deleteStuButton = new JButton("Delete Student");

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

    public JLabel promptLabel = new JLabel();
    public JLabel stuList = new JLabel("(Student List will appear here)");
    public JLabel uniformList = new JLabel();

    public TaekwondoView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setResizable(false);
        this.menu();
        this.add(menuPanel);
        this.setVisible(true);

        ComboBoxInitializer.beltComboBox(beltComboBox);
        beltComboBox.setFont(new Font("ARIAL", Font.PLAIN, 16));
        ComboBoxInitializer.classComboBox(classComboBox);
        classComboBox.setFont(new Font("ARIAL", Font.PLAIN, 16));
        ComboBoxInitializer.detailComboBox(detailComboBox);
        detailComboBox.setFont(new Font("ARIAL", Font.PLAIN, 16));
        ComboBoxInitializer.uniformComboBox(uniformComboBox);
        uniformComboBox.setFont(new Font("ARIAL", Font.PLAIN, 16));
    }

    public void menu() {
        this.menuPanel.setLayout(new GridLayout(5, 1));
        this.promptLabel.setText("");
        this.menuPanel.add(newStuButton);
        this.menuPanel.add(editStuButton);
        this.menuPanel.add(checkStuButton);
        this.menuPanel.add(checkUniButton);
        this.menuPanel.add(quitButton);
        this.refresh(menuPanel);
    }

    public void addStudentMenu() {
        InputCleaner.cleanAddStudent(this);
        JLabel addStuLabel = new JLabel("Add Student Menu", JLabel.CENTER);
        addStuLabel.setFont(new Font("ARIAL", Font.BOLD, 22));
        JLabel addNameLabel = new JLabel("Enter Name below (MAX 30 Characters)");
        addNameLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JLabel addDobLabel = new JLabel("Enter Date of Birth below (Format dd-mm-yyyy)");
        addDobLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JLabel addEmailLabel = new JLabel("Enter Email below (MAX 40 Characters, must include \'@\')");
        addEmailLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JLabel addPhoneLabel = new JLabel("Enter Phone below (Max 10 digits)");
        addPhoneLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JLabel addBeltLabel = new JLabel("Select Belt from list");
        addBeltLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JLabel addClassLabel = new JLabel("Select Class from list");
        addClassLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JPanel addStuPanel = new JPanel();
        addStuPanel.setLayout(new GridLayout(0, 1));
        addStuPanel.add(addStuLabel);
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
        addStuPanel.add(promptLabel);
        promptLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        addStuPanel.add(saveButton);
        addStuPanel.add(backButton);
        this.refresh(addStuPanel);
    }

    public void editStudentMenu() {
        InputCleaner.cleanEditStudent(this);
        JLabel editStudentLabel = new JLabel("Edit Student Menu", JLabel.CENTER);
        editStudentLabel.setFont(new Font("ARIAL", Font.BOLD, 22));
        JLabel editStuMsg = new JLabel("Enter Student Name to Edit (MAX 30 Characters)");
        editStuMsg.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JLabel edtitDetailLabel = new JLabel("Select detail to edit from list or delete student:");
        edtitDetailLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JLabel detailInputLabel = new JLabel("Enter new value below (Or leave blank to delete):");
        detailInputLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JPanel editStuPanel = new JPanel();
        editStuPanel.setLayout(new GridLayout(0, 1));
        editStuPanel.add(editStudentLabel);
        editStuPanel.add(editStuMsg);
        editStuPanel.add(studentSearch);
        editStuPanel.add(edtitDetailLabel);
        editStuPanel.add(detailComboBox);
        editStuPanel.add(detailInputLabel);
        editStuPanel.add(detailInput);
        editStuPanel.add(promptLabel);
        promptLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        editStuPanel.add(confirmEditButton);
        editStuPanel.add(deleteStuButton);
        editStuPanel.add(backButton);
        this.refresh(editStuPanel);
    }

    public void checkStudentListMenu() {
        JLabel checkStuList = new JLabel("Check Student List", JLabel.CENTER);
        checkStuList.setFont(new Font("ARIAL", Font.BOLD, 22));
        JPanel checkStuPanel = new JPanel();
        checkStuPanel.setLayout(new GridLayout(0, 1));
        checkStuPanel.add(checkStuList);
        checkStuPanel.add(classComboBox);
        checkStuPanel.add(confirmCheckButton);
        checkStuPanel.add(stuList);
        stuList.setFont(new Font("ARIAL", Font.PLAIN, 18));
        checkStuPanel.add(backButton);
        this.refresh(checkStuPanel);
    }

    public void checkUniformListMenu() {
        InputCleaner.cleanOrderMenu(this);
        JLabel checkUniList = new JLabel("Check Uniform List", JLabel.CENTER);
        checkUniList.setFont(new Font("ARIAL", Font.BOLD, 22));
        JLabel uniformOrderLabel = new JLabel("Enter uniform order you wish to add/delete");
        uniformOrderLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JLabel uniformSizeLabel = new JLabel("Select Uniform below (in cm):");
        uniformSizeLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
        JPanel checkUniPanel = new JPanel();
        checkUniPanel.setLayout(new GridLayout(0, 1));
        checkUniPanel.add(checkUniList);
        checkUniPanel.add(uniformList);
        uniformList.setFont(new Font("ARIAL", Font.PLAIN, 18));
        checkUniPanel.add(uniformOrderLabel);
        checkUniPanel.add(uniformOrder);
        checkUniPanel.add(uniformSizeLabel);
        checkUniPanel.add(uniformComboBox);
        checkUniPanel.add(promptLabel);
        promptLabel.setFont(new Font("ARIAL", Font.PLAIN, 22));
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
        this.deleteStuButton.addActionListener(listener);
        this.deleteStuButton.setActionCommand("DELETESTUDENT");
    }

    public void quitApp() {
        JLabel quitMsg = new JLabel("Program has exited", JLabel.CENTER);
        quitMsg.setFont(new Font("ARIAL", Font.BOLD, 50));
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

    //Helper function that gets the intended update
    private void getUpdate(TaekwondoData data, TaekwondoView view, Update update) {
        update.execute(data, view);
    }
}
