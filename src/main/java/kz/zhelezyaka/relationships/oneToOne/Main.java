package kz.zhelezyaka.relationships.oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import kz.zhelezyaka.relationships.oneToOne.entities.Passport;
import kz.zhelezyaka.relationships.oneToOne.entities.Person;
import kz.zhelezyaka.relationships.oneToOne.entities.User;
import kz.zhelezyaka.relationships.oneToOne.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String persistentUnitName = "persistence_Unit_Name";
        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");

        EntityManagerFactory entityManagerFactory =
                new HibernatePersistenceProvider()
                        .createContainerEntityManagerFactory(
                                new CustomPersistenceUnitInfo(persistentUnitName), props);

        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            Person person = new Person();
            person.setName("Vladimir");

            Passport passport = new Passport();
            passport.setNumber("12345ABCD");

            person.setPassport(passport);
            passport.setPerson(person);

            entityManager.persist(person);

//            TypedQuery<Person> query = entityManager.createQuery(
//                    "SELECT p FROM Person p WHERE p.passport.number = :number", Person.class);
//            query.setParameter("number", "l34lls0gls");
//            System.out.println(query.getResultList());

            User user = new User();
            user.setName("Nikolay");
            user.setDescription("another user");
            entityManager.persist(user);

            entityManager.getTransaction().commit();
        }
    }
}

