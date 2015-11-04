package fpt.fsdn.svtt1213.model.bo;

import java.util.HashMap;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.utility.Security;

public class KiemTraCapNhatBO {
	public HashMap<String, String> hashMapError ;
	
	public HashMap<String, String> checkNguoiDung(NguoiDung u,String tenDangNhapCu){
		hashMapError = new HashMap<String, String>();
		
		
		if(!"".equals(u.getHoTen())){
			if(Security.validateFieldname(u.getHoTen()) == false){
				hashMapError.put("hoTen", "Họ tên không hợp lệ");
			}
		}else{
			hashMapError.put("hoTen", "Vui lòng nhập họ tên");
		}
		
		
		
		if(!"".equals(u.getQueQuan())){
			if(Security.validateQueQuan(u.getQueQuan()) == false){
				hashMapError.put("queQuan", "Quê quán không hợp lệ");
			}
		}
		

		if(!"".equals(u.getSoDienThoai())){
			if(Security.validateTelephone(u.getSoDienThoai()) == false){
				hashMapError.put("soDienThoai", "Số điện thoại không hợp lệ");
			}
		}else{
			hashMapError.put("soDienThoai", "Vui lòng nhập số điện thoại");
		}
		
		
		if(!"".equals(u.getSoCMND())){
			if(Security.validateSoCMND(u.getSoCMND()) == false){
				hashMapError.put("soCMND", "Số CMND không hợp lệ");
			}
		}else{
			hashMapError.put("soCMND", "Vui lòng nhập số CMND");
		}
		
		return hashMapError;
	}
}
