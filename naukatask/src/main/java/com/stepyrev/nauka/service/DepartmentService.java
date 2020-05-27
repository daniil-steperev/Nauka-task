package com.stepyrev.nauka.service;

import com.stepyrev.nauka.entity.Department;

import java.util.ArrayList;

public interface DepartmentService {
    Department addDepartment(Department department);
    void delete(long id);
    Department getByName(String name);
    ArrayList<Department> getAll();
}
