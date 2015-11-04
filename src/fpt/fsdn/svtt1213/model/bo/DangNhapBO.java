package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.model.dao.DangNhapDAO;

public class DangNhapBO {
	public boolean kiemTraDangNhap(String tenDangNhap,String matKhau){
		return new DangNhapDAO().kiemTraDangNhap(tenDangNhap,matKhau);
	}
	
	public NguoiDung getNguoiDung(String tenDangNhap){
		return new DangNhapDAO().getNguoiDung(tenDangNhap);
	}
}
