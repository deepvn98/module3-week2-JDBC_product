package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductJDBC implements ProductInterface{
    private Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/productlist",
                        "sangnguyen",
                        "677264"
                );
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<Product> showAll() {
        Connection connection = getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from jdbcproduct");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String describe = resultSet.getString("describe");
                String producer = resultSet.getString("producer");
                Product product = new Product(id,name,price,describe,producer);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Product getProductByID(int id) {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }
}
