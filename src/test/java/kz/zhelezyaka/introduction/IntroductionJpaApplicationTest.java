package kz.zhelezyaka.introduction;

import kz.zhelezyaka.introduction.dao.EmployeeDao;
import kz.zhelezyaka.introduction.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IntroductionJpaApplicationTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void testGetEmployee() {
        Employee employee = employeeDao
                .getById(UUID.fromString("e10410fb-6ca0-45fc-aa84-df4b665a0e15"));
        assertThat(employee).isNotNull();
    }
}