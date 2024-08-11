package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private Calculator calculator;
    private String currentOp;
    private double firstOperand;

    public CalculatorGUI() {
        calculator = new Calculator();
        currentOp = "";
        firstOperand = 0;

        setTitle("Advanced Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sqrt", "pow", "sin", "cos",
            "tan", "!", "C", "CE"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "C":
                    display.setText("");
                    break;
                case "CE":
                    currentOp = "";
                    firstOperand = 0;
                    display.setText("");
                    break;
                case "=":
                    calculate();
                    currentOp = "";
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "pow":
                    firstOperand = Double.parseDouble(display.getText());
                    currentOp = command;
                    display.setText("");
                    break;
                case "sqrt":
                    display.setText(String.valueOf(calculator.sqrt(Double.parseDouble(display.getText()))));
                    break;
                case "sin":
                    display.setText(String.valueOf(calculator.sin(Double.parseDouble(display.getText()))));
                    break;
                case "cos":
                    display.setText(String.valueOf(calculator.cos(Double.parseDouble(display.getText()))));
                    break;
                case "tan":
                    display.setText(String.valueOf(calculator.tan(Double.parseDouble(display.getText()))));
                    break;
                case "!":
                    int value = Integer.parseInt(display.getText());
                    display.setText(String.valueOf(calculator.factorial(value)));
                    break;
                default:
                    display.setText(display.getText() + command);
                    break;
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    private void calculate() {
        double secondOperand = Double.parseDouble(display.getText());
        double result = 0;

        switch (currentOp) {
            case "+":
                result = calculator.add(firstOperand, secondOperand);
                break;
            case "-":
                result = calculator.subtract(firstOperand, secondOperand);
                break;
            case "*":
                result = calculator.multiply(firstOperand, secondOperand);
                break;
            case "/":
                result = calculator.divide(firstOperand, secondOperand);
                break;
            case "pow":
                result = calculator.power(firstOperand, secondOperand);
                break;
        }

        display.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculatorGUI = new CalculatorGUI();
            calculatorGUI.setVisible(true);
        });
    }
}
