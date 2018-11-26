package dao;

import model.Producer;

/**
 * Giao diện ProducerDao thực hiện các nghiệp vụ liên quan đến đối tượng
 * Producer
 * 
 * @author maudd
 *
 */
public interface ProducerDao extends BasicCrudDao<Producer, Integer>, LogicDao<Producer> {

	/**
	 * Tìm nhà cung cấp <code>Producer</code> bằng mã <code>code</code>
	 * @param code - Mã nhà cung cấp
	 * @return trả về 1 nhà cung cấp <code>Producer</code> có mã là <code>code</code>
	 */
	Producer findByCode(String code);
}
