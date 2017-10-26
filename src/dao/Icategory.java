package dao;

import java.sql.SQLException;
import java.util.List;

import models.Category;

public interface Icategory {
	
	public int Add(String name) throws SQLException;
	
	public int Delete(int id)  throws SQLException;
	
	public int Update(int id, String name) throws SQLException;
	
	public Category getCategoryById(int id) throws SQLException;
	
	public List<Category> getListCategory() throws SQLException;
}
