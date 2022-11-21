package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.categoryModel;
import Util.DBConnect;

public class categoryDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<categoryModel> getAllCategory() {
		{
			List<categoryModel> categories = new ArrayList<>();
			String sql = "SELECT * FROM category";
			try {
				con = new DBConnect().getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					categoryModel category = new categoryModel();
					category.setCateID(rs.getInt("cateID"));
					category.setCateName(rs.getString("cateName"));
					categories.add(category);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return categories;
		}
	}
	public String getCategoryNamebyID(int cateID) {
		String cateName = null;
		String sql = "SELECT cateName FROM category WHERE cateID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cateID);
			rs = ps.executeQuery();
			rs.next();
			cateName = rs.getString("cateName");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cateName;
	}
	
	//Test
	public static void main(String[] args) {
		try {
			String ls;
			ls = new categoryDAO().getCategoryNamebyID(1);
			System.out.println(ls);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
