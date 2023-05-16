import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Program extends JFrame {

    Program(String name){
        super(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        String[] colorList = {"Red", "Green", "Blue"};
        Program frame = new Program("JComboBox");
        JCheckBox checkBox = new JCheckBox();
        JComboBox comboBox = new JComboBox(colorList);
        JTextField textField = new JTextField();
        JButton button = new JButton("Answer");
        JLabel label = new JLabel("What's your favorite color? - ");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(comboBox, gbc);

        panel.setSize(300, 300);
        textField.setEnabled(false);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(checkBox, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, gbc);

        gbc.gridy = 3;
        panel.add(button, gbc);

        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(label, gbc);

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected())
                    textField.setEnabled(true);
                else {
                    textField.setEnabled(false);
                    textField.setText("");
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    label.setText("What's your favorite color? - " + textField.getText());
                }
                else {
                    label.setText("What's your favorite color? - " + comboBox.getSelectedItem());
                }
            }
        });


        frame.add(panel);
        frame.setSize(panel.getSize());
        frame.setVisible(true);

    }
}
