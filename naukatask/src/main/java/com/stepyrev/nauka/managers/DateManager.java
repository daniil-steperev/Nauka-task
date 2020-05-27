package com.stepyrev.nauka.managers;

import com.stepyrev.nauka.config.DataConfig;
import com.stepyrev.nauka.entity.Worker;
import com.stepyrev.nauka.entity.WorkerCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.entity.enums.WorkDayStatus;
import com.stepyrev.nauka.service.impl.ProductionCalendarServiceImpl;
import com.stepyrev.nauka.service.impl.WorkerCalendarServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/** A class that realizes data table. */
public class DateManager {
    private JTable days;
    private Months currentMonth;
    private int numberOfDays;

    @Resource
    private WorkerCalendarServiceImpl workerCalendar;
    @Resource
    private ProductionCalendarServiceImpl productionCalendar;

    public DateManager(JTable table) {
        days = table;
        changeMonths(Months.JANUARY);

        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);

        workerCalendar = context.getBean(WorkerCalendarServiceImpl.class);
        productionCalendar = context.getBean(ProductionCalendarServiceImpl.class);
    }

    /** A method that updates the calendar list. */
    public void updateCalendar(ArrayList<Worker> workers) {
        cleanWorkers();

        for (Worker worker : workers) {
            ArrayList<WorkerCalendar> calendar = workerCalendar.getByWorkerIdAndMonth(worker.getTabelId(), currentMonth);

            addWorkerLine(calendar);
        }
    }

    /** A method that returns current month. */
    public Months getCurrentMonth() {
        return currentMonth;
    }

    public void updateMonth(Months month) {
        cleanWorkers();

        changeMonths(month);
    }

    private void cleanWorkers() {
        while (days.getRowCount() > 0) {
            ((DefaultTableModel) days.getModel()).removeRow(0);
        }
    }

    private void changeMonths(Months month) {
        if (currentMonth == month) {
            return;
        }

        DefaultTableModel newDays = new DefaultTableModel();

        numberOfDays = 0;

        switch (month) {
            case FEBRUARY:
                numberOfDays = 28;
                break;
            case APRIL:
                numberOfDays = 30;
                break;
            case JUNE:
                numberOfDays = 30;
                break;
            case SEPTEMBER:
                numberOfDays = 30;
                break;
            case NOVEMVER:
                numberOfDays = 30;
                break;
            default:
                numberOfDays = 31;
                break;
        }

        for (int i = 1; i <= numberOfDays; i++) {
            newDays.addColumn(i);
        }

        days.setModel(newDays);
        currentMonth = month;
    }

    public void changeWorkerLine(int workerNumber, ArrayList<WorkerCalendar> calendar) {
        for (WorkerCalendar day : calendar) {
            String status = getCorrectDayStatus(day.getDayStatus());
            int dayNumber = day.getDay();

            addWorkDayStatus(workerNumber, dayNumber, status);
        }
    }


    private void addWorkDayStatus(int rowNumber, int dayNumber, String status) {
        if (days.getColumnCount() < dayNumber || days.getRowCount() < rowNumber) {
            System.out.println("You can not edit this cell!");
            return;
        }

        days.setValueAt(status, rowNumber, dayNumber);
    }

    private void addWorkerLine(ArrayList<WorkerCalendar> calendar) {
        DefaultTableModel model = (DefaultTableModel) days.getModel();
        Object[] statuses = new Object[numberOfDays];

        for (WorkerCalendar date : calendar) {
            int day = (int) date.getDay();
            String status = getCorrectDayStatus(date.getDayStatus());

            statuses[day - 1] = status;
        }

        model.addRow(statuses);
    }

    private String getCorrectDayStatus(WorkDayStatus status) {
        String returnStatus = "";

        switch (status) {
            case DAY_OF:
                returnStatus = "В";
                break;
            case ABSENSE:
                returnStatus = "Н";
                break;
            case FULLDAY:
                returnStatus = "Я";
                break;
            case WORK_DAY_OF:
                returnStatus = "Рв";
                break;
            case ECONOMIC_DAY:
                returnStatus = "Хд";
                break;
            case BUSINESS_TRIP:
                returnStatus = "К";
                break;
            case CHILD_HOLIDAY:
                returnStatus = "Ож";
                break;
            case PAID_VACATION:
                returnStatus = "ОТ";
                break;
            case UNPAID_VACATION:
                returnStatus = "До";
                break;
            case STUDYING_HOLIDAY:
                returnStatus = "У";
                break;
            case TEMPORARY_DISABILITY:
                returnStatus = "Б";
                break;
            default:
                returnStatus = "-";
                break;
        }

        return returnStatus;
    }
}
