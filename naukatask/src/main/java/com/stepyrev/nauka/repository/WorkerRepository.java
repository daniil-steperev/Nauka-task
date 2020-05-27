package com.stepyrev.nauka.repository;

import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/** An interface that realizes queres for Worker database. */
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    ArrayList<Worker> findByName(String name);
    Worker findByTabelId(long tabelId);
    ArrayList<Worker> findByDepartmentId(long departmentId);
    ArrayList<Worker> findAll();
}
