package kz.zhelezyaka.relationships.oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kz.zhelezyaka.relationships.oneToMany.entities.Comment;
import kz.zhelezyaka.relationships.oneToMany.entities.Post;
import kz.zhelezyaka.relationships.oneToMany.persistence.CustomPersistenceUnitInfo;
import kz.zhelezyaka.relationships.oneToOne.entities.Passport;
import kz.zhelezyaka.relationships.oneToOne.entities.Person;
import kz.zhelezyaka.relationships.oneToOne.entities.User;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
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

            Post post = new Post();
            post.setTitle("This is a post number 1");
            post.setContent("This is a description for post number 1");

            Comment comment = new Comment();
            comment.setContent("This is a content for comment");

            Comment comment1 = new Comment();
            comment1.setContent("This is a content for comment 1");

            post.setComments(List.of(comment, comment1));
            comment.setPost(post);
            comment1.setPost(post);

            entityManager.persist(post);


            entityManager.getTransaction().commit();
        }
    }
}

