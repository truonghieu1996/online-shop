package dao;

import java.sql.SQLException;
import java.util.List;

import models.Product;
import models.ProductTeam;

public interface IProduct {

	public int Add(int idCategory, String name, double price, String description, String image, int amount) throws SQLException;
	public int Update(int id, int idCategory, String name, double price, String description, String image, int amount) throws SQLException;
	public int UpdateOutFile(int id, int idCategory, String name, double price, String description,
			int amount) throws SQLException;
	public int Delete(int id) throws SQLException;
	public Product getProductById(int id) throws SQLException;
	public Product getProductByIdCategory(int id) throws SQLException;
	public List<ProductTeam> getListProduct() throws SQLException;
}
