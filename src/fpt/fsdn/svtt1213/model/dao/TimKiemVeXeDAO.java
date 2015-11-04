package fpt.fsdn.svtt1213.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fpt.fsdn.svtt1213.model.bean.DropdownlistTuyenDuong;
import fpt.fsdn.svtt1213.model.bean.KetQuaTimKiemVeXe;
import fpt.fsdn.svtt1213.model.bean.TimKiemVeXe;
import fpt.fsdn.svtt1213.utility.BaseDAO;

public class TimKiemVeXeDAO {
	public ArrayList<KetQuaTimKiemVeXe> timKiem(TimKiemVeXe timkiemVeXe,String noiDi,String noiDen, String ngayDi) {
		ArrayList<KetQuaTimKiemVeXe> ketquaTimKiem = new ArrayList<KetQuaTimKiemVeXe>();
		Connection con = BaseDAO.getConnection();
		String sql = "{CALL timkiemVexe(?,?,?,?,?,?,?)}";
		
		try {
			CallableStatement cas = con.prepareCall(sql);
			System.out.println(noiDi+"-"+noiDen);
			cas.setString(1, noiDi);
			cas.setString(2, noiDen);
			if(timkiemVeXe.getLoaiVe()!=null){
				cas.setString(3, timkiemVeXe.getLoaiXe());
			}else cas.setString(3, null);
			if(timkiemVeXe.getSoCho()==1)cas.setInt(4, 0);
				else cas.setInt(4, timkiemVeXe.getSoCho());
			
			if("1".equals(timkiemVeXe.getGiaVe())){
				cas.setFloat(5, 0);
				cas.setFloat(6 ,0);
			}else if("2".equals(timkiemVeXe.getGiaVe())){
				cas.setFloat(5, 0);
				cas.setFloat(6 ,200000);
			}else if("3".equals(timkiemVeXe.getGiaVe())){
				cas.setFloat(5, 400000);
				cas.setFloat(6 ,200000);
			}else if("4".equals(timkiemVeXe.getGiaVe())){
				cas.setFloat(5, 600000);
				cas.setFloat(6 ,400000);
			}else{
				cas.setFloat(5, 600000);
				cas.setFloat(6 ,0);
			}
			if("".equals(ngayDi)){
				cas.setString(7, null);
			}else{
				SimpleDateFormat datetime=new SimpleDateFormat("hh:mm MM/dd/yyyy");
				SimpleDateFormat inputdatetime=new SimpleDateFormat("hh:mm dd-MM-yyyy");
				Date date;
				String date1;
				try {
					date  = inputdatetime.parse("00:00 " +ngayDi);
					date1 = datetime.format(date);
					cas.setString(7, date1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ResultSet rs  = cas.executeQuery();
			
			while(rs.next()){
				KetQuaTimKiemVeXe kq = new KetQuaTimKiemVeXe();
				kq.setMaChuyen(rs.getString(1));
				kq.setMaTuyen(rs.getString(2));
				kq.setLoaiXe(rs.getString(3));
				String ngayxuatben = rs.getString(4);
				SimpleDateFormat inputdatetime1 =new SimpleDateFormat("yyyy-MM-dd HH:mm");
				SimpleDateFormat inputdatetime2 =new SimpleDateFormat("HH:mm");
				SimpleDateFormat inputdatetime3 =new SimpleDateFormat("dd-MM-yyyy");
				
				try {
					Date day = inputdatetime1.parse(ngayxuatben);
					kq.setNgayDi(inputdatetime3.format(day));
					kq.setGioDi(inputdatetime2.format(day));					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				kq.setSoCho(rs.getInt(5));
				kq.setSoGheDaDat(rs.getInt(6));
				if(rs.getString(7)==null) {
					kq.setGiaVe("Chưa đặt giá");
					kq.setGiamGia(-1);
				}
				else {
					kq.setGiaVe(String.valueOf(rs.getString(7)));
					float giave = rs.getFloat(7);
					float gia = (float)(giave - (giave*(rs.getFloat(8)/100)));
					kq.setGiamGia(gia);
				}
				
				SimpleDateFormat inputdatetime=new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date date;
				Date date1;
				try {
					date  = inputdatetime.parse(timkiemVeXe.getNgayDi()+" 00:00");
					date1 = inputdatetime.parse(kq.getNgayDi()+" 00:00");
					if(date.compareTo(date1)<=0){
						ketquaTimKiem.add(kq);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		return ketquaTimKiem;
	}
	
	private ArrayList<DropdownlistTuyenDuong> tuyenDuong = new ArrayList<DropdownlistTuyenDuong>();
	public ArrayList<DropdownlistTuyenDuong> getAllTuyenDuong() {
		Connection con = BaseDAO.getConnection();
		String sqlUpdate = "{CALL Dropdown_tuyen()}";
		try {
			CallableStatement cas = con.prepareCall(sqlUpdate);
			ResultSet rs  = cas.executeQuery();
			while(rs.next()){
				DropdownlistTuyenDuong dropdownlistTuyenDuong = new DropdownlistTuyenDuong();
				dropdownlistTuyenDuong.setMaTuyen(rs.getString(1));
				dropdownlistTuyenDuong.setTenTuyen(rs.getString(2));
				tuyenDuong.add(dropdownlistTuyenDuong);
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
		return tuyenDuong;
	}
}
