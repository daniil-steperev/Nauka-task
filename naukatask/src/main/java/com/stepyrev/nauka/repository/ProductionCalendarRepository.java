package com.stepyrev.nauka.repository;

import com.stepyrev.nauka.entity.ProductionCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionCalendarRepository extends JpaRepository<ProductionCalendar, Long> {
    ProductionCalendar findByTabelIdAndDayAndMonth(long tabelId, int day, Months month);
    ProductionCalendar findByTabelId(long tabelId);
}
