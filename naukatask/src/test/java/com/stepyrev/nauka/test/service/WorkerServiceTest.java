package com.stepyrev.nauka.test.service;

import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.entity.Worker;
import com.stepyrev.nauka.service.DepartmentService;
import com.stepyrev.nauka.service.WorkerService;
import com.stepyrev.nauka.test.config.TestDataBaseConfig;
import com.stepyrev.nauka.test.util.WorkerUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class WorkerServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private WorkerService workerService;
    @Resource
    private DepartmentService departmentService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveWorker() throws Exception {
        workerService.addWorker(WorkerUtil.createWorker());
    }

    @Test
    public void testDeleteWorker() throws Exception {
        workerService.addWorker(WorkerUtil.createWorker());
        workerService.delete(1);
    }

    @Test
    public void testGetByName() throws Exception {
        Worker worker = WorkerUtil.createWorker();

        workerService.addWorker(worker);
        Worker gotWorker = workerService.getByName(worker.getName());
        Assert.assertEquals(worker.getName(), gotWorker.getName());
    }

    @Test
    public void testGetByTabelId() throws Exception {
        Worker worker = WorkerUtil.createWorker();
        worker.setTabelId(10);

        workerService.addWorker(worker);
        Worker gotWorker = workerService.getByTabelId(worker.getTabelId());
        Assert.assertEquals(worker.getTabelId(), gotWorker.getTabelId());
    }

    @Test
    public void testGetAllWorkers() throws Exception {
        Department department = new Department();
        department.setTabelId(1);
        department.setName("Nauka");
        departmentService.addDepartment(department);

        workerService.addWorker(WorkerUtil.createWorker(1));
        workerService.addWorker(WorkerUtil.createWorker(1));
        workerService.addWorker(WorkerUtil.createWorker(1));
        Assert.assertEquals(3, workerService.getByDepartmentId(1).size());
    }
}
