package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.DanhsachtuyenduongDAO;

public class DanhsachtuyenduongBO {
	DanhsachtuyenduongDAO danhsachtuyenduongDAO =new DanhsachtuyenduongDAO();
	public ArrayList<TuyenDuong> getDatabase(){
		return danhsachtuyenduongDAO.getDatabase();
	}
}
