package Model;

public class categoryModel {
	private int cateID;
	private String cateName;
	
	public categoryModel() {
		
	}
	
	public categoryModel(int cateID, String cateName) {
		this.cateID = cateID;
		this.cateName = cateName;
	}
	
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
}
