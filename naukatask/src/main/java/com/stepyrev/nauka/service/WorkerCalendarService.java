package com.stepyrev.nauka.service;

import com.stepyrev.nauka.entity.WorkerCalendar;
import com.stepyrev.nauka.entity.enums.Months;

import java.util.ArrayList;

public interface WorkerCalendarService {
    WorkerCalendar addWorkerCalendar(WorkerCalendar workerCalendar);
    void delete(long id);
    ArrayList<WorkerCalendar> getByWorkerId(long workerId);
    ArrayList<WorkerCalendar> getByWorkerIdAndMonth(long workerId, Months month);
    WorkerCalendar getByWorkerIdAndMonthAndDay(long workerId, Months month, int day);
}
