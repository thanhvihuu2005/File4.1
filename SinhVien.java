package HomeWork4_1;

public class SinhVien {
	String maSV;
	String HoTen;
	String GioiTinh;
	double DiemPyThon;
	double DiemJava;
	double DiemTB;
	String ketQua;
	
	public SinhVien(String maSV, String HoTen, String GioiTinh, double DiemPyThon, double DiemJava) {
		this.maSV=maSV;
		this.HoTen=HoTen;
		this.GioiTinh=GioiTinh;
		this.DiemPyThon=DiemPyThon;
		this.DiemJava=DiemJava;
		this.DiemTB=(DiemJava*2 + DiemPyThon)/3;
		 this.ketQua = (DiemTB >= 5) ? "Đậu" : ((DiemTB < 5 && GioiTinh.equals("Nam")) ? "Trượt" : "Đậu");
	}
	
	@Override
	 public String toString() {
	        return String.format("Mã SV: %s - Họ tên: %s - Giới tính: %s - Python: %.2f - Java: %.2f - Điểm TB: %.2f - Kết quả: %s",
	                                maSV, HoTen, GioiTinh, DiemPyThon, DiemJava, DiemTB, ketQua);
	    }
}

