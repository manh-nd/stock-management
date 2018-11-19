package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Giao diện CRUD cơ bản.
 *
 * @param <T> Kiểu dữ liệu
 * @param <ID> ID của kiểu dữ liệu <code>&ltT&gt</code>
 * 
 * @author Manh Nguyen
 */
public interface BasicCrudDao<T, ID extends Serializable> { // Lưu ý, không sửa hay thêm gì vào đây

	/**
	 * Lưu 1 đối tượng <code>object</code> có kiểu <code>&ltT&gt</code>
	 * 
	 * @param object tham số truyền vào là 1 đối tượng kiểu <code>&ltT&gt</code>
	 * @return Trả về một đối tượng có kiểu <code>&ltT&gt</code>, bao gồm cả ID
	 * @throws Exception
	 * @author Manh Nguyen
	 */
	T save(T object);

	/**
	 * Cập nhật 1 đối tượng <code>object</code> có kiểu là <code>&ltT&gt</code>
	 * 
	 * @param object
	 * @return
	 */
	T update(T object);

	void saveOrUpdate(T object);

	boolean delete(T object);

	T findById(Class<T> clazz, ID id);

	List<T> findAll(Class<T> clazz);

}
