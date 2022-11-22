package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.accountModel;
import Util.DBConnect;

public class accountDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<accountModel> getAllAccount() {
        List<accountModel> list = new ArrayList<>();
        String query = "select * from account";
        try {
            con = new DBConnect().getConnection();//mo ket noi voi sql
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new accountModel(
                		rs.getInt("accID"),
						rs.getString("userName"),
						rs.getString("pass"),
						rs.getInt("isSell"),
						rs.getInt("isAdmin"),
						rs.getString("email")
						));
            }
        } catch (Exception e) {
        }
        return list;
    }
	public accountModel getAccountByID(int accID) {
		accountModel acc = new accountModel();
		String sql = "SELECT * FROM account WHERE accID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
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
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
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
	public void editAccount(int accID, String userName, String pass, int isAdmin, String email) {
		String sql = "update account set userName = ?, pass = ?, isAdmin=? , email = ? where accID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, pass);
			ps.setInt(3, isAdmin);
			ps.setString(4, email);
			ps.setInt(5, accID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void insertAccount(String userName, String pass, int isSell, int isAdmin, String email) {
		String sql = "INSERT INTO account (userName, pass, isSell, isAdmin, email) VALUES(?, ?, ?, ?, ?)";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, pass);
			ps.setInt(3, isSell);
			ps.setInt(4, isAdmin);
			ps.setString(5, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteCartByAccountID(int accID) {
        String query = "delete from cart \r\n"
        		+ "where [accID]=?";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void deleteInvoiceByAccountId(int accID) {
        String query = "delete from invoice\n"
                + "where [accID] = ?";
        try {
            con = new DBConnect().getConnection();//mo ket noi voi sql
            ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void deleteInvoiceDetailByAccountId(int accID) {
        String query = "delete from invoiceDetail\n"
                + "where [accID] = ?";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void deleteReviewByAccountID(int accID) {
        String query = "delete from review where [accID] = ?";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void deleteTotalSpendingByAccID(int accID) {
        String query = "delete from totalSpending\n"
                + "where [accID] = ?";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	 public void deleteAccount(int accID) {
	        String query = "delete from account where accID= ?";
	        try {
	            con = new DBConnect().getConnection();
	            ps = con.prepareStatement(query);
	            ps.setInt(1, accID);
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	    }
	 public int numberOfAccount() {
	        String query = "select count(accID) from account";
	        try {
	            con = new DBConnect().getConnection();
	            ps = con.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	            	return rs.getInt(1);
	            }
	        } catch (Exception e) {
	        }
	        return 0;
	    }
}
