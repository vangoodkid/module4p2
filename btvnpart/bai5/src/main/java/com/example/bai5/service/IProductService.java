package com.example.bai5.service;


import com.example.bai5.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(Long id);
    void delete(Long id);
    List<Product> search(String name);
}
