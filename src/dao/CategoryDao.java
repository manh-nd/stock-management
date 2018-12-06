package dao;

import model.Category;

public interface CategoryDao extends BasicCrudDao<Category, Integer>, LogicDao<Category>, GenericFindBy<Category> {

	boolean existsGoods(Integer categoryId);

}
