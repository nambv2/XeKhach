package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.QuanLyVe;
import fpt.fsdn.svtt1213.model.dao.QuanLyVeDAO;

public class QuanLyVeBO {
	QuanLyVeDAO quanLyVeDAO =new QuanLyVeDAO();
	public ArrayList<QuanLyVe> getDatabase(String tenDangNhap){
		return quanLyVeDAO.getDatabase(tenDangNhap);
	}
}
