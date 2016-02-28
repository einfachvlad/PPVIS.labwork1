import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Window {
    JFrame window;
    Box boxOfComponent1;
    Box boxOfComponent2;
    Box boxOfComponent3;
    Box boxOfComponent4;
    Box box51;
    int rowSize = 1;

    Window() {
        window = new JFrame("Лабораторная работа 1");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        components();
        window.pack();
        window.setVisible(true);
    }

    private void components() {
        Box mainBox = Box.createVerticalBox();
        mainBox.add(component1());
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(component2());
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(component3());
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(component4());
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(component5());
        mainBox.add(extraThing());

        window.setContentPane(mainBox);
    }

    private Box component1() {
         boxOfComponent1 = Box.createHorizontalBox();
        boxOfComponent1.setBorder(new TitledBorder("1-ая группа компонентов"));
        JTextField input = new JTextField(15);
        JComboBox comboBoxOfComponent1 = new JComboBox();
        comboBoxOfComponent1.setPreferredSize(input.getPreferredSize());
        List check = new ArrayList();
        JButton addOfComponent1 = new JButton("Добавить");
        addOfComponent1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                boolean toAdd = true;
                for (int index = 0; index < check.size(); index++) {
                    if (input.getText().equals(check.get(index).toString())) {
                        JOptionPane.showMessageDialog(addOfComponent1, "Невозможно добавить", "Информация", JOptionPane.ERROR_MESSAGE);
                        toAdd = false;
                    }
                }

                if (toAdd == true) {
                    comboBoxOfComponent1.addItem(input.getText());
                    comboBoxOfComponent1.setSelectedItem(input.getText());
                    check.add(input.getText());
                }
            }

        });
        boxOfComponent1.add(input);
        boxOfComponent1.add(Box.createHorizontalStrut(6));
        boxOfComponent1.add(comboBoxOfComponent1);
        boxOfComponent1.add(Box.createHorizontalStrut(6));
        boxOfComponent1.add(addOfComponent1);
        return boxOfComponent1;
    }

    private Box component2() {
        boxOfComponent2 = Box.createHorizontalBox();
        boxOfComponent2.setBorder(new TitledBorder("2-ая группа компонентов"));
        JTextField input = new JTextField(15);
        JButton name = new JButton("Назвать другую кнопку");
        JButton inverse = new JButton("Инверсия");
        name.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                inverse.setText(input.getText());
            }

        });
        inverse.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                String buff = new String();
                buff = name.getText();
                name.setText(inverse.getText());
                inverse.setText(buff);
            }
        });
        boxOfComponent2.add(input);
        boxOfComponent2.add(Box.createHorizontalStrut(6));
        boxOfComponent2.add(name);
        boxOfComponent2.add(Box.createHorizontalStrut(6));
        boxOfComponent2.add(inverse);
        return boxOfComponent2;
    }

    private Box component3() {
        boxOfComponent3 = Box.createHorizontalBox();
        boxOfComponent3.setBorder(new TitledBorder("3-ая группа компонентов"));
        JTextField input = new JTextField(10);
        JRadioButton radioButton1 = new JRadioButton("1");
        JRadioButton radioButton2 = new JRadioButton("2");
        JRadioButton radioButton3 = new JRadioButton("3");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        JButton choose = new JButton("Выбрать");
        choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (input.getText().equals("1"))
                    radioButton1.setSelected(true);
                else if (input.getText().equals("2"))
                    radioButton2.setSelected(true);
                else if (input.getText().equals("3"))
                    radioButton3.setSelected(true);
                else
                    JOptionPane.showMessageDialog(choose, "Нет такого переключателя", "Информация", JOptionPane.ERROR_MESSAGE);
            }
        });
        boxOfComponent3.add(input);
        boxOfComponent3.add(Box.createHorizontalStrut(6));
        boxOfComponent3.add(choose);
        boxOfComponent3.add(Box.createHorizontalStrut(6));
        boxOfComponent3.add(radioButton1);
        boxOfComponent3.add(radioButton2);
        boxOfComponent3.add(radioButton3);
        return boxOfComponent3;
    }

    private Box component4() {
        boxOfComponent4 = Box.createHorizontalBox();
        boxOfComponent4.setBorder(new TitledBorder("4-ая группа компонентов"));
        JTextField input = new JTextField(10);
        JCheckBox checkBox1 = new JCheckBox("1");
        JCheckBox checkBox2 = new JCheckBox("2");
        JCheckBox checkBox3 = new JCheckBox("3");
        JButton choose = new JButton("Выбрать");
        choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (input.getText().equals("1"))
                    checkBox1.setSelected(!checkBox1.isSelected());
                else if (input.getText().equals("2"))
                    checkBox2.setSelected(!checkBox2.isSelected());
                else if (input.getText().equals("3"))
                    checkBox3.setSelected(!checkBox3.isSelected());
                else
                    JOptionPane.showMessageDialog(choose, "Нет такого флажка", "Информация", JOptionPane.ERROR_MESSAGE);
            }
        });
        boxOfComponent4.add(input);
        boxOfComponent4.add(Box.createHorizontalStrut(6));
        boxOfComponent4.add(choose);
        boxOfComponent4.add(Box.createHorizontalStrut(6));
        boxOfComponent4.add(checkBox1);
        boxOfComponent4.add(checkBox2);
        boxOfComponent4.add(checkBox3);
        return boxOfComponent4;
    }

    private Box component5() {
        Box boxOfComponent5 = Box.createVerticalBox();
        box51 = Box.createHorizontalBox();
        Box box52 = Box.createHorizontalBox();
        boxOfComponent5.setBorder(new TitledBorder("5-ая группа компонентов"));
        DefaultTableModel model = new DefaultTableModel(rowSize, 2);
        JTable table = new JTable(model);
        Dimension dimension = new Dimension(box52.getWidth(), table.getRowHeight() * 5);
        JTextField input = new JTextField(10);
        JButton add = new JButton("Занести");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                table.setValueAt(input.getText(), rowSize - 1, 0);
                input.setText("");
                model.addRow(new Object[]{"", ""});
                rowSize++;
            }
        });
        JButton toB = new JButton("Перенести в В");
        toB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                for (int row = 0; row < selectedRows.length; row++) {
                    if (table.getValueAt(selectedRows[row], 0) != "") {
                        table.setValueAt(table.getValueAt(selectedRows[row], 0), selectedRows[row], 1);
                        table.setValueAt("", selectedRows[row], 0);
                    }
                }

            }
        });
        JButton toA = new JButton("Перенести в А");
        toA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                for (int row = 0; row < selectedRows.length; row++) {
                    if (table.getValueAt(selectedRows[row], 1) != "") {
                        table.setValueAt(table.getValueAt(selectedRows[row], 1), selectedRows[row], 0);
                        table.setValueAt("", selectedRows[row], 1);
                    }
                }

            }
        });
        box51.add(input);
        box51.add(Box.createHorizontalStrut(6));
        box51.add(add);
        box51.add(Box.createHorizontalStrut(6));
        box51.add(toB);
        box51.add(Box.createHorizontalStrut(6));
        box51.add(toA);
        box51.add(Box.createHorizontalStrut(6));
        boxOfComponent5.add(box51);
        boxOfComponent5.add(Box.createVerticalStrut(6));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(dimension);
        box52.add(scrollPane);
        boxOfComponent5.add(box52);
        return boxOfComponent5;
    }

    //нужно сделать карусель компонентов в группах: старт - запуск карусели, конец - остановить
    private Box extraThing() {
        Box buttons = Box.createHorizontalBox();
        JButton startButton = new JButton("Старт");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /* for (int current = 1, previous = 0; ; current++) {

                    box1.add(textFieldOfComponent1);
                    box1.add(Box.createHorizontalStrut(6));
                    box1.add(comboBoxOfComponent1);
                    box1.add(Box.createHorizontalStrut(6));
                    box1.add(addOfComponent1);
                }*/
                Container[] boxes = {boxOfComponent1,boxOfComponent2,boxOfComponent3,boxOfComponent4,box51};
                for (Container box : boxes)
                {
                Component[] components = box.getComponents();
                box.removeAll();
                for(int current=0,next=1;next<components.length;current++,next++)
                { Component temp = components[current];
                    components[current] = components[next];
                    components[next] = temp;
                }
                for (Component comp : components) {
                    box.add(comp);
                }
                box.validate();
                }
                /*box.
                box.add(box.getComponent(4));
                box.add(box.getComponent(5));
                box.add(box.getComponent(1));
                box.add(box.getComponent(2));*/

            }
        });
        JButton stopButton = new JButton("Стоп");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttons.add(startButton);
        buttons.add(Box.createHorizontalStrut(6));
        buttons.add(stopButton);
        return buttons;
    }
}
