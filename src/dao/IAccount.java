package dao;

import java.sql.SQLException;
import java.util.List;

import models.Account;

public interface IAccount {
	public int Add(String displayname, String username, String password) throws SQLException;

	public int Delete(String username) throws SQLException;

	public int UpdatePasswordByUsername(String username, String password) throws SQLException;
	
	public Account getAccountByUsername(String username) throws SQLException;
	
	public Account getAccountByPassword(String password) throws SQLException;

	public List<Account> getListAccount() throws SQLException;
	
	public String getEncryption(String password) throws SQLException;
}
