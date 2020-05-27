package com.stepyrev.nauka.service.impl;

import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.entity.Worker;
import com.stepyrev.nauka.repository.DepartmentRepository;
import com.stepyrev.nauka.repository.WorkerRepository;
import com.stepyrev.nauka.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/** A class that realizes an implementation of worker service. */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Worker addWorker(Worker worker) {
        Worker savedWorker = workerRepository.saveAndFlush(worker);

        return savedWorker;
    }

    @Override
    public void delete(long id) {
        workerRepository.delete(id);
    }

    @Override
    public Worker getByName(String name) {
        ArrayList<Worker> workers = workerRepository.findByName(name);

        if (workers.isEmpty()) {
            return null;
        }

        return workers.get(0);
    }

    @Override
    public Worker getByTabelId(long tabelId) {
        return workerRepository.findByTabelId(tabelId);
    }

    @Override
    public ArrayList<Worker> getByDepartmentId(long id) {
        return workerRepository.findByDepartmentId(id);
    }

    @Override
    public ArrayList<Worker> getAll() {
        return workerRepository.findAll();
    }
}
