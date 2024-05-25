package org.example.service;

import org.example.entity.Product;
import org.example.entity.Category;
import org.example.entity.Supplier;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }


    public List<Product> findProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public List<Supplier> findSuppliersByProductId(Long productId) {
        return productRepository.findSuppliersByProductId(productId);
    }

}
