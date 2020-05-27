package com.stepyrev.nauka.managers.panels;

import com.stepyrev.nauka.entity.Worker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class DialogWorkerPanel extends JDialog {

    private JTextField name;
    private JTextField tabelDepartId;
    private JTextField tabelId;

    private boolean cancelled = true;

    public DialogWorkerPanel() {
        setModal(true);
        setTitle("Введите новый департамент");
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(0, 1, 0, 30));
        getContentPane().add(content);

        JTextArea nameArea = new JTextArea("ФИО");
        name = new JTextField();

        JTextArea nameTabel = new JTextArea("Табельный номер");
        tabelId = new JTextField();

        JTextArea nameDepartTabel = new JTextArea("Табельный номер департамента");
        tabelDepartId = new JTextField();

        JButton ok = new JButton("Добавить");
        JButton cancel = new JButton("Отмена");
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttons.add(ok);
        buttons.add(cancel);

        content.add(nameArea, BorderLayout.CENTER);
        content.add(name);

        content.add(nameTabel, BorderLayout.CENTER);
        content.add(tabelId);

        content.add(nameDepartTabel, BorderLayout.CENTER);
        content.add(tabelDepartId, BorderLayout.NORTH);

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
    public Worker getWorker () {
        try {
            setVisible(true);

            Worker worker = new Worker();
            worker.setName(name.getText());
            worker.setTabelId(Long.parseLong(tabelId.getText()));
            worker.setDepartmentId(Long.parseLong(tabelDepartId.getText()));

            return cancelled ? null : worker;
        } catch (Exception e) {
            showMessageDialog(null, "Пожалуйста, введите корректные данные");

            return null;
        }
    }
}
