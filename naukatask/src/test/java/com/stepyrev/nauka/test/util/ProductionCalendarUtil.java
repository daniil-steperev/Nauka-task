package com.stepyrev.nauka.test.util;

import com.stepyrev.nauka.entity.ProductionCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.entity.enums.WorkDayStatus;

public class ProductionCalendarUtil {

    public static ProductionCalendar createCalendar() {
        ProductionCalendar calendar = new ProductionCalendar();
        calendar.setTabelId(1);
        calendar.setDay(1);
        calendar.setMonth(Months.JANUARY);
        calendar.setDayStatus(WorkDayStatus.DAY_OF);

        return calendar;
    }
}
