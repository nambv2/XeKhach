package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;

import fpt.fsdn.svtt1213.model.bean.DanhSachVeDuocDat;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class DanhsachVeDuocDatDAO {
    Connection con=BaseDAO.getConnection();
	public ArrayList<TuyenDuong> timTuyen() throws SQLException {
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
	public ArrayList<DanhSachVeDuocDat> timVe(String maTuyen,String soCMND) throws SQLException {
		ArrayList<DanhSachVeDuocDat> veDuocdat=new ArrayList<DanhSachVeDuocDat>();
		DanhSachVeDuocDat danhsachVe;
		if("null".equals(maTuyen)) maTuyen="true";
		if("".equals(soCMND))  soCMND="true";
		String sqlTuyen="{call DanhsachVeduocDat(?,?)}";
		try {
			CallableStatement ctml_tuyen=con.prepareCall(sqlTuyen);
			
			ctml_tuyen.setString(1,maTuyen);
			
			ctml_tuyen.setString(2,soCMND);
			ResultSet rq_tuyen= ctml_tuyen.executeQuery();
			
			while(rq_tuyen.next()){
				danhsachVe=new DanhSachVeDuocDat();
				danhsachVe.setMaVe(rq_tuyen.getInt("maVe"));
				danhsachVe.setHoTen(rq_tuyen.getString("hoTen"));
				danhsachVe.setNoiDi(rq_tuyen.getString("noiDi"));
				danhsachVe.setNoiDen(rq_tuyen.getString("noiDen"));
				danhsachVe.setBienSoxe(rq_tuyen.getString("bienSoXe"));
				danhsachVe.setThoiGiandi(rq_tuyen.getDate("thoiGianDi"));
				danhsachVe.setTrangThai(rq_tuyen.getInt("trangThai"));
				veDuocdat.add(danhsachVe);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return veDuocdat;
	}
	

}
