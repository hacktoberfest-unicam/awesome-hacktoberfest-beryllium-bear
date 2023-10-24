import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JPanel panel;
    private JTextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public Calculator() {
        //creazione parte gui
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        display = new JTextField(10);
        display.setEditable(false);
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        frame.add(display, BorderLayout.NORTH);
        frame.add(panel);

        //aggiunta dei pulsanti
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

        frame.setVisible(true);
    }
    //definisco qui la funzione per aggiungere un bottone
    private void addButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(label);
            }
        });
        panel.add(button);
    }

    //evento quando viene premuto un bottone
    private void buttonClick(String label) {
        if (label.matches("[0-9]")) { // controllo se è un numero e setto il numero in questione
            if (startNewInput) {
                display.setText(label);
                startNewInput = false;
            } else {
                display.setText(display.getText() + label);
            }
        } else if (label.equals(".")) { //controllo se si tratta di una virgola
            if (startNewInput) {
                display.setText("0.");//nel caso bib ci siano numeri setto lo 0,
                startNewInput = false;
            } else if (!display.getText().contains(".")) {
                display.setText(display.getText() + label);
            }
        } else if (label.equals("=")) { //se è l'uguale restituisco il risultato
            if (!operator.isEmpty()) {
                double num2 = Double.parseDouble(display.getText());
                double result = 0;
                switch (operator) { // negli altri casi devo distinguere il tipo di operazione
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }
                display.setText(Double.toString(result));
                startNewInput = true;
                operator = "";
            }
        } else {
            if (!operator.isEmpty()) {
                return;
            }
            num1 = Double.parseDouble(display.getText());
            operator = label;
            startNewInput = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator(); //chiamo la classe per far iniziare il programma
            }
        });
    }
}
