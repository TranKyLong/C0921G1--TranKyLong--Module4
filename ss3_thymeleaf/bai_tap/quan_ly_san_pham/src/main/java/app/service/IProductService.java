package app.service;

import app.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
   List<Product> findAllProduct();
    Product findById(int id);
    void editProduct(Product product);
    void deleteProduct(int id);
    void addNew(Product product);
    List<Product> findByName(String name);
}
