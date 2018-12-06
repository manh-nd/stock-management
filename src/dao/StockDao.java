package dao;

import model.Stock;

public interface StockDao extends BasicCrudDao<Stock, Integer>, LogicDao<Stock>, GenericFindBy<Stock> {

}
