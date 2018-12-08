package dao;

import java.util.List;

import model.Category;

public interface CategoryDao extends BasicCrudDao<Category, Integer>, LogicDao<Category>, GenericFindBy<Category> {

	boolean existsGoods(Integer categoryId);
	
	List<Category> getListCategory(String name);

}
