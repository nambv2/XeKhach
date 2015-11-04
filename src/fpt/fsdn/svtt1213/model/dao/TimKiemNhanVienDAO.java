package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.NhanVien;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class TimKiemNhanVienDAO {
	private ArrayList<NhanVien> timkiemNhanVien = new ArrayList<NhanVien>();

	public ArrayList<NhanVien> timKiemNhanVien(String hoTen) {
		Connection con = BaseDAO.getConnection();
		String sqlUpdate = "{CALL timkiemNhanvien(?,?)}";
		try {
			CallableStatement cas = con.prepareCall(sqlUpdate);
			cas.setString(1,null);
			cas.setString(2, hoTen);
			System.out.println(hoTen);
			ResultSet rs  = cas.executeQuery();
			while(rs.next()){
				NhanVien nhanvien = new NhanVien();
				nhanvien.setMaNhanVien(rs.getString(1));
				nhanvien.setHoTen(rs.getString(2));
				nhanvien.setGioiTinh(rs.getString(3));
				nhanvien.setQueQuan(rs.getString(4));
				nhanvien.setCMND(rs.getString(5));
				nhanvien.setDienThoai(rs.getString(6));
				nhanvien.setViTri(rs.getString(7));
				timkiemNhanVien.add(nhanvien);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return timkiemNhanVien;
	}
}
