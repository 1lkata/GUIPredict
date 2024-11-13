import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_1 implements ActionListener {

    JFrame frame;
    JPanel numberPanel, buttonPanel, outputPanel;
    JLabel firstNumLabel, secondNumLabel, success;
    JTextField firstNumField, secondNumField;
    JButton plusButton, minusButton, divideButton, multiplyButton, resetButton;

    public GUI_1() {
        frame = new JFrame("Simple Calculator");
        frame.setSize(600, 350);
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        numberPanel = new JPanel(new FlowLayout());
        buttonPanel = new JPanel(new FlowLayout());
        outputPanel = new JPanel(new FlowLayout());

        firstNumLabel = new JLabel("First Number:");
        firstNumLabel.setFont(new Font("Arial", Font.BOLD, 16));
        firstNumField = new JTextField(10);
        firstNumField.setFont(new Font("Arial", Font.PLAIN, 16));

        secondNumLabel = new JLabel("Second Number:");
        secondNumLabel.setFont(new Font("Arial", Font.BOLD, 16));
        secondNumField = new JTextField(10);
        secondNumField.setFont(new Font("Arial", Font.PLAIN, 16));

        numberPanel.add(firstNumLabel);
        numberPanel.add(firstNumField);
        numberPanel.add(secondNumLabel);
        numberPanel.add(secondNumField);

        plusButton = createStyledButton("+");
        minusButton = createStyledButton("-");
        multiplyButton = createStyledButton("*");
        divideButton = createStyledButton("/");
        resetButton = createStyledButton("Reset");
        resetButton.setPreferredSize(new Dimension(100, 40));

        buttonPanel.add(plusButton);
        buttonPanel.add(minusButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(resetButton);

        success = new JLabel(" ");
        success.setFont(new Font("Impact", Font.ITALIC, 18));
        success.setForeground(new Color(0, 128, 0));

        outputPanel.add(success);

        frame.setLayout(new BorderLayout());
        frame.add(numberPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(outputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(80, 40));
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            firstNumField.setText("");
            secondNumField.setText("");
            success.setText("");
            success.setForeground(new Color(0, 128, 0));
        } else {
            String first = firstNumField.getText();
            String second = secondNumField.getText();

            if (!first.isEmpty() && !second.isEmpty()) {
                try {
                    double num1 = Double.parseDouble(first);
                    double num2 = Double.parseDouble(second);
                    double result = 0;

                    if (e.getSource() == plusButton) {
                        result = num1 + num2;
                    } else if (e.getSource() == minusButton) {
                        result = num1 - num2;
                    } else if (e.getSource() == multiplyButton) {
                        result = num1 * num2;
                    } else if (e.getSource() == divideButton) {
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            success.setForeground(Color.RED);
                            success.setText("Cannot divide by zero");
                            return;
                        }
                    }

                    success.setForeground(new Color(0, 128, 0));
                    success.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    success.setForeground(Color.RED);
                    success.setText("Invalid input, please enter numbers");
                }
            } else {
                success.setForeground(Color.RED);
                success.setText("Please enter both numbers");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI_1::new);
    }
}
