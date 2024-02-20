package kz.zhelezyaka.introduction.repositories;

import kz.zhelezyaka.introduction.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
