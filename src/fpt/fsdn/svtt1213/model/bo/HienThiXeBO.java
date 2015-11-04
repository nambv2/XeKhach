package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.bean.Xe;
import fpt.fsdn.svtt1213.model.dao.HienThiXeDAO;

public class HienThiXeBO {
	HienThiXeDAO hienThiXeDAO = new HienThiXeDAO();
	public Xe hienThiXe(String bienSoXe) {
		// TODO Auto-generated method stub
		
		return hienThiXeDAO.hienThiXe(bienSoXe);
	}

	public boolean getBienSo(String bienSoXe) {
		// TODO Auto-generated method stub
		return hienThiXeDAO.getBienSo(bienSoXe);

	}

}
