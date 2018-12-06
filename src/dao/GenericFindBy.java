package dao;

public interface GenericFindBy<T> {

	T findByCode(String code);

	T findByName(String name);
	
	String findNameById(Integer id);
	
	boolean isDuplicateAnotherName(String name, Integer id);

}
