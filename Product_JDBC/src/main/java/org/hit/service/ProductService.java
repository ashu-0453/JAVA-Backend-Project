package org.hit.service;

import org.hit.model.Product;

import java.util.List;

public interface ProductService {
    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(Integer productId);
    public List<Product> findAll();
    public Product findById(Integer productId);


}
