package com.stepyrev.nauka.test.util;

import com.stepyrev.nauka.entity.Department;

public class DepartmentUtil {

    public static Department createDepartment() {
        Department department = new Department();

        department.setName("Nauka");

        return department;
    }
}
