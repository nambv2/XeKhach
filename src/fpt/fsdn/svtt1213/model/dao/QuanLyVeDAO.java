package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.QuanLyVe;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class QuanLyVeDAO {
	ResultSet rs;
	Statement stm;
	QuanLyVeDAO dt;
	CallableStatement cstm;
	Connection conn;

	public ArrayList<QuanLyVe> getDatabase(String tenDangNhap) {

		ArrayList<QuanLyVe> data = new ArrayList<QuanLyVe>();
		conn = BaseDAO.getConnection();

		try {
			cstm = conn.prepareCall("{call quanLyVe(?)}");
			cstm.setString(1, tenDangNhap);
			rs = cstm.executeQuery();

			while (rs.next()) {
				QuanLyVe quanLyVe = new QuanLyVe();
				quanLyVe.setMaVe(rs.getInt("maVe"));
				quanLyVe.setNoiDi(rs.getString("noiDi"));
				quanLyVe.setNoiDen(rs.getString("noiDen"));
				quanLyVe.setThoiGianDi(rs.getDate("thoiGianDi"));
				quanLyVe.setTongTien(rs.getInt("tongTien"));
				quanLyVe.setTrangThai(rs.getInt("trangThai"));
				data.add(quanLyVe);
			}

		} catch (Exception e) {
			System.err.println("Khong ket noi duoc bang du lieu");
			e.printStackTrace();
		} finally {
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
