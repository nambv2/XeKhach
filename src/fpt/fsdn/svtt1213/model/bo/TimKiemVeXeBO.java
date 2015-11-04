package fpt.fsdn.svtt1213.model.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fpt.fsdn.svtt1213.model.bean.DropdownlistTuyenDuong;
import fpt.fsdn.svtt1213.model.bean.KetQuaTimKiemVeXe;
import fpt.fsdn.svtt1213.model.bean.TimKiemVeXe;
import fpt.fsdn.svtt1213.model.dao.TimKiemVeXeDAO;

public class TimKiemVeXeBO {
	TimKiemVeXeDAO timKiemVeXeDAO = new TimKiemVeXeDAO();
	public ArrayList<KetQuaTimKiemVeXe> timKiem(TimKiemVeXe timkiemVeXe,String noiDi, String noiDen,String ngayDi) {
		// TODO Auto-generated method stub
		return timKiemVeXeDAO.timKiem(timkiemVeXe,noiDi,noiDen,ngayDi);
	}
	
	public ArrayList<DropdownlistTuyenDuong> getAllTuyenDuong() {		
		return timKiemVeXeDAO.getAllTuyenDuong();
	}

	public String getCurrentDate() {
		String currentDate="";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		currentDate = dateFormat.format(date);
		return currentDate;
	}

	public int isValidateNgayVe(String ngayDi, String ngayVe) {
	
		SimpleDateFormat inputdatetime=new SimpleDateFormat("hh:mm dd-MM-yyyy");
		Date dateDi = null;
		Date dateVe = null;
		try {
			dateDi  = inputdatetime.parse("00:00 " +ngayDi);
			dateVe  = inputdatetime.parse("00:00 " +ngayVe);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateDi.compareTo(dateVe);
	}

}
