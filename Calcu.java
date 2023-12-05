/*
It takes two numbers as input and performs an operation on them, such as addition, subtraction, multiplication, division, or modulo. The result is then displayed on the screen.

The algorithm works as follows:

The algorithm first creates a new instance of the CalcMain class. This class contains all of the code for the calculator.
The CalcMain constructor creates a new JFrame window and sets its properties.
The constructor then creates all of the buttons and text fields that the calculator will need.
The constructor then adds the buttons and text fields to the JFrame window.
The constructor then sets the visibility of the JFrame window to true.
The actionPerformed method is called whenever a button is clicked.
The actionPerformed method first checks to see which button was clicked.
If a number button was clicked, the method appends the number to the text field.
If the point button was clicked, the method appends a decimal point to the text field.
If an operator button was clicked, the method stores the number that is currently in the text field and the operator. The text field is then cleared.
If the equals button was clicked, the method stores the number that is currently in the text field. The method then performs the operation that was specified by the operator. The result is then displayed in the text field.
If the CLR button was clicked, the text field is cleared.
If the DEL button was clicked, the last character is removed from the text field.
If the NEG button was clicked, the number in the text field is negated.
The algorithm is well-structured and easy to understand. It is also easy to modify to add new features, such as support for more operations or parentheses
*/import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CalcMain extends JFrame implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton numberButtons[] = new JButton[10];
    JButton functionButtons[] = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, modButton;
    JButton pointButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Consolas", Font.BOLD, 20);
    Font buttonFont = new Font("Consolas", Font.BOLD, 20);
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    CalcMain() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,450);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setLayout(null);
        frame.setResizable(false);
    
        textField = new JTextField();
        textField.setBackground(Color.darkGray);
        textField.setForeground(Color.white);
        textField.setBounds(20, 25, 300, 50);
        textField.setFont(myFont);
        textField.setCaretColor(Color.white);
        textField.setBorder(BorderFactory.createLineBorder(Color.CYAN,2));
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        pointButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = pointButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = modButton;

        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(buttonFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(0x191919));
            functionButtons[i].setForeground(Color.white);
            functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.orange, 2));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(buttonFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(0x191919));
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.white, 2));
        }

        clrButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
        delButton.setBorder(BorderFactory.createLineBorder(Color.red,2));

        panel = new JPanel();
        panel.setBounds(20, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.darkGray);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(pointButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(modButton);
        panel.add(negButton);
        panel.add(clrButton);
        panel.add(delButton);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int err = 0;

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == pointButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    try {
                        if (num2 == 0) {
                            err = 1;
                            throw (new ArithmeticException("Error: Division by zero!"));
                        }
                        result = num1 / num2;
                    } catch (ArithmeticException error) {
                        textField.setText(error.getMessage());
                    }
                    break;

                case '%':
                try {
                    if (num2 == 0) {
                        err = 1;
                        throw (new ArithmeticException("Error: Division by zero!"));
                    }
                    result = num1 % num2;
                } catch (ArithmeticException error) {
                    textField.setText(error.getMessage());
                }
                    break;

                default:
                    result = Double.parseDouble(textField.getText());
            }

            if (err == 0) {
                textField.setText(String.valueOf(result));
                num1 = result;
            }
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");

            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}

public class Calcu{
    public static void main(String[] args) {
        new CalcMain();
    }
}
