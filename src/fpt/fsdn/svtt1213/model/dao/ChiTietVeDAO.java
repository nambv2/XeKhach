package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.QuanLyVe;
import fpt.fsdn.svtt1213.utility.BaseDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class ChiTietVeDAO {
	ResultSet rs;
	Statement stm;
	ChiTietVeDAO dt;
	Connection conn;
	CallableStatement cstm;
	BaseDAO ketnoi = new BaseDAO();

	public ArrayList<QuanLyVe> traDuLieu(int maVe) {

		ArrayList<QuanLyVe> data = new ArrayList<QuanLyVe>();
		conn = BaseDAO.getConnection();
		try {
			cstm = conn.prepareCall("{call chitietve(?)}");
			cstm.setInt(1, maVe);
			rs = cstm.executeQuery();

			while (rs.next()) {
				QuanLyVe quanLyVe = new QuanLyVe();
				quanLyVe.setNoiDi(rs.getString("noiDi"));
				quanLyVe.setNoiDen(rs.getString("noiDen"));
				quanLyVe.setThoiGianDi(rs.getDate("thoiGianDi"));
				quanLyVe.setLoaiXe(rs.getString("loaiXe"));
				quanLyVe.setViTriNgoi(rs.getInt("viTriNgoi"));
				quanLyVe.setTongTien(rs.getInt("tongTien"));
				quanLyVe.setNgayDatVe(rs.getInt("ngayDatVe"));
				quanLyVe.setThangDatVe(rs.getString("thangDatVe"));
				quanLyVe.setNamDatVe(rs.getInt("namDatVe"));
				quanLyVe.setNgayDi(rs.getInt("ngayDi"));
				quanLyVe.setThangDi(rs.getString("thangDi"));
				quanLyVe.setNamDi(rs.getInt("namDi"));

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
	public boolean kiemTraMaVe(int maVe){
		conn = BaseDAO.getConnection();
		ResultSet rs;
		String sql = "{call kiemTraMaVe(?)}";
		try {
			cstm = conn.prepareCall(sql);
			cstm.setInt(1, maVe);
			rs = cstm.executeQuery();
			while(rs.next()){
				if(rs.getInt("dem")==1){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				cstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
}
