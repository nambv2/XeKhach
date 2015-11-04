package fpt.fsdn.svtt1213.model.bo;

import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.model.dao.ThongTinTaiKhoanDAO;


public class ThongTinTaiKhoanBO {

	public NguoiDung timThongTin(String tenDangNhap) throws SQLException {
		ThongTinTaiKhoanDAO thongtinTaiKhoan=new ThongTinTaiKhoanDAO();
		//ThongTinTaiKhoanDAO thongtinTaiKhoan=new ThongTinTaiKhoanDAO();
		return thongtinTaiKhoan.timThongTin(tenDangNhap);
		
	}

}
