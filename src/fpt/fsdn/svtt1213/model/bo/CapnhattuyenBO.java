package fpt.fsdn.svtt1213.model.bo;

import java.util.ArrayList;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.dao.CapnhattuyenDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class CapnhattuyenBO {
	CapnhattuyenDAO capnhattuyenduongDAO=new CapnhattuyenDAO();
	public void capNhat(TuyenDuong td){
	
		capnhattuyenduongDAO.capNhat(td);
	}
	
	public TuyenDuong hienThiTuyen(String maTuyen) {
		
		return capnhattuyenduongDAO.hienThiTuyen(maTuyen);
		
	}

	public ArrayList<String> checkError(TuyenDuong tuyenDuong) {
		// TODO Auto-generated method stub
		ArrayList<String> error = new ArrayList<String>();
		if(! Security.validateTuyen(tuyenDuong.getNoiDi())){
			error.add("LoiNoiDi");
		}
		if(! Security.validateTuyen(tuyenDuong.getNoiDen())){
			error.add("LoiNoiDen");
		}
		if( tuyenDuong.getNoiDen().equals(tuyenDuong.getNoiDi())){
			error.add("TrungTen");
		}
		if(capnhattuyenduongDAO.checkTuyenDuong(tuyenDuong)){
			error.add("TuyenDuongDaCo");
		}
		return error;
	}
	public boolean kiemTraMaTuyen(String maTuyen){
		return capnhattuyenduongDAO.kiemTraMaTuyen(maTuyen);
	}

	
}
