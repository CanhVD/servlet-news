package service;

import model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}
