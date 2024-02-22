package kz.zhelezyaka.introduction.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import kz.zhelezyaka.introduction.dao.ProductDao;
import kz.zhelezyaka.introduction.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<Product> findAll() {
        try (EntityManager entityManager = getEntityManager()) {
            TypedQuery<Product> typedQuery =
                    entityManager.createNamedQuery("product_find_all",
                            Product.class);
            return typedQuery.getResultList();
        }
    }

    @Override
    public Product findByName(String name) {
        TypedQuery<Product> query =
                getEntityManager().createQuery("SELECT p FROM Product p " +
                        "WHERE p.name = :name", Product.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public Product getById(UUID id) {
        EntityManager entityManager = getEntityManager();
        Product product = getEntityManager().find(Product.class, id);
        entityManager.close();
        return product;
    }

    @Transactional
    @Override
    public Product saveNewProduct(Product product) {
        EntityManager entityManager = getEntityManager();
        entityManager.joinTransaction();
        entityManager.persist(product);
        entityManager.flush();
        return product;
    }

    @Transactional
    @Override
    public Product updateProduct(Product product) {
        EntityManager entityManager = getEntityManager();
        entityManager.joinTransaction();
        entityManager.merge(product);
        entityManager.flush();
        entityManager.clear();
        return entityManager.find(Product.class, product.getId());
    }

    @Transactional
    @Override
    public void deleteProductById(UUID id) {
        EntityManager entityManager = getEntityManager();
        entityManager.joinTransaction();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.flush();
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
