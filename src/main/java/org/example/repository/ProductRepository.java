package org.example.repository;

import org.example.entity.Product;
import org.example.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);

    @Query(value = "SELECT s.* FROM suppliers s INNER JOIN product_supplier ps ON s.id = ps.supplier_id WHERE ps.product_id = :productId", nativeQuery = true)
    List<Supplier> findSuppliersByProductId(@Param("productId") Long productId);
}
