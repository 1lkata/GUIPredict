import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    public GUI() {
        frame = new JFrame();
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonReset = new JButton("Reset");
        buttonReset.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonPlus.addActionListener(this);
        label = new JLabel("Number of clicks: 0");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(3,1));
        panel.add(label);
        panel.add(buttonPlus);
        panel.add(buttonMinus);
        panel.add(buttonReset);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("+")) {
            count++;
            label.setText("Number of clicks: " + count);
        }
        if (e.getActionCommand().equals("-")) {
            count--;
            label.setText("Number of clicks: " + count);
        }
        if (e.getActionCommand().equals("Reset")) {
            count = 0;
            label.setText("Number of clicks: " + count);
        }
    }
}
