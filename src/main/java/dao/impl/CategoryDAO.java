package dao.impl;

import dao.ICategoryDAO;
import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/servlet_news";
            String user = "root";
            String password = "blackclover";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> results = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                category.setCode(resultSet.getString("code"));
                results.add(category);
            }
            return results;
        } catch (SQLException e) {
            return null;
        } finally {
            disConnection();
        }
    }

    @Override
    public Category getCategoryById(Long id) {
        List<Category> results = new ArrayList<>();
        String sql = "SELECT * FROM category WHERE id = ?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                category.setCode(resultSet.getString("code"));
                results.add(category);
            }
            return results.isEmpty() ? null : results.get(0);
        } catch (SQLException e) {
            return null;
        } finally {
            disConnection();
        }
    }

    public void disConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
