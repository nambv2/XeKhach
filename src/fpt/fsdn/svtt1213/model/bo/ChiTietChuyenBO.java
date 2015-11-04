package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.bean.ChuyenXe;
import fpt.fsdn.svtt1213.model.dao.ChiTietChuyenDAO;
import fpt.fsdn.svtt1213.model.dao.ThemChuyenDAO;

public class ChiTietChuyenBO {


	public ChuyenXe hienThiChuyenXe(String maChuyen) {
		ChiTietChuyenDAO chiTietChuyenDAO=new ChiTietChuyenDAO();
		return chiTietChuyenDAO.hienThiChuyenXe(maChuyen);
	}
   public boolean kiemTra(String maChuyen){
	   ThemChuyenDAO themChuyenDAO = new ThemChuyenDAO();
	return themChuyenDAO.checkMaChuyen(maChuyen);
	
}
	


}
