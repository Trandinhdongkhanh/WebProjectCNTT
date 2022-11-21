package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.DBConnect;

public class invoiceDetailDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void insert_invoiceDetail(int invoiceID, int productID, int ammount){
		String sql = "insert into invoicedetail(invoiceID, productID, ammount) values(?, ?, ?)";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, invoiceID);
			ps.setInt(2, productID);
			ps.setInt(3, ammount);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
