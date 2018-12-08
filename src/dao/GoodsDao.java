package dao;

import java.util.List;

import dto.GoodsDto;
import model.Goods;

public interface GoodsDao extends BasicCrudDao<Goods, Integer>, LogicDao<Goods> {

	Goods findByGoodsCode(String goodsCode);

	List<GoodsDto> findByStockId(Integer stockId);
	
	List<GoodsDto> findByStockId(Integer stockId, String key);

}
