package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.DBConnect;

public class invoiceDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void insertInvoice(int accID, int total, Date create_date) {
		String sql = "insert into invoice(accID, total, create_date) values(?, ?, ?)";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			ps.setInt(2, total);
			ps.setDate(3, create_date);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getInvoiceID(int accID) {
		String sql = "select invoiceID from invoice where accID = ? order by invoiceID desc limit 1";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt("invoiceID");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
}
