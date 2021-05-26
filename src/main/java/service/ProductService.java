package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements ProductInterface{
    private static List<Product> productList = new ArrayList<>();
    static {
        Product product1 = new Product(1,"iphone",2000,"","apple");
        Product product2 = new Product(2,"SamSung",2000,"","SamSung");
        Product product3 = new Product(3,"NoKia",2000,"","NoKia");
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }
    @Override
    public List<Product> showAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);

    }

    @Override
    public void update(int id, Product product) {
        productList.set(id,product);

    }

    @Override
    public void remove(int id) {
        productList.remove(productList.get(id));

    }

    @Override
    public Product getProductByID(int id) {
        Product product = null;
        for (int i = 0; i< productList.size(); i++){
            if (productList.get(i).getId()==id){
                product = productList.get(i);
                return product;
            }
        }
        return product;
    }

    @Override
    public Product getProductByName(String name) {
        Product product = null;
        for (int i = 0; i< productList.size(); i++){
            if (productList.get(i).getName()==name){
                product = productList.get(i);
                return product;
            }
        }
        return product;
    }
}
