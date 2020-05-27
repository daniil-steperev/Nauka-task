package com.stepyrev.nauka.managers;

import com.stepyrev.nauka.entity.Worker;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/** A class that realizes a manager for workers. */
public class WorkerManager {
    private DefaultTableModel workers;

    public WorkerManager(DefaultTableModel workers) {
        this.workers = workers;
    }

    public void rebuildWorkersModel(ArrayList<Worker> newWorkers) {
        removeAllWorkers();

        for (Worker worker : newWorkers) {
            workers.addRow(new Object[]{worker.getName(), worker.getStatus(), worker.getTabelId()});
        }
    }

    private void removeAllWorkers() {
        while (workers.getRowCount() > 0) {
            workers.removeRow(0);
        }
    }
}
