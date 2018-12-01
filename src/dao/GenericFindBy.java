package dao;

public interface GenericFindBy<T> {

	T findByCode(String code);

	T findByName(String name);

}
