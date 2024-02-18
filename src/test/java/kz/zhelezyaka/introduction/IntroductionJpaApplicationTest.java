package kz.zhelezyaka.introduction;

import kz.zhelezyaka.introduction.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IntroductionJpaApplicationTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void testEmployeeRepository() {
        long count = employeeRepository.count();

        assertThat(count).isPositive();
    }
}