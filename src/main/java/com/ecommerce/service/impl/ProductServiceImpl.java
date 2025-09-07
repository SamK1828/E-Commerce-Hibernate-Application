package com.ecommerce.service.impl;

import java.util.List;

import com.ecommerce.dao.DAOProduct;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private final DAOProduct productDao;

    public ProductServiceImpl(DAOProduct productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product createProduct(Product product) {
        productDao.saveProduct(product);
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.getProductById(id.intValue());
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public Product updateProduct(Product product) {
        productDao.updateProduct(product);
        return product;
    }

    @Override
    public boolean deleteProduct(Long id) {
        Product product = productDao.getProductById(id.intValue());
        if (product != null) {
            productDao.deleteProduct(product);
            return true;
        }
        return false;
    }
}
