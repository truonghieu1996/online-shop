package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Connector;

public class ImplAccount implements IAccount {

	@Override
	public int Add(String displayname, String username, String password) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "INSERT INTO account(username, password, displayname) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, displayname);
		return ps.executeUpdate();
	}

	@Override
	public int Delete(String username) throws SQLException {
		Connection conn = Connector.getConnection();
		String sql ="DELETE FROM account WHERE username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		return ps.executeUpdate();
	}

	@Override
	public int UpdatePasswordByUsername(String username, String password) throws SQLException{
		Connection conn = Connector.getConnection();
		String sql = "UPDATE account SET password = ? WHERE username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, username);
		return ps.executeUpdate();
	}

	@Override
	public Account getAccountByUsername(String username) throws SQLException{
		Connection conn = Connector.getConnection();
		Account account = new Account();
		String sql = "SELECT * FROM `account` WHERE username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			account.setDisplayname(rs.getString("displayname"));
			account.setUsername(rs.getString("username"));
			account.setPassword(rs.getString("password"));
			account.setRole(rs.getInt("role"));
		}
		return account;
	}

	@Override
	public List<Account> getListAccount() throws SQLException {
		Connection conn = Connector.getConnection();
		String sql = "SELECT * FROM account";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Account> list = new ArrayList<>();
		while (rs.next()) {
			Account account = new Account();
			account.setDisplayname(rs.getString("displayname"));
			account.setUsername(rs.getString("username"));
			account.setPassword(rs.getString("password"));
			account.setRole(rs.getInt("role"));
			list.add(account);
		}
		return list;
	}

	@Override
	public String getEncryption(String password) {
		byte[] defaultBytes = password.getBytes();
		   try {
		       MessageDigest algorithm = MessageDigest.getInstance("MD5");
		       algorithm.reset();
		       algorithm.update(defaultBytes);
		       byte messageDigest[] = algorithm.digest();
		       StringBuffer hexString = new StringBuffer();
		       for (int i = 0; i < messageDigest.length; i++) {
		          String hex = Integer.toHexString(0xFF & messageDigest[i]);
		          if (hex.length() == 1) {
		              hexString.append('0');
		          }
		          hexString.append(hex);
		      }
		       password = hexString + "";
		   } catch (NoSuchAlgorithmException e) {
		      e.printStackTrace();
		   }
		   return password;
	}

	@Override
	public Account getAccountByPassword(String password) throws SQLException {
		Connection conn = Connector.getConnection();
		Account account = new Account();
		String sql = "SELECT * FROM account WHERE password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			account.setDisplayname(rs.getString("displayname"));
			account.setUsername(rs.getString("username"));
			account.setPassword(rs.getString("password"));
			account.setRole(rs.getInt("role"));
		}
		return account;
	}
}
