import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Window {
    JFrame window;
    private Box mainBox;
    private Box box1;
    private Box box2;
    private Box box3;
    private Box box4;
    private Box box5;
    int rowSize=1;
    final int columnSize=2;
    Window() {
        window=new JFrame("Лабораторная работа 1");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        components();
        window.pack();
        window.setVisible(true);
    }

   private void components() {
        mainBox = Box.createVerticalBox();
        component1();
        component2();
        component3();
        component4();
        component5();
        mainBox.add(box1);
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(box4);
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(box5);
        window.setContentPane(mainBox);
    }

    private void component1() {
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

    private void component2() {
        box2 = Box.createHorizontalBox();
        box2.setBorder(new TitledBorder("2-ая группа компонентов"));
        JTextField textField2 = new JTextField(15);
        JButton button1 = new JButton("Назвать другую кнопку");
        JButton button2 = new JButton("Инверсия");
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

    private void component3(){
        box3 = Box.createHorizontalBox();
        box3.setBorder(new TitledBorder("3-ая группа компонентов"));
        JTextField textField = new JTextField(10);
        JButton button1 = new JButton("Выбрать");
        JRadioButton radioButton1=new JRadioButton("1");
        JRadioButton radioButton2=new JRadioButton("2");
        JRadioButton radioButton3=new JRadioButton("3");
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().equals("1"))
                    radioButton1.setSelected(true);
                else if (textField.getText().equals("2"))
                    radioButton2.setSelected(true);
                else if (textField.getText().equals("3"))
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

    private void component4(){
        box4 = Box.createHorizontalBox();
        box4.setBorder(new TitledBorder("4-ая группа компонентов"));
        JTextField textField = new JTextField(10);
        JButton button1 = new JButton("Выбрать");
        JCheckBox checkBox1=new JCheckBox("1");
        JCheckBox checkBox2=new JCheckBox("2");
        JCheckBox checkBox3=new JCheckBox("3");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().equals("1")) {
                    if(checkBox1.isSelected())
                        checkBox1.setSelected(false);
                    else checkBox1.setSelected(true);
                }
                else if (textField.getText().equals("2"))
                {
                    if(checkBox2.isSelected())
                        checkBox2.setSelected(false);
                    else checkBox2.setSelected(true);
                }
                else if (textField.getText().equals("3"))
                {
                    if(checkBox3.isSelected())
                        checkBox3.setSelected(false);
                    else checkBox3.setSelected(true);
                }
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

    private void component5(){
        box5 = Box.createVerticalBox();
        Box box51=Box.createHorizontalBox();
        Box box52=Box.createHorizontalBox();
        box5.setBorder(new TitledBorder("5-ая группа компонентов"));
        JTextField textField = new JTextField(10);
        JButton button1 = new JButton("Занести");
        JButton button2 = new JButton("Перенести в В");
        JButton button3 = new JButton("Перенести в А");
        DefaultTableModel model = new DefaultTableModel(rowSize,columnSize);
        JTable table=new JTable(model);
        Dimension dimension=new Dimension(box52.getWidth(),table.getRowHeight()*5);
       // table.setMinimumSize(dimension);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.setValueAt(textField.getText(),rowSize-1,0);
                textField.setText("");
                model.addRow(new Object[]{"",""});
                rowSize++;
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows=table.getSelectedRows();
                for(int row=0;row<selectedRows.length;row++)
                {
                    table.setValueAt(table.getValueAt(selectedRows[row],0),selectedRows[row],1);
                    table.setValueAt("",selectedRows[row],0);
                }

            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows=table.getSelectedRows();
                for(int row=0;row<selectedRows.length;row++)
                {
                    table.setValueAt(table.getValueAt(selectedRows[row],1),selectedRows[row],0);
                    table.setValueAt("",selectedRows[row],1);
                }

            }
        });
        box51.add(textField);
        box51.add(Box.createHorizontalStrut(6));
        box51.add(button1);
        box51.add(Box.createHorizontalStrut(6));
        box51.add(button2);
        box51.add(Box.createHorizontalStrut(6));
        box51.add(button3);
        box51.add(Box.createHorizontalStrut(6));
        box5.add(box51);
        box5.add(Box.createVerticalStrut(6));
        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(dimension);
        box52.add(scrollPane);
        box5.add(box52);


    }
}
