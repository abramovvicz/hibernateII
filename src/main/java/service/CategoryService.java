package service;

import model.Category;
import model.CategoryCode;

public interface CategoryService {

    Category findById(long id);

    void insert(Category category);

    boolean validateCategory(Category category);

    Long findIdCategory(CategoryCode categoryCode);

}
