package kz.zhelezyaka.introduction.dao;

import kz.zhelezyaka.introduction.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {
    List<Product> findAll();

    Product findByName(String name);

    Product getById(UUID id);

    Product saveNewProduct(Product product);

    Product updateProduct(Product product);

    void deleteProductById(UUID id);
}
