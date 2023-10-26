import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {
    private final JPanel panel;
    private final JTextField display;
    private double memory = 0;
    private String operator = "";
    private boolean newInput = true;

    public CalculatorGUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        panel = new JPanel(new GridLayout(5, 4));
        frame.add(panel);

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        panel.add(display);

        addButton("7");
        addButton("8");
        addButton("9");
        addButton("/");
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("*");
        addButton("1");
        addButton("2");
        addButton("3");
        addButton("-");
        addButton("0");
        addButton(".");
        addButton("=");
        addButton("+");
        addButton("√");
        addButton("^");

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }

    private void addButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        button.addActionListener(e -> handleButtonClick(label));
        panel.add(button);
    }

    private void handleButtonClick(String label) {
        if (label.matches("[0-9.]")) {
            if (newInput) {
                display.setText(label);
                newInput = false;
            } else {
                display.setText(display.getText() + label);
            }
        } else if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/")) {
            operator = label;
            memory = Double.parseDouble(display.getText());
            newInput = true;
        } else if (label.equals("=")) {
            double currentValue = Double.parseDouble(display.getText());
            switch (operator) {
                case "+" -> memory += currentValue;
                case "-" -> memory -= currentValue;
                case "*" -> memory *= currentValue;
                case "/" -> {
                    if (currentValue != 0) {
                        memory /= currentValue;
                    } else {
                        display.setText("Error");
                        newInput = true;
                        return;
                    }
                }
            }
            display.setText(String.valueOf(memory));
            newInput = true;
        } else if (label.equals("√")) {
            double currentValue = Double.parseDouble(display.getText());
            if (currentValue >= 0) {
                double result = Math.sqrt(currentValue);
                display.setText(String.valueOf(result));
            } else {
                display.setText("Error");
                newInput = true;
            }
        } else if (label.equals("^")) {
            double currentValue = Double.parseDouble(display.getText());
            double result = Math.pow(memory, currentValue);
            display.setText(String.valueOf(result));
            newInput = true;
        }
    }
}
