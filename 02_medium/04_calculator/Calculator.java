import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator extends JFrame implements ActionListener {
    // Create a frame
    private static JFrame frame;

    // Create a textfield
    private static JTextField textField;

    // Store operator and operands
    private String num1, operator, num2;

    // Default constructor
    public Calculator() {
        num1 = num2 = operator = "";
    }

    // Main function
    public static void main(String[] args) {
        // Create a frame
        frame = new JFrame("Calculator");

        try {
            // Set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Create an instance of the Calculator class
        Calculator calculator = new Calculator();

        // Create a textfield
        textField = new JTextField(16);

        // Set the textfield to non-editable
        textField.setEditable(false);

        // Create buttons for numbers, operators, and equals
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
        }
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton equalsButton = new JButton("=");
        JButton clearButton = new JButton("C");
        JButton decimalButton = new JButton(".");

        // Create a panel
        JPanel panel = new JPanel();

        // Add action listeners to buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(calculator);
        }
        addButton.addActionListener(calculator);
        subtractButton.addActionListener(calculator);
        multiplyButton.addActionListener(calculator);
        divideButton.addActionListener(calculator);
        equalsButton.addActionListener(calculator);
        clearButton.addActionListener(calculator);
        decimalButton.addActionListener(calculator);

        // Add elements to the panel
        panel.add(textField);
        panel.add(addButton);
        for (int i = 1; i < 10; i++) {
            panel.add(numberButtons[i]);
            if (i % 3 == 0) {
                if (i < 9) {
                    panel.add(addButton);
                } else {
                    panel.add(equalsButton);
                }
            }
        }
        panel.add(numberButtons[0]);
        panel.add(clearButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(decimalButton);
        panel.add(equalsButton);

        // Set the background color of the panel
        panel.setBackground(Color.blue);

        // Add the panel to the frame
        frame.add(panel);

        frame.setSize(200, 220);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If the value is a number or a decimal point
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
            // If an operator is present, add to the second number
            if (!operator.equals("")) {
                num2 += command;
            } else {
                num1 += command;
            }

            // Set the value of the text
            textField.setText(num1 + operator + num2);
        } else if (command.equals("C")) {
            // Clear the input
            num1 = num2 = operator = "";

            // Set the value of the text
            textField.setText(num1 + operator + num2);
        } else if (command.equals("=")) {
            try {
                double result = evaluateExpression(num1, operator, num2);

                // Set the value of the text
                textField.setText(num1 + operator + num2 + "=" + result);

                // Convert the result to string
                num1 = Double.toString(result);
                operator = num2 = "";
            } catch (ArithmeticException ex) {
                textField.setText("Error");
                num1 = operator = num2 = "";
            }
        } else {
            // If there was no operator or the second number, set the operator
            if (operator.equals("") || num2.equals("")) {
                operator = command;
            } else {
                try {
                    double result = evaluateExpression(num1, operator, num2);

                    // Convert the result to string
                    num1 = Double.toString(result);

                    // Set the operator
                    operator = command;

                    // Make the second number blank
                    num2 = "";
                } catch (ArithmeticException ex) {
                    textField.setText("Error");
                    num1 = operator = num2 = "";
                }
            }

            // Set the value of the text
            textField.setText(num1 + operator + num2);
        }
    }

    private double evaluateExpression(String num1, String operator, String num2) {
        double result = 0;
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);

        if (operator.equals("+")) {
            result = n1 + n2;
        } else if (operator.equals("-")) {
            result = n1 - n2;
        } else if (operator.equals("*")) {
            result = n1 * n2;
        } else if (operator.equals("/")) {
            if (n2 == 0) {
                throw new ArithmeticException("Division by zero");
            } else {
                result = n1 / n2;
            }
        }

        return result;
    }
}