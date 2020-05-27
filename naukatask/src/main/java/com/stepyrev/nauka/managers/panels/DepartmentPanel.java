package com.stepyrev.nauka.managers.panels;

import com.stepyrev.nauka.managers.ApplicationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentPanel extends JPanel {
    private DefaultListModel model;
    private static ApplicationManager manager;

    public DepartmentPanel(ApplicationManager manager) {
        this.manager = manager;

        setLayout(new GridLayout(0, 1, 0, 30));
        //setSize(new Dimension(800, 800));
        model = new DefaultListModel();
        model.addElement(createButtons("Department 1"));
        JList list = new JList(model);
        list.setCellRenderer(new PanelRenderer());
        JScrollPane scroll = new JScrollPane(list);
        add(scroll);
    }

    public void addButtonToPanel(String text) {
        JButton btn = createButtons(text);
        model.addElement(btn);
    }

    public void clean() {
        while (model.getSize() > 0) {
            model.remove(0);
        }
    }

    private static JButton createButtons(final String text) {
        JButton button = new JButton(text);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.updateWorkers(text);
            }
        });

        return button;
    }

    class PanelRenderer implements ListCellRenderer {

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JButton renderer = (JButton) value;
            renderer.setBackground(isSelected ? Color.green : list.getBackground());
            return renderer;
        }
    }
}
