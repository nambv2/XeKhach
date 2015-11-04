package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.dao.CapNhatXeDAO;

public class CapNhatXeBO {

	public boolean capNhatXe(String bienSoXe, String loaiXe, String soChoNgoi) {
		// TODO Auto-generated method stub
		CapNhatXeDAO capNhatXeDAO = new CapNhatXeDAO();
		return capNhatXeDAO.capNhatXe(bienSoXe, loaiXe, soChoNgoi);
	}

	

}
