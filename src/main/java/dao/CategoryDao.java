package dao;

import model.Category;
import model.CategoryCode;

import java.util.List;

public interface CategoryDao {

    Category findById(long id);

    void insert(Category category);

    List<String> findCategoryCodes();

    Long findIdCategory(CategoryCode categoryCode);
}
