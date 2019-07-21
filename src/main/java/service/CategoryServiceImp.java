package service;

import dao.CategoryDao;
import model.Category;
import model.CategoryCode;

import java.util.List;

public class CategoryServiceImp implements CategoryService {


    private CategoryDao categoryDao;

    public CategoryServiceImp(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category findById(long id) {
       return categoryDao.findById(id);

    }

    @Override
    public void insert(Category category) {
        if(validateCategory(category)){
            categoryDao.insert(category);
        }
    }

    @Override
    public boolean validateCategory(Category category) {
        List<String> categoryCodes = categoryDao.findCategoryCodes();
        if(!categoryCodes.contains(category.getCode())) ///name() pobiera stringa
        {
            return  true;
        }
        return false;
    }

    @Override
    public Long findIdCategory(CategoryCode categoryCode) {
        return categoryDao.findIdCategory(categoryCode);
    }
}
