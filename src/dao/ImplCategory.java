package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.Connector;
import models.StatisticalCategory;

public class ImplCategory implements Icategory {

	@Override
	public int Add(String name) {
		Connection cons = Connector.getConnection();
		String sql = "INSERT INTO category(category_name) VALUES (?)";
		int rs = -1;
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeUpdate();
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int Delete(int id) {
		Connection cons = Connector.getConnection();
		String sql = "DELETE FROM category WHERE category_id = ?";
		int rs = -1;
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeUpdate();
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int Update(int id, String name) {
		Connection cons = Connector.getConnection();
		String sql = "UPDATE category SET category_name = ? WHERE category_id = ?";
		int rs = -1;
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			rs = ps.executeUpdate();
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public Category getCategoryById(int id) throws SQLException {
		Connection cons = Connector.getConnection();
		String sql = "SELECT * FROM category WHERE category_id = ?";
		Category category = new Category();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
			}

			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public List<Category> getListCategory() throws SQLException {
		Connection cons = Connector.getConnection();
		String sql = "SELECT * FROM category";
		List<Category> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
				list.add(category);
			}
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<StatisticalCategory> statisticalCategory() {
		Connection cons = Connector.getConnection();
		String sql = "SELECT category.category_name, SUM(product.amount) AS amount "
				+ "FROM category JOIN product "
				+ "ON category.category_id = product.category_id "
				+ "GROUP BY category.category_name ";
		List<StatisticalCategory> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StatisticalCategory statisticalCategory = new StatisticalCategory();
				statisticalCategory.setNameCategory(rs.getString("category_name"));
				statisticalCategory.setValue(rs.getInt("amount"));
				list.add(statisticalCategory);
			}
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
