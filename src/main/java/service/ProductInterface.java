package service;

import model.Product;

import java.util.List;

public interface ProductInterface {
    public List<Product> showAll();

    public void create(Product product);


    public void update(int id,Product product);


    public void remove(int id);

    Product getProductByID(int id);


    Product getProductByName(String name);
}
