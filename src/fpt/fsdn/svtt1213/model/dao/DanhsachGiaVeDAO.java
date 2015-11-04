package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class DanhsachGiaVeDAO {
	Connection con=BaseDAO.getConnection();
	
	public ArrayList<TuyenDuong> tuyenduong() throws SQLException {
		TuyenDuong tuyenduong;
		ArrayList<TuyenDuong> arrTuyen = new ArrayList<TuyenDuong>();
		String sqlTuyen="{call danhsachtuyen()}";
		try {
			CallableStatement ctml_tuyen=con.prepareCall(sqlTuyen);
			
			ResultSet rq_tuyen=ctml_tuyen.executeQuery();
			
			while(rq_tuyen.next()){
				tuyenduong= new TuyenDuong();
				tuyenduong.setMaTuyen(rq_tuyen.getString("maTuyen"));
				tuyenduong.setNoiDi(rq_tuyen.getString("noiDi"));
				tuyenduong.setNoiDen(rq_tuyen.getString("noiDen"));
				arrTuyen.add(tuyenduong);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return arrTuyen;
	}

	public ArrayList<GiaVe> timGiaVe(String maTuyen) throws SQLException {
		ArrayList<GiaVe> arrGiaVe = new ArrayList<GiaVe>();
		GiaVe giaVe;
		String sqlTuyen="{call tim_giave(?)}";
		try {
			CallableStatement ctml_giaVe=con.prepareCall(sqlTuyen);
			ctml_giaVe.setString(1,maTuyen);
			
			ResultSet rq=ctml_giaVe.executeQuery();
			while(rq.next()){
				giaVe =new GiaVe();
				giaVe.setMaTuyen(rq.getString("maTuyen"));
				giaVe.setBienSoXe(rq.getString("bienSoXe"));
				giaVe.setGiaVe(rq.getFloat("giaTien"));
				giaVe.setGiamGiave(rq.getFloat("giamGiaKhuHoi"));
				arrGiaVe.add(giaVe);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			con.close();
		}
		return arrGiaVe;
	}

}
