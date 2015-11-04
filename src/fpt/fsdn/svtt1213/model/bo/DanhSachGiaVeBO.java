package fpt.fsdn.svtt1213.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.DanhsachGiaVeDAO;

public class DanhSachGiaVeBO {
	DanhsachGiaVeDAO danhsachGiaVe=new DanhsachGiaVeDAO();
	public ArrayList<TuyenDuong>  tuyenduong() throws SQLException {
		
		return danhsachGiaVe.tuyenduong();
	}

	public ArrayList<GiaVe> timGiaVe(String maTuyen) throws SQLException {
		return danhsachGiaVe.timGiaVe(maTuyen);
	}

}
