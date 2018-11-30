package dao;

import model.Inventory;

/**
 * Giao diện hàng tồn kho
 * 
 * @author manhn
 */
public interface InventoryDao extends BasicCrudDao<Inventory, Integer> {

	Inventory findInventoryByStockIdAndGoodsId(Integer stockId, Integer goodsId);
	
	Inventory findInventoryByStockIdAndGoodsCode(Integer stockId, String goodsCode);

}
