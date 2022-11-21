package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.accountModel;
import Util.DBConnect;

public class accountDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public accountModel login(String userName, String pass) {
		accountModel acc = new accountModel();
		String sql = "SELECT * FROM account WHERE userName = ? AND pass = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				acc.setAccID(rs.getInt("accID"));
				acc.setUserName(rs.getString("userName"));
				acc.setPass(rs.getString("pass"));
				acc.setIsSell(rs.getInt("isSell"));
				acc.setIsAdmin(rs.getInt("isAdmin"));
				acc.setEmail(rs.getString("email"));
				return acc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void sign_up(String userName, String pass, String email) {
		String sql = "INSERT INTO account (userName, pass, isSell, isAdmin, email) VALUES(?, ?, ?, ?, ?)";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, pass);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setString(5, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public accountModel checkAccountExist(String userName) {
		String sql = "SELECT * FROM account WHERE userName = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new accountModel(
						rs.getInt("accID"),
						rs.getString("userName"),
						rs.getString("pass"),
						rs.getInt("isSell"),
						rs.getInt("isAdmin"),
						rs.getString("email")
						);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public accountModel checkEmailExist(String email) {
		String sql = "SELECT * FROM account WHERE email = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new accountModel(
						rs.getInt("accID"),
						rs.getString("userName"),
						rs.getString("pass"),
						rs.getInt("isSell"),
						rs.getInt("isAdmin"),
						rs.getString("email")
						);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void resetPassword(String userName) {
		String sql = "update account set pass = 123456 where userName = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateProfile(String userName, String pass, String email, int accID) {
		String sql = "update account set userName = ?, pass = ?, email = ? where accID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setInt(4, accID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
