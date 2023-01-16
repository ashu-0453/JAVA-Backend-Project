package org.hit.repository;

import org.hit.model.Product;

import java.util.List;

public interface ProductRepository {
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Integer productId);
    public List<Product> findAll();
    public Product findById(Integer productId);
}
