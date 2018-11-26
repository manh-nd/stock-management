package dao;

public interface LogicDao<T> {

	boolean delete(T object, boolean active);
	
}
