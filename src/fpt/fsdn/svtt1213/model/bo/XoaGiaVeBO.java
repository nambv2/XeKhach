package fpt.fsdn.svtt1213.model.bo;

import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.bean.GiaVe;
import fpt.fsdn.svtt1213.model.dao.XoaGiaVeDAO;

public class XoaGiaVeBO {

	public boolean xoaGiave(GiaVe giave) throws SQLException {
		
		XoaGiaVeDAO xoaGiaVe=new XoaGiaVeDAO();
		return xoaGiaVe.xoaGiave(giave);
		
	}

	

}
