package kz.zhelezyaka.introduction.repositories;

import kz.zhelezyaka.introduction.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
