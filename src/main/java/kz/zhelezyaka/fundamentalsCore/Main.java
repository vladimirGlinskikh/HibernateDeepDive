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
        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update");

        EntityManagerFactory entityManagerFactory =
                new HibernatePersistenceProvider()
                        .createContainerEntityManagerFactory(
                                new CustomPersistenceUnitInfo(persistentUnitName), props);

        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

//            Employee employee = entityManager.find(Employee.class, 1);
//            Product product = entityManager.find(Product.class, 1);

//            var employee1 = new Employee();
//            employee1.setId(2);
//            employee1.setAddress("Address");
//            employee1.setName("Nikolay");
//
//            entityManager.persist(employee1);
//
//            employee1 = entityManager.find(Employee.class, 2);
//            System.out.println(employee1);

            var employee1 = entityManager.getReference(Employee.class, 1);
            System.out.println(employee1);
            employee1.setId(1);
            employee1.setName("Nina");
            System.out.println("Before: " + employee1);
            entityManager.refresh(employee1);
            System.out.println("After: " + employee1);

//            entityManager.persist(); Adding on entity in the context
//            entityManager.find(); Finds by Primary Key, Get from Database and add it to the context if it doesn't already exist
//            entityManager.remove(); Marking entity for removal
//            entityManager.merge(); Merges an entity from outside the context to the context
//            entityManager.refresh(); Mirror the context from the database
//            entityManager.detach(); Taking the entity out of the context

            entityManager.getTransaction().commit();
        }
    }
}
