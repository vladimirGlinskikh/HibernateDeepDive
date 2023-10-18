package kz.zhelezyaka.fundamentalsCore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kz.zhelezyaka.fundamentalsCore.entities.Employee;
import kz.zhelezyaka.fundamentalsCore.entities.Product;
import kz.zhelezyaka.fundamentalsCore.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String persistentUnitName = "persistence_Unit_Name";
        Map<?, ?> props = new HashMap<>();

        EntityManagerFactory entityManagerFactory =
                new HibernatePersistenceProvider()
                        .createContainerEntityManagerFactory(
                                new CustomPersistenceUnitInfo(persistentUnitName), props);

        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            Employee employee = entityManager.find(Employee.class, 1);
            Product product = entityManager.find(Product.class, 1);
            employee.setName("Vladimir Glinskikh");
            employee.setName("Svetlana Svetina");
            System.out.println(employee);
            System.out.println(product);
            entityManager.getTransaction().commit();
        }
    }
}
