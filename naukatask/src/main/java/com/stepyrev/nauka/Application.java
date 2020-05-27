package com.stepyrev.nauka;

import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.entity.Worker;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.managers.ApplicationManager;
import com.stepyrev.nauka.managers.DateManager;
import com.stepyrev.nauka.managers.panels.DepartmentPanel;
import com.stepyrev.nauka.managers.panels.DialogDepartmentPanel;
import com.stepyrev.nauka.managers.panels.DialogWorkerPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/** A class that realizes the main page of application. */
public class Application {
    /** A list of moths. */
    private JPanel months;
    /** A list of workers visits. */
    private JList calendar;

    /** Moths buttons. */
    private JButton januaryBtn;
    private JButton februaryBtn;
    private JButton marchBtn;
    private JButton aprilBtn;
    private JButton mayBtn;
    private JButton juneBtn;
    private JButton julyBtn;
    private JButton augustBtn;
    private JButton septemberBtn;
    private JButton octoberBtn;
    private JButton novemberBtn;
    private JButton decemberBtn;
    private JPanel rootFrame;
    private JTable workers;
    private JPanel departmentsPanel;
    private JButton editDepartmentsBtn;
    private JScrollPane workersPane;
    private JScrollPane dayPane;
    private JTable dayTable;
    private JScrollPane monthsPane;
    private JButton editWorkersBtn;

    private ApplicationManager service;
    private DateManager dateManager;

    private DepartmentPanel departmentList;
    private DefaultTableModel workersModel;

    private ArrayList<JButton> monthsBtns = new ArrayList<>();

    public Application() {
        service = new ApplicationManager(departmentList, calendar, workersModel, dayTable);

        monthsBtns.add(januaryBtn);
        monthsBtns.add(februaryBtn);
        monthsBtns.add(marchBtn);
        monthsBtns.add(aprilBtn);
        monthsBtns.add(marchBtn);
        monthsBtns.add(juneBtn);
        monthsBtns.add(julyBtn);
        monthsBtns.add(augustBtn);
        monthsBtns.add(septemberBtn);
        monthsBtns.add(octoberBtn);
        monthsBtns.add(novemberBtn);
        monthsBtns.add(decemberBtn);

        editDepartmentsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogDepartmentPanel dialogDepartmentPanel = new DialogDepartmentPanel();
                Department department = dialogDepartmentPanel.getDepartment();
                if (department != null) {
                    // service.addDepartment(department);
                }
            }
        });

        januaryBtn.setBackground(Color.green);

        januaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.JANUARY);
                januaryBtn.setBackground(Color.green);
            }
        });
        februaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.FEBRUARY);
                februaryBtn.setBackground(Color.green);
            }
        });
        marchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.MARCH);
                marchBtn.setBackground(Color.green);
            }
        });
        aprilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.APRIL);
                aprilBtn.setBackground(Color.green);
            }
        });
        mayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.MAY);
                mayBtn.setBackground(Color.green);
            }
        });
        juneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.JUNE);
                juneBtn.setBackground(Color.green);
            }
        });
        julyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.JULY);
                julyBtn.setBackground(Color.green);
            }
        });
        augustBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.AUGUST);
                augustBtn.setBackground(Color.green);
            }
        });
        septemberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.SEPTEMBER);
                septemberBtn.setBackground(Color.green);
            }
        });
        octoberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.OCTOBER);
                octoberBtn.setBackground(Color.green);
            }
        });
        novemberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.updateCalendar(Months.NOVEMVER);
                novemberBtn.setBackground(Color.green);
            }
        });
        decemberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unSetBackground();
                service.updateCalendar(Months.DECEMBER);
                decemberBtn.setBackground(Color.green);
            }
        });

        editWorkersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogWorkerPanel workerPanel = new DialogWorkerPanel();
                Worker worker = workerPanel.getWorker();

                if (worker != null) {
                    // service.addWorker(worker);
                }
            }
        });
    }

    private void unSetBackground() {
        for (JButton btn : monthsBtns) {
            btn.setBackground(rootFrame.getBackground());
        }
    }

    /** A method that starts the application. */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Табель");

        frame.setContentPane(new Application().rootFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        workersModel = new DefaultTableModel();
        workers = new JTable(workersModel);
        workersModel.addColumn("ФИО");
        workersModel.addColumn("Должность");
        workersModel.addColumn("ID");
        JTableHeader header = workers.getTableHeader();

        workersPane = new JScrollPane(workers);
        workersPane.add(header);

        departmentList = new DepartmentPanel(service);
        departmentsPanel = departmentList;
        departmentsPanel.setPreferredSize(new Dimension(200, 1000));

        months = new DepartmentPanel(service);
        monthsPane = new JScrollPane(months);
        monthsPane.setPreferredSize(new Dimension(100, 25));

        DefaultTableModel tableModel = new DefaultTableModel();
        dayTable = new JTable(tableModel);
        dateManager = new DateManager(dayTable);
        dayTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTableHeader dayHeader = dayTable.getTableHeader();
        dayPane = new JScrollPane(dayTable);
        dayPane.add(dayHeader);
    }
}
