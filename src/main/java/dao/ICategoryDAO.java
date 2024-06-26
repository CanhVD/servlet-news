package dao;

import model.Category;

import java.util.List;

public interface ICategoryDAO {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}
