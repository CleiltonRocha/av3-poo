package org.example.controller;

import org.example.dto.ProductRequestDTO;
import org.example.entity.Category;
import org.example.entity.Product;
import org.example.entity.Supplier;
import org.example.service.CategoryService;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDTO productRequest) {
        Category category = categoryService.findById(productRequest.getCategoryId());

        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCategory(category);
        productService.addProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body("Product successfully created");
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long categoryId) {
        Category category = categoryService.findById(categoryId);

        System.out.println("Category: " + category);

        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<Product> products = productService.findProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}/suppliers")
    public List<Supplier> getSuppliersByProduct(@PathVariable Long productId) {
        return productService.findSuppliersByProductId(productId);
    }
}
