import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField textField1, textField2, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modButton;

    public SimpleCalculator() {
        setTitle("Kalkulator Sederhana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label1 = new JLabel("Angka 1:");
        label1.setBounds(50, 30, 100, 30);
        add(label1);

        textField1 = new JTextField();
        textField1.setBounds(150, 30, 200, 30);
        add(textField1);

        JLabel label2 = new JLabel("Angka 2:");
        label2.setBounds(50, 70, 100, 30);
        add(label2);

        textField2 = new JTextField();
        textField2.setBounds(150, 70, 200, 30);
        add(textField2);

        addButton = new JButton("+");
        addButton.setBounds(50, 110, 50, 30);
        addButton.addActionListener(this);
        add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(110, 110, 50, 30);
        subtractButton.addActionListener(this);
        add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(170, 110, 50, 30);
        multiplyButton.addActionListener(this);
        add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.setBounds(230, 110, 50, 30);
        divideButton.addActionListener(this);
        add(divideButton);

        modButton = new JButton("mod");
        modButton.setBounds(290, 110, 70, 30);
        modButton.addActionListener(this);
        add(modButton);

        JLabel resultLabel = new JLabel("Hasil:");
        resultLabel.setBounds(50, 150, 100, 30);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(150, 150, 200, 30);
        resultField.setEditable(false);
        add(resultField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            } else if (e.getSource() == modButton) {
                result = num1 % num2;
            }

            if (result == (int) result) {
                resultField.setText(String.valueOf((int) result));
            } else {
                resultField.setText(String.valueOf(result));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setVisible(true);
    }
}
