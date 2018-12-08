package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import dao.ReportDao;
import dto.CategoryGoodsReport;
import dto.ExpirationGoodsReport;
import dto.SupplierGoodsReport;

public class ReportDaoImpl implements ReportDao {

	@SessionTarget
	private Session session;
	
	@TransactionTarget
	private Transaction transaction;

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryGoodsReport> getCategoryGoodsReport() {
		try {
			return session.createQuery(
					"SELECT new dto.CategoryGoodsReport(c.name, sum(i.quantity), sum(g.exportPrice * i.quantity)) "
							+ "FROM Category c LEFT JOIN c.goods g LEFT JOIN g.inventories i "
							+ "WHERE c.active = true GROUP BY c.name ORDER BY sum(i.quantity) DESC")
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplierGoodsReport> getSupplierGoodsReport() {
		try {
			return session.createQuery(
					"SELECT new dto.SupplierGoodsReport(s.name, sum(i.quantity), sum(g.exportPrice * i.quantity)) "
							+ "FROM Supplier s LEFT JOIN s.goods g LEFT JOIN g.inventories i "
							+ "WHERE s.active = true GROUP BY s.name ORDER BY sum(i.quantity) DESC")
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpirationGoodsReport> getExpirationGoodsReport() {
		try {
			return session.createQuery(
					"SELECT new dto.ExpirationGoodsReport(g.code, g.name, g.category.name, g.supplier.name, s.name, g.expiration, i.quantity) "
							+ "FROM Goods g JOIN g.inventories i JOIN i.stock s "
							+ "WHERE (g.active = true AND s.active = true AND g.category.active = true AND g.supplier.active = true AND g.producer.active = true) "
							+ "AND (datediff(g.expiration, current_date()) BETWEEN 1 AND 30)")
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
