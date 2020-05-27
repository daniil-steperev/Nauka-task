package com.stepyrev.nauka.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/** A class that realizes a data base object Department. */
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "tabel_id")
    private long tabelId;

    @Column(name = "calendar_id")
    private long calendar;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTabelId(long tabelId) {
        this.tabelId = tabelId;
    }

    public long getTabelId() {
        return tabelId;
    }

    public long getCalendar() {
        return calendar;
    }

    public void setCalendar(long calendar) {
        this.calendar = calendar;
    }
}
