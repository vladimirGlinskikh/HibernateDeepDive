package kz.zhelezyaka.introduction.repositories;

import kz.zhelezyaka.introduction.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
