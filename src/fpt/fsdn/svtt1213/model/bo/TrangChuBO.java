package fpt.fsdn.svtt1213.model.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fpt.fsdn.svtt1213.model.bean.DropdownlistTuyenDuong;
import fpt.fsdn.svtt1213.model.dao.TrangChuDAO;

public class TrangChuBO {
	TrangChuDAO trangChuDAO  = new TrangChuDAO();
	public ArrayList<DropdownlistTuyenDuong> getAllTuyenDuong() {		
		return trangChuDAO.getAllTuyenDuong();
	}
	public String getCurrentDate() throws ParseException {
		String currentDate="";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		currentDate = dateFormat.format(date);
		return currentDate;
	}

}
