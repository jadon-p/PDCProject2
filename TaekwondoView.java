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

    private final JButton newStuButton = new JButton("Add Student");
    private final JButton editStuButton = new JButton("Edit Student");
    private final JButton checkStuButton = new JButton("Check Student List");
    private final JButton checkUniButton = new JButton("Check Uniform Orders");
    private final JButton quitButton = new JButton("Quit");
    private final JButton backButton = new JButton("Return to Menu");
    private final JButton saveButton = new JButton("Save Student");
    private final JButton confirmEditButton = new JButton("Confirm Edit Student");
    private final JButton confirmCheckButton = new JButton("Check Class");
    private final JButton addUniform = new JButton("Add Uniform Order");
    private final JButton deleteUniform = new JButton("Delete Uniform Order");

    private final JTextField addName = new JTextField(30);
    private final JTextField addDOB = new JTextField(10);
    private final JTextField addEmail = new JTextField(30);
    private final JTextField addPhone = new JTextField(10);
    private final JTextField studentSearch = new JTextField(30);
    private final JTextField uniformOrder = new JTextField(30);

    private final JComboBox beltComboBox = new JComboBox();
    private final JComboBox classComboBox = new JComboBox();
    private final JComboBox detailComboBox = new JComboBox();

    public TaekwondoView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.menuPanel.setLayout(new GridLayout(5, 1));
        this.menuPanel.add(newStuButton);
        this.menuPanel.add(editStuButton);
        this.menuPanel.add(checkStuButton);
        this.menuPanel.add(checkUniButton);
        this.menuPanel.add(quitButton);
        this.add(menuPanel);
        this.setVisible(true);
    }

    private void menu() {
        this.menuPanel.setLayout(new GridLayout(5, 1));
        this.menuPanel.add(newStuButton);
        this.menuPanel.add(editStuButton);
        this.menuPanel.add(checkStuButton);
        this.menuPanel.add(checkUniButton);
        this.menuPanel.add(quitButton);
        this.getContentPane().removeAll();
        this.add(menuPanel);
        this.revalidate();
        this.repaint();
    }

    public void addStudentMenu() {
        GridLayout layout = new GridLayout(0, 1);
        JLabel addNameLabel = new JLabel("Enter Name below:");
        addNameLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addDobLabel = new JLabel("Enter Date of Birth below:");
        addDobLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addEmailLabel = new JLabel("Enter Email below:");
        addEmailLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addPhoneLabel = new JLabel("Enter Phone below:");
        addPhoneLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addBeltLabel = new JLabel("Select Belt from list:");
        addBeltLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JLabel addClassLabel = new JLabel("Select Class from list:");
        addClassLabel.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JPanel addStuPanel = new JPanel();
        addStuPanel.setLayout(layout);
        layout.setVgap(5);
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
        beltComboBox.addItem("White");
        beltComboBox.addItem("Yellow Tip");
        beltComboBox.addItem("Yellow");
        beltComboBox.addItem("Orange");
        beltComboBox.addItem("Green");
        beltComboBox.addItem("Blue");
        beltComboBox.addItem("Purple");
        beltComboBox.addItem("Brown");
        beltComboBox.addItem("Red");
        beltComboBox.addItem("Black Tip");
        beltComboBox.addItem("Black");
        addStuPanel.add(addClassLabel);
        addStuPanel.add(classComboBox);
        classComboBox.addItem("Little Kiwi");
        classComboBox.addItem("Dragon");
        classComboBox.addItem("Tiger");
        classComboBox.addItem("Adults");
        addStuPanel.add(saveButton);
        addStuPanel.add(backButton);
        this.getContentPane().removeAll();
        this.add(addStuPanel);
        this.revalidate();
        this.repaint();
    }

    public void editStudentMenu() {
        JLabel editStuMsg = new JLabel("Enter Student Name to Edit");
        JLabel edtitDetailLabel = new JLabel("Select detail to edit from list:");
        JPanel editStuPanel = new JPanel();
        editStuPanel.setLayout(new GridLayout(0, 1));
        editStuPanel.add(editStuMsg);
        editStuPanel.add(studentSearch);
        editStuPanel.add(edtitDetailLabel);
        detailComboBox.addItem("Name");
        detailComboBox.addItem("Date of Birth");
        detailComboBox.addItem("Email");
        detailComboBox.addItem("Phone");
        detailComboBox.addItem("Belt level");
        editStuPanel.add(detailComboBox);
        editStuPanel.add(confirmEditButton);
        editStuPanel.add(backButton);
        this.getContentPane().removeAll();
        this.add(editStuPanel);

        this.revalidate();
        this.repaint();
    }

    public void checkStudentListMenu() {
        JLabel checkStuList = new JLabel("Check Student List");
        JLabel stuList = new JLabel("(Student List will appear here)");
        JPanel checkStuPanel = new JPanel();
        checkStuPanel.setLayout(new GridLayout(0, 1));
        checkStuPanel.add(checkStuList);
        checkStuPanel.add(classComboBox);
        classComboBox.addItem("Little Kiwi");
        classComboBox.addItem("Dragon");
        classComboBox.addItem("Tiger");
        classComboBox.addItem("Adults");
        checkStuPanel.add(confirmCheckButton);
        checkStuPanel.add(stuList);
        checkStuPanel.add(backButton);
        this.getContentPane().removeAll();
        this.add(checkStuPanel);
        this.revalidate();
        this.repaint();
    }

    public void checkUniformListMenu() {
        JLabel checkUniList = new JLabel("Check Uniform List");
        JLabel uniformList = new JLabel("(This is where the uniform orders will show)");
        JLabel uniformOrderLabel = new JLabel("Enter uniform order you wish to add/delete");
        JPanel checkUniPanel = new JPanel();
        checkUniPanel.setLayout(new GridLayout(0, 1));
        checkUniPanel.add(checkUniList);
        checkUniPanel.add(uniformList);
        checkUniPanel.add(uniformOrderLabel);
        checkUniPanel.add(uniformOrder);
        checkUniPanel.add(addUniform);
        checkUniPanel.add(deleteUniform);
        checkUniPanel.add(backButton);
        this.getContentPane().removeAll();
        this.add(checkUniPanel);
        this.revalidate();
        this.repaint();
    }

    public void addActionListener(ActionListener listener) {
        this.newStuButton.addActionListener(listener);
        this.editStuButton.addActionListener(listener);
        this.checkStuButton.addActionListener(listener);
        this.checkUniButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
        this.saveButton.addActionListener(listener);
    }

    private void quitApp() {
        JLabel quitMsg = new JLabel("Program has exited");
        quitMsg.setFont(new Font("ARIAL", Font.PLAIN, 25));
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new GridLayout(1, 1));
        exitPanel.add(quitMsg);
        this.getContentPane().removeAll();
        this.add(exitPanel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        TaekwondoData data = (TaekwondoData) arg;
        if (data.didQuit) {
            this.quitApp();
        } else if (data.addStu) {
            this.addStudentMenu();
            data.addStu = false;
        } else if (data.openMenu) {
            this.menu();
            data.openMenu = false;
        } else if (data.editStu) {
            this.editStudentMenu();
            data.editStu = false;
        } else if (data.checkStuList) {
            this.checkStudentListMenu();
            data.checkStuList = false;
        } else if (data.checkUniList) {
            this.checkUniformListMenu();
            data.checkUniList = false;
        } else if (data.studentSaved) {
            this.menu();
            data.studentSaved = false;
        }

    }
}
