package com.cts.intcdb22jf003.pms.services;

import java.util.List;

import com.cts.intcdb22jf003.pms.models.Product;

public interface ProductService {
public Product createNewProduct(Product product);
public Product updateNewProduct(Product product);
public Product getProduct(int pid);
public List<Product> getProduct();
public void deleteProduct(int id);
}
