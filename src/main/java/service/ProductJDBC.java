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
            PreparedStatement statement = connection.prepareStatement(
                    "select * from jdbcproduct");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String describe = resultSet.getString("describer");
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
        Connection connection = getConnection();
        try {
            PreparedStatement  statement = connection.prepareStatement("insert into productlist.jdbcproduct(name, price, describer, producer) value (?,?,?,?)");
            statement.setString(1,product.getName());
            statement.setDouble(2,product.getPrice());
            statement.setString(3,product.getDescriber());
            statement.setString(4,product.getProducer());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(int id, Product product) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "update jdbcproduct set name =?, price = ?, describer = ?, producer = ? where id = ?");
            prepareStatement.setInt(5,product.getId());
            prepareStatement.setString(1,product.getName());
            prepareStatement.setDouble(2,product.getPrice());
            prepareStatement.setString(3,product.getDescriber());
            prepareStatement.setString(4,product.getProducer());
            prepareStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from jdbcproduct where id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Product getProductByID(int id) {
        Product product= null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from JDBCproduct where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String describer= resultSet.getString("describer");
                String producer= resultSet.getString("producer");
                product = new Product(id1,name,price,describer,producer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;

    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }
}
