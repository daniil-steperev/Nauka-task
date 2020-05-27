package com.stepyrev.nauka.test.util;

import com.stepyrev.nauka.entity.ProductionCalendar;
import com.stepyrev.nauka.entity.Worker;
import com.stepyrev.nauka.entity.WorkerCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.entity.enums.WorkDayStatus;
import com.stepyrev.nauka.entity.enums.WorkerStatus;

public class WorkerCalendarUtil {

    public static WorkerCalendar createCalendar() {
        WorkerCalendar calendar = new WorkerCalendar();
        calendar.setDay(1);
        calendar.setMonth(Months.JANUARY);
        calendar.setDayStatus(WorkDayStatus.DAY_OF);


        calendar.setWorkerId(createWorker().getTabelId());

        return calendar;
    }

    public static Worker createWorker() {
        Worker worker = new Worker();
        worker.setDepartmentId(1);
        worker.setTabelId(1);
        worker.setName("Daniil");
        worker.setStatus(WorkerStatus.PROGRAMMER);

        return worker;
    }
}
