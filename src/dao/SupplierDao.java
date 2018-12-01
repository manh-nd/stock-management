package dao;

import model.Supplier;

public interface SupplierDao extends BasicCrudDao<Supplier, Integer>, LogicDao<Supplier>, GenericFindBy<Supplier> {

	boolean existsGoods(Integer supplierId);

}
