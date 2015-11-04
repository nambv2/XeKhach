package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class DanhsachtuyenduongDAO {
	ResultSet rs;
	Statement stm;
	DanhsachtuyenduongDAO dt;
	CallableStatement cstm;
	Connection conn;

	public ArrayList<TuyenDuong> getDatabase() {

		ArrayList<TuyenDuong> data = new ArrayList<TuyenDuong>();
		String query = "select maTuyen,noiDi,noiDen,ngayLap from TuyenDuong";
		conn = BaseDAO.getConnection();
		TuyenDuong tuyenduong;
		try {
			cstm = conn.prepareCall("{call danhsachtuyen}");
			rs = cstm.executeQuery();

			while (rs.next()) {
				tuyenduong = new TuyenDuong();
				tuyenduong.setMaTuyen(rs.getString("maTuyen"));
				tuyenduong.setNoiDi(rs.getString("noiDi"));
				tuyenduong.setNoiDen(rs.getString("noiDen"));
				tuyenduong.setNgayLap(rs.getDate("ngayLap"));
				data.add(tuyenduong);
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
