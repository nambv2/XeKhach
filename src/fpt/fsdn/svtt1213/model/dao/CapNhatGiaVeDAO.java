package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class CapNhatGiaVeDAO {
    TuyenDuong tuyenduong=new TuyenDuong();
    Connection con=BaseDAO.getConnection();
    GiaVe giaVe=new GiaVe();
public TuyenDuong timGiaVe(String maTuyen) throws SQLException {
		
		String timtentuyen="{call timTenTuyen(?)}";
		try {
			CallableStatement tentuyen=con.prepareCall(timtentuyen);
			tentuyen.setString(1,maTuyen);
			
		    ResultSet rq=tentuyen.executeQuery();
			while(rq.next()){
				tuyenduong.setNoiDi(rq.getString("noiDi"));
				tuyenduong.setNoiDen(rq.getString("noiDen"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return tuyenduong;
	}
public boolean capnhatgiaVe(GiaVe giave) throws SQLException {
		String capnhatGiaVe="{call capnhat_giave(?,?,?,?)}";
		try {
		
			CallableStatement ctml_giaVe=con.prepareCall(capnhatGiaVe);
			ctml_giaVe.setString(1,giave.getMaTuyen());
			ctml_giaVe.setString(2,giave.getBienSoXe());
			ctml_giaVe.setFloat(3,giave.getGiaVe());
			ctml_giaVe.setFloat(4, giave.getGiamGiave());
			
			ctml_giaVe.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
public GiaVe kiemtraGiave(String maTuyen, String bienSoXe) throws SQLException {
	String timGiaVe="{call GiaVe_kiemtra(?,?)}";
	
	CallableStatement timgiave=con.prepareCall(timGiaVe);
	timgiave.setString(1, maTuyen);
	timgiave.setString(2, bienSoXe);
	ResultSet rq=timgiave.executeQuery();
	
	while(rq.next()){
		giaVe.setGiaVe(rq.getFloat("giaTien"));
		giaVe.setGiamGiave(rq.getFloat("giamGiaKhuHoi"));
		
	}
	
	return giaVe;
}

}
