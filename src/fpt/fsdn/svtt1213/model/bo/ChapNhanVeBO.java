package fpt.fsdn.svtt1213.model.bo;

import java.sql.SQLException;

import fpt.fsdn.svtt1213.model.dao.ChapNhanVeDAO;

public class ChapNhanVeBO {
  ChapNhanVeDAO xulyVeDAO=new ChapNhanVeDAO();
	
	public void chapnhanVe(String maVe) throws SQLException {
		
		xulyVeDAO.chapnhanVe(maVe);
	}

	public void huyVe(String maVe) throws SQLException {
		xulyVeDAO.huyVe(maVe);
	}

}
