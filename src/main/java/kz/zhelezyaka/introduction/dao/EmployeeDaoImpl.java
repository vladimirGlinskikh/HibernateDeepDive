package kz.zhelezyaka.introduction.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kz.zhelezyaka.introduction.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Employee getById(UUID id) {
        return getEntityManager().find(Employee.class, id);
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return null;
    }

    @Override
    public Employee saveNewEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployeeById(UUID id) {

    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
