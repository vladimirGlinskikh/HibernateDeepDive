package kz.zhelezyaka.fundamentalsCore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kz.zhelezyaka.fundamentalsCore.entities.Employee;
import kz.zhelezyaka.fundamentalsCore.entities.Product;
import kz.zhelezyaka.fundamentalsCore.entities.Student;
import kz.zhelezyaka.fundamentalsCore.keys.StudentKey;
import kz.zhelezyaka.fundamentalsCore.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String persistentUnitName = "persistence_Unit_Name";
        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none");

        EntityManagerFactory entityManagerFactory =
                new HibernatePersistenceProvider()
                        .createContainerEntityManagerFactory(
                                new CustomPersistenceUnitInfo(persistentUnitName), props);

        try (EntityManager entityManager =
                     entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

//            Employee employee1 = new Employee();
//            employee1.setName("some name");
//            employee1.setAddress("some address");
//
//            entityManager.persist(employee1);
//
//            Product product = new Product();
//            product.setCode("Some Code");
//            product.setNumber(11L);
//            product.setName("Vladimir");
//
//            entityManager.persist(product);

            StudentKey studentKey = new StudentKey();
            studentKey.setCode("some student code");
            studentKey.setNumber(119);

//            Student student = new Student();
//            student.setId(studentKey);
//            student.setName("some student");
//
//            entityManager.persist(student);

            Student student = entityManager.find(Student.class, studentKey);
            System.out.println(student);

            entityManager.getTransaction().commit();
        }
    }
}
