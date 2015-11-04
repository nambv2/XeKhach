package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.QuanLyVe;
import fpt.fsdn.svtt1213.model.dao.ChiTietVeDAO;

public class ChiTietVeBO {
	ChiTietVeDAO chiTietVeDAO = new ChiTietVeDAO();

	public ArrayList<QuanLyVe> traDuLieu(int maVe) {
		return chiTietVeDAO.traDuLieu(maVe);
	}
	public boolean kiemTraMaVe(int maVe){
		return chiTietVeDAO.kiemTraMaVe(maVe);
	}
}
