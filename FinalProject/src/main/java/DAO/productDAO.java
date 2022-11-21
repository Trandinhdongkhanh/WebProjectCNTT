package DAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Product_Cart_Model;
import Model.cartModel;
import Model.productModel;
import Util.DBConnect;

public class productDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<productModel> getAllProduct() {
		List<productModel> products = new ArrayList<>();
		String sql = "SELECT * FROM product";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return products;
	}

	public List<productModel> getProductByCateID(int cateID) {
		List<productModel> products = new ArrayList<>();
		String sql = "SELECT * FROM product WHERE cateID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cateID);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return products;
	}

	public productModel getProductByID(int productID) {
		productModel product = new productModel();
		String sql = "SELECT * from product WHERE productID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			rs.next();
			product.setProductID(rs.getInt("productID"));
			product.setProductName(rs.getString("productName"));
			product.setCateID(rs.getInt("cateID"));
			product.setPrice(rs.getInt("price"));
			product.setDescription(rs.getString("description"));
			product.setImage(rs.getString("image"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return product;
	}

	public List<productModel> getProductByName(String productName) {
		List<productModel> products = new ArrayList<>();
		String sql = "SELECT * FROM product WHERE productName LIKE ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return products;
	}

	public List<productModel> getLastestProduct() {
		List<productModel> products = new ArrayList<>();
		String sql = "SELECT * FROM product ORDER BY productID DESC LIMIT 5";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return products;
	}

	public List<productModel> getRelatedProducts(int cateID) {
		String sql = "select * from product where cateID = ?";
		List<productModel> products = new ArrayList<>();
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cateID);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel(rs.getInt("productID"), rs.getString("productName"),
						rs.getInt("price"), rs.getInt("cateID"), rs.getString("description"), rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<productModel> pagingProductByID_desc(int index) {
		String sql = "select * from product order by productID desc limit 6 offset ?";
		List<productModel> products = new ArrayList<>();
		int nb_in_one_page = 6; // replace this if you would like to display more product in 1 page
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (index - 1) * nb_in_one_page);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<productModel> pagingProduct(int index) {
		String sql = "select * from product order by productID limit 6 offset ?";
		List<productModel> products = new ArrayList<>();
		int nb_in_one_page = 6; // replace this if you would like to display more product in 1 page
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (index - 1) * nb_in_one_page);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<productModel> pagingProductByCateID(int cateID, int index) {
		String sql = "select * from product where cateID = ? order by productID limit 6 offset ?";
		List<productModel> products = new ArrayList<>();
		int nb_in_one_page = 6; // replace this if you would like to display more product in 1 page
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cateID);
			ps.setInt(2, (index - 1) * nb_in_one_page);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getNumberofProduct() {
		String sql = "select count(*) as nb from product";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("nb");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getNumberofProductByCateID(int cateID) {
		String sql = "select count(*) as nb from product where cateID = ?";
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cateID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("nb");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Product_Cart_Model> getProductInCart(int accID) {
		String sql = "select cart.productID, productName, price, ammount from cart inner join product on cart.productID = product.productID where accID = ?";
		List<Product_Cart_Model> list = new ArrayList<>();
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product_Cart_Model(rs.getInt("productID") ,rs.getString("productName"), rs.getInt("price"), rs.getInt("ammount")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<productModel> getProductUnder200() {
		String sql = "select * from product where price < 200";
		List<productModel> products = new ArrayList<>();
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<productModel> getProduct200to300() {
		String sql = "select * from product where price between 200 and 300";
		List<productModel> products = new ArrayList<>();
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<productModel> getProductAbove300() {
		String sql = "select * from product where price > 300";
		List<productModel> products = new ArrayList<>();
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<productModel> getProductFromMinToMax(int min, int max){
		String sql = "select * from product where price between ? and ?";
		List<productModel> products = new ArrayList<>();
		try {
			con = new DBConnect().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, min);
			ps.setInt(2, max);
			rs = ps.executeQuery();
			while (rs.next()) {
				productModel product = new productModel();
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setCateID(rs.getInt("cateID"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// Test
//	public static void main(String[] args) {
//		try {
//			List<productModel> ls = new ArrayList<>();
//			ls = new productDAO().getRelatedProducts(1);
//			for (productModel o : ls) {
//				System.out.println(o.getImage());
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
