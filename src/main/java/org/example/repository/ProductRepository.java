package org.example.repository;

import org.example.entity.Product;
import org.example.entity.Category;
import org.example.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    @Query("SELECT s FROM Supplier s JOIN s.products p WHERE p.id = :productId")
    List<Supplier> findSuppliersByProductId(@Param("productId") Long productId);
}
