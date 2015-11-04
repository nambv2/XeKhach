package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.QuanLyVe;
import fpt.fsdn.svtt1213.model.dao.HuyVeDAO;

public class HuyVeBO {
	HuyVeDAO huyVeDAO = new HuyVeDAO();
	
	public boolean kTraTrangThai(int maVe){
		return huyVeDAO.kTraTrangThai(maVe);
	}
	
	
	public void huyVe(int maVe){
		huyVeDAO.huyVe(maVe);
	}
}
