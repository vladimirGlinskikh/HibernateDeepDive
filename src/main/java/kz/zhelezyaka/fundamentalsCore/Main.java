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
