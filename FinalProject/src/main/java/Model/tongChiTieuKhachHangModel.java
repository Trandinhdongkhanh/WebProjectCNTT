package Model;

public class tongChiTieuKhachHangModel {
	 private int accID;
	 private float total;
	public tongChiTieuKhachHangModel(int accID, float total) {
		
		this.accID = accID;
		this.total = total;
	}
	public tongChiTieuKhachHangModel() {
		
	}
	public int getaccID() {
		return accID;
	}
	public void setaccID(int accID) {
		this.accID = accID;
	}
	public float gettotal() {
		return total;
	}
	public void settotalg(float total) {
		this.total = total;
	}

	
}
