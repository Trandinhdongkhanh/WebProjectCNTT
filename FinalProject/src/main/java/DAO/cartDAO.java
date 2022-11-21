package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.cartModel;
import Util.DBConnect;

public class cartDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<cartModel> getAllitemsInCart(int accID) {
		String sql = "SELECT cartID, accID, productID, sum(ammount) as totalAmmount, size FROM cart WHERE accID = ? group by productID;";
		List<cartModel> ca = new ArrayList<>();
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			rs = ps.executeQuery();
			while (rs.next()) {
				cartModel i = new cartModel();
				i.setCartID(rs.getInt("cartID"));
				i.setAccID(rs.getInt("accID"));
				i.setProductID(rs.getInt("productID"));
				i.setAmmount(rs.getInt("totalAmmount"));
				i.setSize(rs.getString("size"));
				ca.add(i);
			}
			return ca;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void editAmmountCart(int productID, int accID, int ammount) {
		String sql = "UPDATE cart SET ammount = ? WHERE productID = ? AND accID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ammount);
			ps.setInt(2, productID);
			ps.setInt(3, accID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllinCart(int accID) {
		String sql = "DELETE FROM cart WHERE accID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public cartModel checkExistCart(int accID, int productID) {
		String sql = "SELECT * FROM cart WHERE accID = ? AND productID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			ps.setInt(2, productID);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new cartModel(
						rs.getInt("cartID"),
						rs.getInt("accID"),
						rs.getInt("productID"),
						rs.getInt("ammount"),
						rs.getString("size")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertCart(int accID, int productID, int ammount, String size) {
		String sql = "insert into cart (accID, productID, ammount, size) values(?, ?, ?, ?)";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			ps.setInt(2, productID);
			ps.setInt(3, ammount);
			ps.setString(4, size);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProductCart(int accID, int productID) {
		String sql = "delete from cart where accID = ? and productID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			ps.setInt(2, productID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int number_of_items_inCart(int accID) {
		String sql = "select count(productID) as number_of_items_inCart from cart where accID = ?";
		int nb = 0;
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			rs = ps.executeQuery();
			while(rs.next()) {
				nb = rs.getInt("number_of_items_inCart");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nb;
	}
}
