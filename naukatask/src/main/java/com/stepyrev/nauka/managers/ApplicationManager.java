package com.stepyrev.nauka.managers;

import com.stepyrev.nauka.config.DataConfig;
import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.entity.Worker;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.managers.panels.DepartmentPanel;
import com.stepyrev.nauka.service.impl.DepartmentServiceImpl;
import com.stepyrev.nauka.service.impl.WorkerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/** A class that realizes changing data methods in GUI. */
public class ApplicationManager {

    private DepartmentPanel departments;
    private JList calendar;
    private DefaultTableModel workers;

    /** A classes that works with databases. */
    @Resource
    private DepartmentServiceImpl departmentService;
    @Resource
    private WorkerServiceImpl workerService;

    private WorkerManager workerManager;
    private DateManager dateManager;

    private Department currentDepartment;

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    public ApplicationManager(DepartmentPanel departments,
                              JList calendar,
                              DefaultTableModel workers,
                              JTable days) {
        this.departments = departments;
        this.calendar = calendar;
        this.workers = workers;

        workerManager = new WorkerManager(workers);
        dateManager = new DateManager(days);

        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        emf = context.getBean(EntityManagerFactory.class);
        em = emf.createEntityManager();

        departmentService = context.getBean(DepartmentServiceImpl.class);
        workerService = context.getBean(WorkerServiceImpl.class);

        // updateDepartments();     -- FIXME HERE IS THE MISTAKE
    }

    /** A method that adds a new department after adding it in GUI. */
    public void addDepartment(Department department) {
        departmentService.addDepartment(department); // save to db
        departments.addButtonToPanel(department.getName());
    }

    /** A method that adds a new worker after adding it in GUI. */
    public void addWorker(Worker worker) {
        workerService.addWorker(worker);

        if (worker.getDepartmentId() == currentDepartment.getTabelId()) { // update data list
            updateWorkers(currentDepartment.getName());
        }
    }


    /** A method that updates the department list. */
    public void updateDepartments() {
        if (departments == null) {
            return;
        }

        departments.clean();

        ArrayList<Department> allDepartments = departmentService.getAll();
        for (Department department : allDepartments) {
            departments.addButtonToPanel(department.getName());
        }
    }

    /** A method that updates the workers list. */
    public void updateWorkers(String departmentName) {
        Department department = departmentService.getByName(departmentName);

        if (department.equals(currentDepartment)) {
            return;
        }

        ArrayList<Worker> workers = workerService.getByDepartmentId(department.getTabelId());

        workerManager.rebuildWorkersModel(workers);

        currentDepartment = department;

        dateManager.updateCalendar(workers);
    }

    /** A method that updates worker day statuses by changing the month. */
    public void updateCalendar(Months month) {
        dateManager.updateMonth(month);
        // updateWorkers(currentDepartment.getName());
    }
}
