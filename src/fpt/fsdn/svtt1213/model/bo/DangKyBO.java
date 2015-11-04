package fpt.fsdn.svtt1213.model.bo;

import java.util.HashMap;

import fpt.fsdn.svtt1213.model.bean.NguoiDung;
import fpt.fsdn.svtt1213.model.dao.DangKyDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class DangKyBO {
	public HashMap<String, String> hashMapError ;
	
	public HashMap<String, String> checkNguoiDung(NguoiDung u){
		DangKyDAO dk = new DangKyDAO();
		hashMapError = new HashMap<String, String>();
		if(!"".equals(u.getTenDangNhap())){
			if(u.getTenDangNhap().length() >= 5){
				if(Security.validateUsername(u.getTenDangNhap()) == false){
					hashMapError.put("tenDangNhap1", "Tên đăng nhập không hợp lệ");
					
				}else if(dk.kiemTraTenDangNhap(u.getTenDangNhap()) == true){
					hashMapError.put("tenDangNhap2", "Tên đăng nhập đã tồn tại");
				}
			}else{
				hashMapError.put("tenDangNhap", "Tên đăng nhập quá ngắn");
			}
			
		}else{
			hashMapError.put("tenDangNhap", "Vui lòng nhập tên đăng nhập");
		}
		
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
		
		if(!"".equals(u.getMatKhau())){
			if(u.getMatKhau().length() >=5 ){
				if(Security.validatePassword(u.getMatKhau()) == false){
					hashMapError.put("matKhau", "Mật khẩu không hợp lệ");
				}
			}else{
				hashMapError.put("matKhau", "Mật khẩu quá ngắn");
			}
			
		}else{
			hashMapError.put("matKhau", "Vui lòng nhập mật khẩu");
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
	public boolean dangKy(NguoiDung u){
		return new DangKyDAO().dangKy(u);
	}
}
