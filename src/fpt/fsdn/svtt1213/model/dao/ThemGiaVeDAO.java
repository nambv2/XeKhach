package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ThemGiaVeDAO {
	Connection con=BaseDAO.getConnection();
	public ArrayList<TuyenDuong> tuyenDuong() throws SQLException {
		
		ArrayList<TuyenDuong> arrTuyen = new ArrayList<TuyenDuong>();
		TuyenDuong tuyenduong;
		String sqlTuyen="{call danhsachtuyen()}";
		String sqlXe="{call Xe_Danhsach()}";
		try {
			CallableStatement ctml_tuyen=con.prepareCall(sqlTuyen);
			CallableStatement ctml_xe=con.prepareCall(sqlXe);
			ResultSet rq_tuyen=ctml_tuyen.executeQuery();
			ResultSet rq_xe=ctml_xe.executeQuery();
			while(rq_tuyen.next()&&rq_xe.next()){
				tuyenduong= new TuyenDuong();
				tuyenduong.setMaTuyen(rq_tuyen.getString("maTuyen"));
				tuyenduong.setNoiDen(rq_tuyen.getString("noiDen"));
				tuyenduong.setNoiDi(rq_tuyen.getString("noiDi"));
				tuyenduong.setBienSoXe(rq_xe.getString("bienSoXe"));
				arrTuyen.add(tuyenduong);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			con.close();
		}
		return arrTuyen;
	}

	public int themGiaVe(GiaVe giaVe) {
		int  ktraVe=0;
		String sqlGiave="{call them_giave(?,?,?,?)}";
		try { 
			
			CallableStatement ctml_giaVe=con.prepareCall(sqlGiave);
			
			ctml_giaVe.setString(1,giaVe.getMaTuyen());
			ctml_giaVe.setString(2, giaVe.getBienSoXe());
			ctml_giaVe.setFloat(3,giaVe.getGiaVe());
			ctml_giaVe.setFloat(4,giaVe.getGiamGiave());
			ktraVe=ctml_giaVe.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ktraVe;
	}
	
	

}
