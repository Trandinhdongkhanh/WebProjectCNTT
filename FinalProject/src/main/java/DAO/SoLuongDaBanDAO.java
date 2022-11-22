package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.accountModel;
import Model.SoLuongDaBanModel;
import Util.DBConnect;

public class SoLuongDaBanDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void updateSLdaban(int productID, int ammount) {
		String sql = "update soLuongDaBan set sold = sold + ? where productID = ?";
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
	public List<SoLuongDaBanModel> getAllProductIDSoLuongDaBan() {
        List<SoLuongDaBanModel> list = new ArrayList<>();
        String query = "select * from soLuongDaBan";
        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SoLuongDaBanModel(
                		rs.getInt("productID"),						
						rs.getInt("sold")
						));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
