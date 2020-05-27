package com.stepyrev.nauka.test.service;

import com.stepyrev.nauka.entity.Worker;
import com.stepyrev.nauka.entity.WorkerCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.service.impl.WorkerCalendarServiceImpl;
import com.stepyrev.nauka.test.config.TestDataBaseConfig;
import com.stepyrev.nauka.test.util.WorkerCalendarUtil;
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
public class WorkerCalendarTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private WorkerCalendarServiceImpl calendarService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void addWorkerCalendarTest() {
        calendarService.addWorkerCalendar(WorkerCalendarUtil.createCalendar());
    }

    @Test
    public void deleteTest() {
        calendarService.addWorkerCalendar(WorkerCalendarUtil.createCalendar());
        calendarService.delete(1);
    }

    @Test
    public void getByWorkerAndMonthTest() {
        Worker worker = WorkerCalendarUtil.createWorker();
        WorkerCalendar workerCalendar = WorkerCalendarUtil.createCalendar();
        workerCalendar.setMonth(Months.FEBRUARY);
        calendarService.addWorkerCalendar(workerCalendar);
        calendarService.addWorkerCalendar(workerCalendar);

        Assert.assertEquals(2, calendarService.getByWorkerIdAndMonth(worker.getTabelId(), workerCalendar.getMonth()).size());
    }

    @Test
    public void getByWorkerTest() {
        Worker worker = WorkerCalendarUtil.createWorker();
        worker.setTabelId(2);

        WorkerCalendar workerCalendar = WorkerCalendarUtil.createCalendar();
        workerCalendar.setWorkerId(2);

        calendarService.addWorkerCalendar(workerCalendar);
        calendarService.addWorkerCalendar(workerCalendar);

        Assert.assertEquals(2, calendarService.getByWorkerId(worker.getTabelId()).size());
    }

    @Test
    public void getByWorkerAndMonthAndDayTest() {
        Worker worker = WorkerCalendarUtil.createWorker();
        worker.setTabelId(3);

        WorkerCalendar workerCalendar = WorkerCalendarUtil.createCalendar();
        workerCalendar.setWorkerId(3);
        workerCalendar.setMonth(Months.JUNE);

        calendarService.addWorkerCalendar(workerCalendar);

        WorkerCalendar foundCalendar =  calendarService.getByWorkerIdAndMonthAndDay(worker.getTabelId(),
                workerCalendar.getMonth(), workerCalendar.getDay());

        Assert.assertEquals(workerCalendar.getDayStatus(), foundCalendar.getDayStatus());
    }
}
