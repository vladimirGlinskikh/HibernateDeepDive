package kz.zhelezyaka.introduction.dao;

import kz.zhelezyaka.introduction.domain.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeDao {
    List<Employee> listEmployeeByName(String name);

    Employee getById(UUID id);

    Employee findEmployeeByName(String name);

    Employee saveNewEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(UUID id);
}
