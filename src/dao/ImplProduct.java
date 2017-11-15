package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Connector;
import models.Product;
import models.ProductTeam;

public class ImplProduct implements IProduct {

	@Override
	public int Add(int idCategory, String name, double price, String description, String image, int amount)
			throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "INSERT INTO product(product_name, product_price, product_description, product_image, category_id, amount)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setDouble(2, price);
		ps.setString(3, description);
		ps.setString(4, image);
		ps.setInt(5, idCategory);
		ps.setInt(6, amount);
		return ps.executeUpdate();
	}

	@Override
	public int Update(int id, int idCategory, String name, double price, String description, String image,
			int amount) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "UPDATE product "
				+ "SET product_name = ?, product_price = ?, product_description = ?, product_image = ?, category_id = ?, amount = ? "
				+ "WHERE product_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setDouble(2, price);
		ps.setString(3, description);
		ps.setString(4, image);
		ps.setInt(5, idCategory);
		ps.setInt(6, amount);
		ps.setInt(7, id);
		return ps.executeUpdate();
	}
	@Override
	public int UpdateOutFile(int id, int idCategory, String name, double price, String description,
			int amount) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "UPDATE product "
				+ "SET product_name = ?, product_price = ?, product_description = ?, category_id = ?, amount = ? "
				+ "WHERE product_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setDouble(2, price);
		ps.setString(3, description);
		ps.setInt(4, idCategory);
		ps.setInt(5, amount);
		ps.setInt(6, id);
		return ps.executeUpdate();
	}

	@Override
	public int Delete(int id) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "DELETE FROM product WHERE product_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

	@Override
	public Product getProductById(int id) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "SELECT * FROM product WHERE product_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		Product product = new Product();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getDouble("product_price"));
			product.setDescription(rs.getString("product_description"));
			product.setImage(rs.getString("product_image"));
			product.setIdCategory(rs.getInt("category_id"));
			product.setAmount(rs.getInt("amount"));
		}
		return product;
	}

	@Override
	public List<ProductTeam> getListProduct() throws SQLException {
		Connection cons = Connector.getConnection();
		String sql = "SELECT p.product_id, p.product_name, p.product_price, p.product_description, p.product_image, c.category_name, p.amount "
				+ "FROM product p "
				+ "INNER JOIN category c ON p.category_id = c.category_id;";
		List<ProductTeam> list = new ArrayList<>();
		PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductTeam product = new ProductTeam();
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getDouble("product_price"));
			product.setDescription(rs.getString("product_description"));
			product.setImage(rs.getString("product_image"));
			product.setNameCategory(rs.getString("category_name"));
			product.setAmount(rs.getInt("amount"));
			list.add(product);
		}
		return list;
	}

	@Override
	public Product getProductByIdCategory(int id) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "SELECT * FROM product WHERE category_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Product product = new Product();
		while (rs.next()) {
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getDouble("product_price"));
			product.setDescription(rs.getString("product_description"));
			product.setImage(rs.getString("product_image"));
			product.setIdCategory(rs.getInt("category_id"));
			product.setAmount(rs.getInt("amount"));
		}
		return product;
	}

	@Override
	public List<Product> getListProductByIdCategory(int id) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "SELECT * FROM product WHERE category_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		List<Product> list = new ArrayList<>();
		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getDouble("product_price"));
			product.setDescription(rs.getString("product_description"));
			product.setImage(rs.getString("product_image"));
			product.setIdCategory(rs.getInt("category_id"));
			product.setAmount(rs.getInt("amount"));
			list.add(product);
		}
		return list;
	}

	@Override
	public int updateAmount(Connection conn, int amount, int id) throws SQLException {
		String sql = "UPDATE product SET amount = ? WHERE product_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, amount);
		ps.setInt(2, id);
		return ps.executeUpdate();
	}

}
