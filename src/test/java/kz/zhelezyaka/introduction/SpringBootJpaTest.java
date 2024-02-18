package kz.zhelezyaka.introduction;

import kz.zhelezyaka.introduction.domain.Employee;
import kz.zhelezyaka.introduction.repositories.EmployeeRepository;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SpringBootJpaTest {

    @Container
    public PostgreSQLContainer<?> pgsql =
            new PostgreSQLContainer<>("postgres:latest");

    @Autowired
    EmployeeRepository employeeRepository;

    long start = System.currentTimeMillis();

    @Test
    void shouldSaveEmployee() {
        var countBefore = employeeRepository.findAll();
        assertThat(countBefore).isEmpty();

        employeeRepository.save(new Employee(1L, "Nikolay", "Sanrigaylo 68"));
        var countAfter = employeeRepository.findAll();

        assertThat(countAfter).hasSize(1);
    }

    @Test
    void shouldDeleteAllEmployee() {
        employeeRepository.deleteAll();
        Assertions.assertTrue(!employeeRepository.findAll().iterator().hasNext(),
                () -> "there should be no data");
        long end = System.currentTimeMillis() - start;
        System.out.println("Time execution: " + end + " hc");
    }
}
