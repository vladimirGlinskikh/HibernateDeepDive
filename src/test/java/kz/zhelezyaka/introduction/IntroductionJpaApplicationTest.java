package kz.zhelezyaka.introduction;

import kz.zhelezyaka.introduction.dao.EmployeeDao;
import kz.zhelezyaka.introduction.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IntroductionJpaApplicationTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void testListEmployeeByName() {
        List<Employee> employees = employeeDao.listEmployeeByName("Vlad");

        assertThat(employees).isNotNull();
        assertThat(employees.size()).isGreaterThan(0);
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setName("Vladimir");

        Employee saved = employeeDao.saveNewEmployee(employee);
        employeeDao.deleteEmployeeById(saved.getId());

        Employee deleted = employeeDao.getById(saved.getId());

        assertThat(deleted).isNull();
        assertThat(employeeDao.getById(saved.getId()));
    }

    @Test
    void testUpdateEntity() {
        Employee employee = new Employee();
        employee.setName("Alexandr");

        Employee saved = employeeDao.saveNewEmployee(employee);
        saved.setName("Egor");
        Employee updated = employeeDao.updateEmployee(saved);

        assertThat(updated.getName()).isEqualTo("Egor");
    }

    @Test
    void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setName("Vladimir");
        Employee saved = employeeDao.saveNewEmployee(employee);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void testGetEmployeeByName() {
        Employee employee = employeeDao.findEmployeeByName("Svetlana");
        assertThat(employee).isNotNull();
    }

    @Test
    void testGetEmployee() {
        Employee employee = employeeDao
                .getById(UUID.fromString("e10410fb-6ca0-45fc-aa84-df4b665a0e15"));
        assertThat(employee).isNotNull();
    }
}