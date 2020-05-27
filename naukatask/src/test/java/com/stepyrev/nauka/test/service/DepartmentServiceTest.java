package com.stepyrev.nauka.test.service;

import com.stepyrev.nauka.entity.Department;
import com.stepyrev.nauka.service.DepartmentService;
import com.stepyrev.nauka.test.config.TestDataBaseConfig;
import com.stepyrev.nauka.test.util.DepartmentUtil;
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
public class DepartmentServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private DepartmentService departmentService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveDepartment() throws Exception {
        departmentService.addDepartment(DepartmentUtil.createDepartment());
    }

    @Test
    public void testDeleteDepartment() throws Exception {
        departmentService.addDepartment(DepartmentUtil.createDepartment());
        departmentService.delete(1);
    }

    @Test
    public void testGetAllDepartment() throws Exception {
        departmentService.addDepartment(DepartmentUtil.createDepartment());
        departmentService.addDepartment(DepartmentUtil.createDepartment());
        departmentService.addDepartment(DepartmentUtil.createDepartment());
        Assert.assertEquals(3, departmentService.getAll().size());
    }

    @Test
    public void testGetDepartmentByName() throws Exception {
        departmentService.addDepartment(DepartmentUtil.createDepartment());
        Department nauka = departmentService.getByName("Nauka");

        Assert.assertEquals("Nauka", nauka.getName());
    }
}
