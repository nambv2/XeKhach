package fpt.fsdn.svtt1213.model.bo;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.ThemtuyenDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class ThemtuyenBO {
	ThemtuyenDAO themtuyenDAO = new ThemtuyenDAO();
	
	public boolean kTraMaTuyen(String maTuyen){
		return themtuyenDAO.kTraMaTuyen(maTuyen);
	}
	
	public boolean kTraNoiDiDen(String noiDi, String noiDen){
		return themtuyenDAO.kTraNoiDiDen(noiDi, noiDen);
	}
	
	public boolean validateNoiDiDen(String diaDiem) {
		if (!Security.validateTuyen(diaDiem)) {
			return false;
		}
		return true;
	}
	
	public void themTuyen(TuyenDuong td) {
		themtuyenDAO = new ThemtuyenDAO();
		themtuyenDAO.themTuyen(td);
	}

	public boolean validateId(String id) {
		if (Security.validateId(id)) {
			return true;
		}
		return false;

	}
}
