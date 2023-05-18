import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class AppFrame extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu file;
    private JMenu edit;
    private JMenuItem item1, item2, item3;

    AppFrame() {
        file = new JMenu("File");
        edit = new JMenu("Edit");
        menuBar = new JMenuBar();
        item1 = new JMenuItem("Item 1");
        item2 = new JMenuItem("Item 2");
        item3 = new JMenuItem("Item 3");

        menuBar.add(file);
        menuBar.add(edit);
        file.add(item1);
        file.add(item2);
        file.add(item3);
        setJMenuBar(menuBar);

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("SWING");
        add(new AppPanel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == item1)
            System.out.println("Item 1");

        if(e.getSource() == item2)
            System.out.println("Item 2");

        if(e.getSource() == item3)
            System.out.println("Item 3");
    }
}

class AppPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
    private final JButton button;
    private final JTextField textField;

    AppPanel() {
        button = new JButton("Submit");
        textField = new JTextField("type something");

        add(button);
        add(textField);

        textField.addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        button.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(400, 300, 30, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println("Button Clicked!");
            System.out.println(textField.getText());
            JOptionPane.showMessageDialog(this, textField.getText());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
        System.out.println(e.getX() + " " + e.getY());

        Graphics g=getGraphics();  
        g.setColor(Color.BLUE);  
        g.drawOval(e.getX(), e.getY(), 30, 30);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Dragged");
        System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released");
    }
}

public class Main1 {
   public static void main(String[] args) {
        new AppFrame().setVisible(true);
   } 
}
