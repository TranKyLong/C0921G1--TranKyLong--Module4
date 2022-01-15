package app.service;

import app.model.Product;
import app.reponsitory.IProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductReponsitory productReponsitory;

    @Override
    public List<Product> findAllProduct() {
        return productReponsitory.findAllProduct();
    }


    @Override
    public Product findById(int id) {
        return productReponsitory.findById(id);
    }

    @Override
    public void editProduct(Product product) {
        productReponsitory.editProduct(product);

    }

    @Override
    public void deleteProduct(int id) {
        productReponsitory.deleteProduct(id);

    }

    @Override
    public void addNew(Product product) {
        productReponsitory.addNew(product);

    }

    @Override
    public List<Product> findByName(String name) {
        return productReponsitory.findByName(name);
    }
}
