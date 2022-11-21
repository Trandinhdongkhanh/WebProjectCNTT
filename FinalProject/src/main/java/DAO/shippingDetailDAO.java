package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.DBConnect;

public class shippingDetailDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void insert_shippingDetail(int invoiceID, String city, String firstName, String lastName, String address,
			String state, String zip, String email, String phone) {
		String sql = "insert into shippingdetail(invoiceID, city, firstName, lastName, address, state, zip, email, phone) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, invoiceID);
			ps.setString(2, city);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, address);
			ps.setString(6, state);
			ps.setString(7, zip);
			ps.setString(8, email);
			ps.setString(9, phone);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
