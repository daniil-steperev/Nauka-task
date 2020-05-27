package com.stepyrev.nauka.service;

import com.stepyrev.nauka.entity.ProductionCalendar;
import com.stepyrev.nauka.entity.enums.Months;

public interface ProductionCalendarService {
    ProductionCalendar addWorkerCalendar(ProductionCalendar workerCalendar);
    void delete(long id);
    ProductionCalendar getByTabelIdAndDayAndMonth(long id, int day, Months month);
    ProductionCalendar getByTabelId(long id);
}
