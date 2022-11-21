package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.DBConnect;

public class SoLuongDaBanDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void updateSLdaban(int productID, int ammount) {
		String sql = "update SoLuongDaBan set sold = sold + ? where productID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ammount);
			ps.setInt(2, productID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
