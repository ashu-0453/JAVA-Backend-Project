package org.hit.service;

import org.hit.model.Product;
import org.hit.repository.MySQL.ProductRepositoryImpl;
import org.hit.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private ProductRepository repository=new ProductRepositoryImpl();

    @Override
    public boolean addProduct(Product product) {
        if(repository.addProduct(product)==null)
            return false;
        else
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        if(repository.updateProduct(product)==null)
        return false;
        else
            return true;
    }

    @Override
    public boolean deleteProduct(Integer productId) {
        if(repository.deleteProduct(productId)==null)
        return false;
        else
            return true;
    }

    @Override
    public List<Product> findAll() {

        return repository.findAll();
    }

    @Override
    public Product findById(Integer productId) {
        if(repository.findById(productId)==null)
        return null;
        else
            return repository.findById(productId);
    }
}
