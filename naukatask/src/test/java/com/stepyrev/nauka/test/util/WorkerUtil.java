package com.stepyrev.nauka.test.util;

import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.entity.Worker;

public class WorkerUtil {
    public static Worker createWorker(long id) {
        Worker worker = new Worker();
        worker.setName("Daniil Stepyrev");
        worker.setDepartmentId(id);

        return worker;
    }

    public static Worker createWorker() {
        Worker worker = new Worker();
        worker.setName("Daniil Stepyrev");
        worker.setDepartmentId(1);

        return worker;
    }
}
