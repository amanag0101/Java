import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

class AppFrame extends JFrame implements ActionListener {
    private final JMenuBar menuBar;
    private final JMenu file;   
    private final JMenu edit;
    private final JMenu help;
    private final JMenuItem cut;
    private final JMenuItem copy;
    private final JMenuItem paste;
    private final JDialog dialog;

    AppFrame() {
        // MenuBar
        cut = new JMenuItem("Cut");
        cut.addActionListener(this);
        copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        paste = new JMenuItem("Paste");
        paste.addActionListener(this);

        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        // Popup menu
        dialog = new JDialog(this, "Dialog", true);
        dialog.setSize(200, 100);
        dialog.add(new JButton("OK"));

        setJMenuBar(menuBar);
        add(new AppPanel());

        setTitle("Java Swing");
        setSize(800, 600);
        // setResizable(false);
        // pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cut)
            dialog.setVisible(true);
    }
}

class AppPanel extends JPanel implements ActionListener {
    private final JButton button1;
    private final JTextField textField1;
    private final JPasswordField passwordField;

    private final JCheckBox checkBox1;
    private final JCheckBox checkBox2;

    private final ButtonGroup buttonGroup;
    private final JRadioButton radioButton1;
    private final JRadioButton radioButton2;

    private final JComboBox comboBox;
    private final JList list;

    private final JLabel label1;
    private final JLabel label2;

    AppPanel() {
        setBackground(Color.ORANGE);
        
        textField1 = new JTextField("username");
        passwordField = new JPasswordField("Password");
        passwordField.setEditable(false);
        passwordField.setToolTipText("Enter Password");

        button1 = new JButton("Button1");
        button1.addActionListener(this);

        checkBox1 = new JCheckBox("Java", true);
        checkBox2 = new JCheckBox("C++", false);

        buttonGroup = new ButtonGroup();
        radioButton1 = new JRadioButton("Male");
        radioButton2 = new JRadioButton("Female");
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        String[] countries = {"India", "USA", "England"};
        comboBox = new JComboBox(countries);

        list = new JList(countries);

        label1 = new JLabel("Label");
        label2 = new JLabel("Label");

        // setLayout(new GridLayout(3, 1));
        add(textField1);
        add(passwordField);
        add(button1);
        add(checkBox1);
        add(checkBox2);
        add(radioButton1);
        add(radioButton2);
        add(comboBox);
        add(list);
        add(label1);
        add(label2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(textField1.getText());
        System.out.println(list.getSelectedValuesList());

        if(e.getSource() == button1) {
            if(checkBox1.isSelected())
                label1.setText("Java");
            else if(checkBox2.isSelected())
                label1.setText("C++");

            if(radioButton1.isSelected())
                JOptionPane.showMessageDialog(this, "Male");
            else if(radioButton2.isSelected())
                label2.setText("Female");

            label2.setText(comboBox.getSelectedItem().toString());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new AppFrame();
    }
}