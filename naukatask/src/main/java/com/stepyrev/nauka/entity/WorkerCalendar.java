package com.stepyrev.nauka.entity;

import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.entity.enums.WorkDayStatus;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

/** A class that realizes a data base object WorkerCalendar. */
@Entity
@Table(name = "worker_calendar")
public class WorkerCalendar {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "worker_id")
    private long workerId;

    @Column(name = "day")
    private int day;

    @Column(name = "month")
    private Months month;

    @Column(name = "day_status")
    private WorkDayStatus dayStatus;

    public WorkerCalendar() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Months getMonth() {
        return month;
    }

    public void setMonth(Months month) {
        this.month = month;
    }

    public WorkDayStatus getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(WorkDayStatus dayStatus) {
        this.dayStatus = dayStatus;
    }
}
