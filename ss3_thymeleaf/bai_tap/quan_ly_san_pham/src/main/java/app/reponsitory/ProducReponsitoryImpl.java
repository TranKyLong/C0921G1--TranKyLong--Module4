package app.reponsitory;

import app.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProducReponsitoryImpl implements IProductReponsitory {

    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Asus Rog Trix ", 100.0, "Blue", "ASUS"));
        productList.add(new Product(2, "Asus G.A.M.E.R ", 200.0, "Crimson", "ASUS"));
    }

    @Override
    public List<Product> findAllProduct() {
        return productList;
    }


    @Override
    public Product findById(int id) {
        for (Product p : productList
        ) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : productList
        ) {
            if (p.getName().contains(name)) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public void editProduct(Product product) {
        for (Product p : productList
        ) {
            if (p.getId().equals(product.getId())) {
                productList.set(productList.indexOf(p), product);
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        productList.removeIf(p -> id == p.getId());

    }

//    public static void main(String[] args) {
//        ProducReponsitoryImpl i = new ProducReponsitoryImpl();
//        i.deleteProduct(1);
//    }

    @Override
    public void addNew(Product product) {
        /** Nếu list product rỗng thì id của product vừa được thêm là 1,
         * nếu không rỗng thì id tự tăng bằng id product cuosi cùng trong list +1*/
        if (productList.isEmpty()) {
            product.setId(1);
        } else {
            int newid = productList.get(productList.size() - 1).getId() + 1;
            product.setId(newid);

        }
        productList.add(product);
    }
}
