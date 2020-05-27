package com.stepyrev.nauka.entity;

import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.entity.enums.WorkDayStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

/** A class that realizes a data base object Production Calendar. */
@Entity
@Table(name = "worker_calendar")
public class ProductionCalendar {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "tabel_id")
    private long tabelId;

    @Column(name = "day")
    private int day;

    @Column(name = "month")
    private Months month;

    @Column(name = "day_type")
    private WorkDayStatus dayStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTabelId() {
        return tabelId;
    }

    public void setTabelId(long tabelId) {
        this.tabelId = tabelId;
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
