package com.stepyrev.nauka.managers.panels;

import com.stepyrev.nauka.entity.Department;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class DialogDepartmentPanel extends JDialog {

    private JTextField name;
    private JTextField tabelId;
    private JTextField calendarId;
    private boolean cancelled = true;

    public static void main(String[] args) {
        DialogDepartmentPanel panel = new DialogDepartmentPanel();
        panel.getDepartment();
    }

    public DialogDepartmentPanel() {
        setModal(true);
        setTitle("Введите новый департамент");
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(0, 1, 0, 30));
        getContentPane().add(content);

        JTextArea nameArea = new JTextArea("Имя департамента");
        name = new JTextField();

        JTextArea nameTabel = new JTextArea("Номер департамента");
        tabelId = new JTextField();

        JTextArea nameCalendar = new JTextArea("Табельный номер производственного календаря");
        calendarId = new JTextField();

        JButton ok = new JButton("Добавить");
        JButton cancel = new JButton("Отмена");
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttons.add(ok);
        buttons.add(cancel);

        content.add(nameArea, BorderLayout.CENTER);
        content.add(name);

        content.add(nameTabel, BorderLayout.CENTER);
        content.add(tabelId);

        content.add(nameCalendar, BorderLayout.CENTER);
        content.add(calendarId, BorderLayout.NORTH);

        content.add(buttons, BorderLayout.CENTER);

        content.setBorder(new EmptyBorder(15, 15, 15, 15));
        pack();

        ok.addActionListener(new ActionListener() {

            public void actionPerformed (ActionEvent e) {
                cancelled = false;
                dispose();
            }
        });
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed (ActionEvent e) {
                cancelled = true;
                dispose();
            }
        });
        // default button, allows to trigger ok when pressing enter in the text field
        getRootPane().setDefaultButton(ok);
    }

    /**
     * Open the dialog (modal, blocks caller until dialog is disposed) and returns the entered value, or null if
     * cancelled.
     */
    public Department getDepartment () {
        try {
            setVisible(true);

            Department department = new Department();
            department.setName(name.getText());
            department.setTabelId(Long.parseLong(tabelId.getText()));
            department.setCalendar(Long.parseLong(calendarId.getText()));

            return cancelled ? null : department;
        } catch (Exception e) {
            showMessageDialog(null, "Пожалуйста, введите корректные данные");

            return null;
        }
    }
}
