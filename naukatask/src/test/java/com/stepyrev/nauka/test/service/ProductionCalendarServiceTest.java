package com.stepyrev.nauka.test.service;

import com.stepyrev.nauka.entity.ProductionCalendar;
import com.stepyrev.nauka.entity.enums.Months;
import com.stepyrev.nauka.service.impl.ProductionCalendarServiceImpl;
import com.stepyrev.nauka.test.config.TestDataBaseConfig;
import com.stepyrev.nauka.test.util.ProductionCalendarUtil;
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
public class ProductionCalendarServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private ProductionCalendarServiceImpl calendarService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void addWorkerTest() {
        calendarService.addWorkerCalendar(ProductionCalendarUtil.createCalendar());
    }

    @Test
    public void deleteTest() {
        calendarService.addWorkerCalendar(ProductionCalendarUtil.createCalendar());
        calendarService.delete(1);
    }

    @Test
    public void getByIdAndDayAndMonthTest() {
        ProductionCalendar testCalendar = ProductionCalendarUtil.createCalendar();
        calendarService.addWorkerCalendar(testCalendar);

        ProductionCalendar foundCalendar = calendarService.getByTabelIdAndDayAndMonth(1, 1, Months.JANUARY);
        Assert.assertEquals(testCalendar.getDayStatus(), foundCalendar.getDayStatus());
    }
}
