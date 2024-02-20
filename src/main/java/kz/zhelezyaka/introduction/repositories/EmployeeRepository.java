package kz.zhelezyaka.introduction.repositories;

import kz.zhelezyaka.introduction.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
