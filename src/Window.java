import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Window extends JFrame {
    private Box mainBox;
    private Box box1;
    private Box box2;
    private Box box3;
    private Box box4;
    Window() {
        super("Лабораторная работа 1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main();
        pack();
        setVisible(true);
    }

    void main() {
        mainBox = Box.createVerticalBox();
        Component1();
        Component2();
        Component3();
        Component4();
        mainBox.add(box1);
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(box4);
        setContentPane(mainBox);
    }

    private void Component1() {
        box1 = Box.createHorizontalBox();
        box1.setBorder(new TitledBorder("1-ая группа компонентов"));
        JTextField textField1 = new JTextField(15);
        JComboBox comboBox1 = new JComboBox();
        comboBox1.setPreferredSize(textField1.getPreferredSize());
        JButton button1 = new JButton("Добавить");
        List check = new ArrayList();
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                boolean toAdd = true;
                for (int index = 0; index < check.size(); index++) {
                    if (textField1.getText().equals(check.get(index).toString())) {
                        JOptionPane.showMessageDialog(button1, "Невозможно добавить", "Информация", JOptionPane.ERROR_MESSAGE);
                        toAdd = false;
                    }
                }

                if (toAdd == true) {
                    comboBox1.addItem(textField1.getText());
                    comboBox1.setSelectedItem(textField1.getText());
                    check.add(textField1.getText());
                }
            }

        });
        box1.add(textField1);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(comboBox1);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(button1);
    }

    private void Component2() {
        box2 = Box.createHorizontalBox();
        box2.setBorder(new TitledBorder("2-ая группа компонентов"));
        JTextField textField2 = new JTextField(15);
        JButton button1 = new JButton("Кнопка 1");
        JButton button2 = new JButton("Кнопка 2");
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                button2.setText(textField2.getText());
            }

        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                String buff = new String();
                buff = button1.getText();
                button1.setText(button2.getText());
                button2.setText(buff);
            }
        });
        box2.add(textField2);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(button1);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(button2);
    }

    private void Component3(){
        box3 = Box.createHorizontalBox();
        box3.setBorder(new TitledBorder("3-ая группа компонентов"));
        JTextField textField = new JTextField(10);
        JButton button1 = new JButton("Выбрать");
        JRadioButton radioButton1=new JRadioButton("RadioButton1");
        JRadioButton radioButton2=new JRadioButton("RadioButton2");
        JRadioButton radioButton3=new JRadioButton("RadioButton3");
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().equals("RadioButton1"))
                    radioButton1.setSelected(true);
                else if (textField.getText().equals("RadioButton2"))
                    radioButton2.setSelected(true);
                else if (textField.getText().equals("RadioButton3"))
                    radioButton3.setSelected(true);
                else JOptionPane.showMessageDialog(button1, "Нет такого переключателя", "Информация", JOptionPane.ERROR_MESSAGE);
            }
        });
        box3.add(textField);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(button1);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(radioButton1);
        box3.add(radioButton2);
        box3.add(radioButton3);

    }
    private void Component4(){
        box4 = Box.createHorizontalBox();
        box4.setBorder(new TitledBorder("4-ая группа компонентов"));
        JTextField textField = new JTextField(10);
        JButton button1 = new JButton("Выбрать");
        JCheckBox checkBox1=new JCheckBox("CheckBox1");
        JCheckBox checkBox2=new JCheckBox("CheckBox2");
        JCheckBox checkBox3=new JCheckBox("CheckBox3");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().equals("CheckBox1"))
                    checkBox1.setSelected(true);
                else if (textField.getText().equals("CheckBox2"))
                    checkBox2.setSelected(true);
                else if (textField.getText().equals("CheckBox3"))
                    checkBox3.setSelected(true);
                else JOptionPane.showMessageDialog(button1, "Нет такого флажка", "Информация", JOptionPane.ERROR_MESSAGE);
            }
        });
        box4.add(textField);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(button1);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(checkBox1);
        box4.add(checkBox2);
        box4.add(checkBox3);

    }
}
