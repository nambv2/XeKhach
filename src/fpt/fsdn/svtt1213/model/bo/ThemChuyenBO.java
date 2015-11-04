package fpt.fsdn.svtt1213.model.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import fpt.fsdn.svtt1213.model.bean.ChuyenXe;
import fpt.fsdn.svtt1213.model.dao.CapNhatChuyenDAO;
import fpt.fsdn.svtt1213.model.dao.ThemChuyenDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class ThemChuyenBO {
	ThemChuyenDAO themChuyenDAO=new ThemChuyenDAO();
	public ArrayList<String>	hienThiMaNV(int vitri){
		
		return themChuyenDAO.hienThiMaNV(vitri);
		
	}

	public ArrayList<String> hienThiXe() {
		
		return themChuyenDAO.hienThiXe();
	
	}

	
	public boolean themChuyen(ChuyenXe chuyenXe) {
		// TODO Auto-generated method stub
		return themChuyenDAO.themChuyen(chuyenXe);
	
	}
	public ArrayList<String> checkValid(ChuyenXe chuyenXe) {
		// TODO Auto-generated method stub
		ArrayList<String> error = new ArrayList<String>();	
		SimpleDateFormat date = new SimpleDateFormat("HH:mm MM/dd/yyyy");
		Date now = new Date();
		String nowString =  date.format(now);
			
		String thoiGianDi = chuyenXe.getThoiGianDi();
		String thoiGianDen = chuyenXe.getThoiGianDen();
		
		if(!Security.validateId(chuyenXe.getMaChuyen())){
			error.add("MaChuyen");
		}
		
		
		if(chuyenXe.getMaTaixe1().equals(chuyenXe.getMaTaixe2())){
			error.add("TrungMa");
		}
		
		if(checkMaChuyen(chuyenXe.getMaChuyen())){
			error.add("MaTonTai");
		}
		
		if(! checkTaiXe(chuyenXe.getMaTaixe1(), thoiGianDi, thoiGianDen)) {
			error.add("TaiXe1");
		}
		if(! checkTaiXe(chuyenXe.getMaTaixe2(), thoiGianDi, thoiGianDen)){
			error.add("TaiXe2");
		}
		if(! checkTaiXe(chuyenXe.getMaPhuXe(), thoiGianDi, thoiGianDen)){
			error.add("PhuXe");
		}
		if(! checkXe(chuyenXe.getBienSoXe(), thoiGianDi, thoiGianDen )){
			error.add("Xe");
		}
		if(Security.validateTiLe(chuyenXe.getTiLeDatVeOnline()) == false){
			error.add("TiLe");
		}
		if(Security.validateTiLe(chuyenXe.getTiLeDatVeOnline()) == true){
			if(Integer.parseInt(chuyenXe.getTiLeDatVeOnline())	>100 ){
				error.add("TiLe");
			}}
		
		try {
			
			Date dateNow = date.parse(nowString);
			
			Date dateThoiGianDi = date.parse(thoiGianDi);
			Date dateThoiGianDen = date.parse(thoiGianDen);
									
			if(dateNow.compareTo(dateThoiGianDi) >= 0){
				error.add("LoiNgayDi");
			}
			
			if(dateNow.compareTo(dateThoiGianDen) >= 0){
				error.add("LoiNgayDen");
				}
			
			if(dateThoiGianDen.compareTo(dateThoiGianDi) <= 0){
				error.add("DiDen");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		Date dateDi, dateVe;
		
		try {
			dateDi = date.parse(chuyenXe.getThoiGianDi());
			dateVe = date.parse(chuyenXe.getThoiGianDen());

			
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateDi);
			cal.add(Calendar.HOUR, 2);
			
			if(dateVe.compareTo(cal.getTime()) <=0) {
				error.add("LoiTG");
			}
				
			
	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		
		return error;
	}
	
	public boolean checkXe(String bienSoXe, String thoiGianDi, String thoiGianDen) {
		
		return themChuyenDAO.checkXe(bienSoXe,thoiGianDi, thoiGianDen);
	}

	public boolean checkTaiXe(String maTaiXe, String thoiGianDi, String thoiGianDen){	
				
		return themChuyenDAO.checkTaiXe(maTaiXe,thoiGianDi, thoiGianDen);
	}
	
	public boolean checkMaChuyen(String maChuyen){
		return themChuyenDAO.checkMaChuyen(maChuyen);
		
	}
	
	
	

}
