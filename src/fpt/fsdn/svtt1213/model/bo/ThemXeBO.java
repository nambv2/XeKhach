package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.dao.ThemXeDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class ThemXeBO {

	public boolean checkBienSoXe(String bienSoXe) {
		// TODO Auto-generated method stub
		return Security.validateBienSo(bienSoXe);
	}
	public boolean checkTonTai(String bienSoXe)
	{
		ThemXeDAO themXeDAO = new ThemXeDAO();
		return themXeDAO.checkTonTai(bienSoXe);
	}

	public boolean themXe(String bienSoXe, String loaiXe, String soChoNgoi) {
		ThemXeDAO themXeDAO = new ThemXeDAO();
		return themXeDAO.themXe(bienSoXe, loaiXe, soChoNgoi);
	}
}
