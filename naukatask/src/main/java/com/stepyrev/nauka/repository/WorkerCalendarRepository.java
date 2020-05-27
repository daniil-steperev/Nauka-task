package com.stepyrev.nauka.repository;

import com.stepyrev.nauka.entity.WorkerCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface WorkerCalendarRepository extends JpaRepository<WorkerCalendar, Long> {
    ArrayList<WorkerCalendar> findByWorkerId(long workerId);
    ArrayList<WorkerCalendar> findByWorkerIdAndMonth(long workerId, Months month);
    WorkerCalendar findByWorkerIdAndMonthAndDay(long workerId, Months month, int day);
}