package com.stepyrev.nauka.service.impl;

import com.stepyrev.nauka.entity.Worker;
import com.stepyrev.nauka.entity.WorkerCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.repository.WorkerCalendarRepository;
import com.stepyrev.nauka.service.WorkerCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WorkerCalendarServiceImpl implements WorkerCalendarService {

    @Autowired
    private WorkerCalendarRepository workerCalendarRepository;

    @Override
    public WorkerCalendar addWorkerCalendar(WorkerCalendar workerCalendar) {
        WorkerCalendar savedCalendar = workerCalendarRepository.saveAndFlush(workerCalendar);

        return savedCalendar;
    }

    @Override
    public void delete(long id) {
        workerCalendarRepository.delete(id);
    }

    @Override
    public ArrayList<WorkerCalendar> getByWorkerId(long workerId) {
        return workerCalendarRepository.findByWorkerId(workerId);
    }

    @Override
    public ArrayList<WorkerCalendar> getByWorkerIdAndMonth(long workerId, Months month) {
        return workerCalendarRepository.findByWorkerIdAndMonth(workerId, month);
    }

    @Override
    public WorkerCalendar getByWorkerIdAndMonthAndDay(long workerId, Months month, int day) {
        return workerCalendarRepository.findByWorkerIdAndMonthAndDay(workerId, month, day);
    }
}
