package com.stepyrev.nauka.service;

import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.entity.Worker;

import java.util.ArrayList;

/** An interface that realizes a service for queries for Worker database. */
public interface WorkerService {
    Worker addWorker(Worker worker);
    void delete(long id);
    Worker getByName(String name);
    Worker getByTabelId(long tabelId);
    ArrayList<Worker> getByDepartmentId(long id);
    ArrayList<Worker> getAll();
}
