package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.DanhSachVeDuocDat;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class ChiTietVeAdminDAO {
	Connection con=BaseDAO.getConnection();
	public DanhSachVeDuocDat timVe(String maVe) throws SQLException {
		DanhSachVeDuocDat veDuocdat=new DanhSachVeDuocDat();
		
		
		String sqlTuyen="{call timDanhSachVe(?)}";
		try {
			CallableStatement ctml_tuyen=con.prepareCall(sqlTuyen);
			
			ctml_tuyen.setInt(1,Integer.parseInt(maVe));
			
			ResultSet rq_tuyen= ctml_tuyen.executeQuery();
		
			while(rq_tuyen.next()){
				
				veDuocdat.setMaVe(rq_tuyen.getInt("maVe"));
				veDuocdat.setGiaTien(rq_tuyen.getFloat("giaTien"));
				veDuocdat.setCMND(rq_tuyen.getString("CMND"));
				veDuocdat.setSoDT(rq_tuyen.getString("soDienThoai"));
				veDuocdat.setNoiDi(rq_tuyen.getString("noiDi"));
				veDuocdat.setNoiDen(rq_tuyen.getString("noiDen"));
				veDuocdat.setThoiGiandi(rq_tuyen.getDate("thoiGianDi"));
				veDuocdat.setVitriNgoi(rq_tuyen.getInt("viTriNgoi"));
				veDuocdat.setTrangThai(rq_tuyen.getInt("trangThai"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return veDuocdat;
	}

	public boolean kiemtraVe(String maVe) {
		 boolean ktraVe=false;
		String sqlTuyen="{call timDanhSachVe(?)}";
		try {
			CallableStatement ctml_tuyen=con.prepareCall(sqlTuyen);
			
			ctml_tuyen.setInt(1,Integer.parseInt(maVe));
			
			ResultSet rq_tuyen= ctml_tuyen.executeQuery();
		if(rq_tuyen.next()){
			while(rq_tuyen.next()){
				ktraVe=true;
			}
		}
		else ktraVe=false;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ktraVe;
	}
}
