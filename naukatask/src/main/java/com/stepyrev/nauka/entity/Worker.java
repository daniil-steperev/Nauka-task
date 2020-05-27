package com.stepyrev.nauka.entity;

import com.stepyrev.nauka.entity.enums.WorkerStatus;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

/** A class that realizes a data base object Worker. */
@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private WorkerStatus status;

    @Column(name = "tabel_id")
    private long tabelId;

    @Column(name = "department_id")
    private long departmentId;

    public Worker() {}

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

    public WorkerStatus getStatus() {
        return status;
    }

    public void setStatus(WorkerStatus status) {
        this.status = status;
    }

    public long getTabelId() {
        return tabelId;
    }

    public void setTabelId(long tabelId) {
        this.tabelId = tabelId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
}
