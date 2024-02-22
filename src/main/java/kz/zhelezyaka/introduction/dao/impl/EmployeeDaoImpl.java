package kz.zhelezyaka.introduction.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import kz.zhelezyaka.introduction.dao.EmployeeDao;
import kz.zhelezyaka.introduction.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<Employee> listEmployeeByName(String name) {
        EntityManager entityManager = getEntityManager();

        try {
            Query query = entityManager
                    .createQuery("SELECT e FROM Employee e WHERE e.name like :name");
            query.setParameter("name", name + "%");
            List<Employee> employees = query.getResultList();
            return employees;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Employee getById(UUID id) {
        return getEntityManager().find(Employee.class, id);
    }

    @Override
    public Employee findEmployeeByName(String name) {
            TypedQuery<Employee> query =
                    getEntityManager().createQuery("SELECT e FROM Employee e " +
                            "WHERE e.name = :name", Employee.class);
            query.setParameter("name", name);
            return query.getSingleResult();
    }

    @Transactional
    @Override
    public Employee saveNewEmployee(Employee employee) {
        EntityManager entityManager = getEntityManager();
        entityManager.joinTransaction();
        entityManager.persist(employee);
        entityManager.flush();
        return employee;
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {
        EntityManager entityManager = getEntityManager();
        entityManager.joinTransaction();
        entityManager.merge(employee);
        entityManager.flush();
        entityManager.clear();
        return entityManager.find(Employee.class, employee.getId());
    }

    @Transactional
    @Override
    public void deleteEmployeeById(UUID id) {
        EntityManager entityManager = getEntityManager();
        entityManager.joinTransaction();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
        entityManager.flush();
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
