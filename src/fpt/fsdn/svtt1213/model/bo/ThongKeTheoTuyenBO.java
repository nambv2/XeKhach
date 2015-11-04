package fpt.fsdn.svtt1213.model.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.ThongKeTheoTuyenDAO;

public class ThongKeTheoTuyenBO {
	public ArrayList<TuyenDuong> getAllTuyen(){
		return new ThongKeTheoTuyenDAO().getAllTuyen();
	}
	
	/**
	Lấy tỉ lệ vé đã đặt, nếu không nhập khoảng thời gian thì hiện tất cả
	*/
	public float tiLe(String maTuyen,String thoiGianTu,String thoiGianDen){
		SimpleDateFormat dateOut =  new SimpleDateFormat("HH:mm MM/dd/yyyy");
		SimpleDateFormat dateIn = new SimpleDateFormat("dd-MM-yyyy");
		
		Date date1, date2;
		try {
			date1 = dateIn.parse(thoiGianTu+" 00:00");
			date2 = dateIn.parse(thoiGianDen+" 00:00");
			
			String outTu = dateOut.format(date1);
			String outDen = dateOut.format(date2);
			return new ThongKeTheoTuyenDAO().tiLe(maTuyen, outTu, outDen);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
}
