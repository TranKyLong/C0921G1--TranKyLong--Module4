package app.reponsitory;

import app.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductReponsitory {
    List<Product>findAllProduct();
    Product findById(int id);
    List<Product> findByName(String name);
    void editProduct(Product product);
    void deleteProduct(int id);
    void addNew(Product product);
}
