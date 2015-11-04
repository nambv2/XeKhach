package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThongTinTaiKhoanDAO {
	 Connection con=BaseDAO.getConnection();
     NguoiDung nguoidung=new NguoiDung();
	public NguoiDung timThongTin(String tenDangNhap) throws SQLException {
		String timtentuyen="{call layThongtinNguoiDung(?)}";
		try {
			CallableStatement tentuyen=con.prepareCall(timtentuyen);
			tentuyen.setString(1,tenDangNhap);
			
		    ResultSet rq=tentuyen.executeQuery();
			while(rq.next()){
				nguoidung.setHoTen(rq.getString("hoTen"));
				nguoidung.setGioiTinh(rq.getInt("gioiTinh"));
				nguoidung.setSoCMND(rq.getString("CMND"));
				nguoidung.setSoDienThoai(rq.getString("soDienThoai"));
				nguoidung.setQueQuan(rq.getString("queQuan"));
				nguoidung.setTenDangNhap(rq.getString("tenDangNhap"));
				nguoidung.setMatKhau(rq.getString("matKhau"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			con.close();
		}
		return nguoidung;
	}

}
