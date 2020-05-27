package com.stepyrev.nauka.repository;

import com.stepyrev.nauka.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    ArrayList<Department> findByName(String name);
    ArrayList<Department> findAll();
}
