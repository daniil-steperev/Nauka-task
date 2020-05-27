package com.stepyrev.nauka.service.impl;

import com.stepyrev.nauka.entity.ProductionCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.repository.ProductionCalendarRepository;
import com.stepyrev.nauka.service.ProductionCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionCalendarServiceImpl implements ProductionCalendarService {

    @Autowired
    private ProductionCalendarRepository calendarRepository;

    @Override
    public ProductionCalendar addWorkerCalendar(ProductionCalendar workerCalendar) {
        return calendarRepository.saveAndFlush(workerCalendar);
    }

    @Override
    public void delete(long id) {
        calendarRepository.delete(id);
    }

    @Override
    public ProductionCalendar getByTabelIdAndDayAndMonth(long id, int day, Months month) {
        return calendarRepository.findByTabelIdAndDayAndMonth(id, day, month);
    }

    @Override
    public ProductionCalendar getByTabelId(long id) {
        return calendarRepository.findByTabelId(id);
    }
}
