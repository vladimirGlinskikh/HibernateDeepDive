package kz.zhelezyaka.introduction.dao;

import kz.zhelezyaka.introduction.domain.Employee;

import java.util.UUID;

public interface EmployeeDao {
    Employee getById(UUID id);

    Employee findEmployeeByName(String name);

    Employee saveNewEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(UUID id);
}
