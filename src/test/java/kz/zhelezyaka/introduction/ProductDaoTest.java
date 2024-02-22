package kz.zhelezyaka.introduction;

import kz.zhelezyaka.introduction.dao.ProductDao;
import kz.zhelezyaka.introduction.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    void testFindAllProducts() {
        List<Product> products = productDao.findAll();
        assertThat(products).isNotNull();
        assertThat(products.size()).isGreaterThan(0);
    }

    @Test
    void shouldFindByName() {
        Product product = productDao.findByName("laptop");
        assertThat(product).isNotNull();
    }

    @Test
    void getById() {
        Product product = productDao
                .getById(UUID.fromString("7903b1db-a018-462b-a0d9-dcbe4bcb1f06"));
        assertThat(product).isNotNull();
    }

    @Test
    void saveNewProduct() {
        Product product = new Product();
        product.setName("keyboard");
        Product saved = productDao.saveNewProduct(product);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void updateProduct() {
        Product product = new Product();
        product.setName("keyboard");
        Product saved = productDao.saveNewProduct(product);
        saved.setName("keyboard_new");
        Product updated = productDao.updateProduct(saved);

        assertThat(updated.getName()).isEqualTo("keyboard_new");
    }

    @Test
    void deleteProductById() {
        Product product = new Product();
        product.setName("keyboard_new");

        Product saved = productDao.saveNewProduct(product);
        productDao.deleteProductById(saved.getId());

        Product deleted = productDao.getById(saved.getId());

        assertThat(deleted).isNull();
    }
}
