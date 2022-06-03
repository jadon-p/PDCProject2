package src;

import javax.swing.JComboBox;

/**
 *
 * @author pfn3947
 */
public class ComboBoxInitializer {

    //Adds belt to the beltCombobBox
    public static void beltComboBox(JComboBox comboBox) {
        comboBox.addItem("White");
        comboBox.addItem("Yellow Tip");
        comboBox.addItem("Yellow");
        comboBox.addItem("Orange");
        comboBox.addItem("Green");
        comboBox.addItem("Blue");
        comboBox.addItem("Purple");
        comboBox.addItem("Brown");
        comboBox.addItem("Red");
        comboBox.addItem("Black Tip");
        comboBox.addItem("Black");
    }

    //Adds the class names to the classComboBox
    public static void classComboBox(JComboBox comboBox) {
        comboBox.addItem("LittleKiwi");
        comboBox.addItem("Dragon");
        comboBox.addItem("Tiger");
        comboBox.addItem("Adults");
    }

    //Adds the details to the details CombobBox
    public static void detailComboBox(JComboBox comboBox) {
        comboBox.addItem("Name");
        comboBox.addItem("Date of Birth");
        comboBox.addItem("Email");
        comboBox.addItem("Phone");
        comboBox.addItem("Belt");
        comboBox.addItem("Class");
    }

    //Adds the uniform sizes to the uniformComboBox
    public static void uniformComboBox(JComboBox comboBox) {
        comboBox.addItem("100");
        comboBox.addItem("110");
        comboBox.addItem("120");
        comboBox.addItem("130");
        comboBox.addItem("140");
        comboBox.addItem("150");
        comboBox.addItem("160");
        comboBox.addItem("170");
        comboBox.addItem("180");
        comboBox.addItem("190");
        comboBox.addItem("200");
    }
}
