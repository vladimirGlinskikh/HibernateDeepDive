package kz.zhelezyaka.fundamentalsCore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kz.zhelezyaka.fundamentalsCore.entities.Product;
import kz.zhelezyaka.fundamentalsCore.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory =
//                Persistence.createEntityManagerFactory("persistence");

        EntityManagerFactory entityManagerFactory =
                new HibernatePersistenceProvider()
                        .createContainerEntityManagerFactory(
                                new CustomPersistenceUnitInfo(), new HashMap<>());

        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            Product product = new Product();
            product.setName("Champagne");
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        }
    }
}
