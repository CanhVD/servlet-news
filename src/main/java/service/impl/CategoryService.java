package service.impl;

import dao.impl.CategoryDAO;
import model.Category;
import service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {

    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDAO.getCategoryById(id);
    }
}
