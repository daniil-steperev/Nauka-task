package com.stepyrev.nauka.service.impl;

import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.repository.DepartmentRepository;
import com.stepyrev.nauka.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        Department savedDepartment = departmentRepository.saveAndFlush(department);

        return savedDepartment;
    }

    @Override
    public void delete(long id) {
        departmentRepository.delete(id);
    }

    @Override
    public Department getByName(String name) {
        ArrayList<Department> departments = departmentRepository.findByName(name);
        if (departments.isEmpty()) {
            return null;
        }

        return departments.get(0);
    }

    @Override
    public ArrayList<Department> getAll() {
        return departmentRepository.findAll();
    }
}
