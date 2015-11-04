$(document).ready(function(){

	 $(function() {
		    $( ".datepicker" ).datepicker({ 
		    	dateFormat: "dd-mm-yy"
		    	});
		  });
	 
	 $(function() {
		    $( "input[name='ngayDi']" ).datepicker({ 
		    	dateFormat: "dd-mm-yy",
		    	minDate: 0
		    	});
		  });
	 
	 $(function() {
		    $( "input[name='ngayVe']" ).datepicker({ 
		    	dateFormat: "dd-mm-yy",
		    	minDate: 0
		    	});
		  });
	 
	 $("input[name='ngayDi']").change(function(){
		 var ngayDi = $("input[name='ngayDi']").val().split("-");//tach ngay thang nam
		 var di = new Date(ngayDi[2], ngayDi[1] - 1, ngayDi[0]);//tao date, thang -1 (javascript 0 - 11)
		 var hienTai = new Date();
		 var offset = di.getTime() - hienTai.getTime();
		 var khoang = Math.round(offset / 1000 / 60 / 60 / 24); 
		 
		 $("input[name='layNgayDi']").val(khoang);
		 
	 });
	 
//		 $(function() {
//			 var khoang = $("input[name='layNgayDi']").val();//tach ngay thang nam
//			    $("input[name='ngayVe']").datepicker({ 
//			    	dateFormat: "dd-mm-yy",
//			    	minDate:khoang
//			    	});
//			  });
	 
	 
	//valid dang ky
	$("#dangky #inputHoTen").change(function(){
		var hoTen = $(this).val();
		$.ajax({
            type: "post",
            url: "KiemTraDangKyServlet",
            data: "inputHoTen="+ hoTen, 
            success: function(errHashMap) {
            	if(errHashMap.search("hoTen") == -1){
            		$('#inputHoTenError').html("");
            	}else{
            		$('#inputHoTenError').html("Họ tên không hợp lệ");
            	}
            }
        });
	});
	
	$("#dangky #inputQueQuan").change(function(){
		var queQuan = $(this).val();
		$.ajax({
            type: "post",
            url: "KiemTraDangKyServlet",
            data: "inputQueQuan="+ queQuan, 
            success: function(errHashMap) {
            	if(errHashMap.search("queQuan") == -1){
            		$('#inputQueQuanError').html("");
            	}else{
            		$('#inputQueQuanError').html("Quê quán không hợp lệ");
            	}
            }
        });
	});
	
	$("#dangky #inputTenDangNhap").change(function(){
		var tenDangNhap = $(this).val();
		if(tenDangNhap.length >= 5){
			$.ajax({
	            type: "post",
	            url: "KiemTraDangKyServlet",
	            data: "inputTenDangNhap="+ tenDangNhap, 
	            success: function(errHashMap) {
	            	
	            	if((errHashMap.search("tenDangNhap1") == -1) &&(errHashMap.search("tenDangNhap2") == -1)){
	            		$('#inputTenDangNhapError').html("");
	            	}else if(errHashMap.search("tenDangNhap1") != -1){
	            		$('#inputTenDangNhapError').html("Tên đăng nhập không hợp lệ");
	            	}else if(errHashMap.search("tenDangNhap2") != -1){
	            		$('#inputTenDangNhapError').html("Tên đăng nhập đã tồn tại");
	            	}
	            }
	        });
		}else{
			$('#inputTenDangNhapError').html("Tên đăng nhập quá ngắn");
		}
		
	});
	
	$("#dangky #inputMatKhau").change(function(){
		var matKhau = $(this).val();
		if(matKhau.length >= 5){
			$.ajax({
	            type: "post",
	            url: "KiemTraDangKyServlet",
	            data: "inputMatKhau="+ matKhau, 
	            success: function(errHashMap) {
	            	if(errHashMap.search("matKhau") == -1){
	            		$('#inputMatKhauError').html("");
	            	}else{
	            		$('#inputMatKhauError').html("Mật khẩu không hợp lệ");
	            	}
	            }
	        });
		}else{
			$('#inputMatKhauError').html("Mật khẩu quá ngắn");
		}
		
	});
	
	$("#dangky #inputSoDienThoai").change(function(){
		var soDienThoai = $(this).val();
		$.ajax({
            type: "post",
            url: "KiemTraDangKyServlet",
            data: "inputSoDienThoai="+ soDienThoai, 
            success: function(errHashMap) {
            	
            	if(errHashMap.search("soDienThoai") == -1){
            		$('#inputSoDienThoaiError').html("");
            	}else{
            		$('#inputSoDienThoaiError').html("Số điện thoại không hợp lệ");
            	}
            	
            }
        });
	});
	
	$("#dangky #inputSoCMND").change(function(){
		var soCMND = $(this).val();
		$.ajax({
            type: "post",
            url: "KiemTraDangKyServlet",
            data: "inputSoCMND="+ soCMND, 
            success: function(errHashMap) {
            	
            	if(errHashMap.search("soCMND") == -1){
            		$('#inputSoCMNDError').html("");
            	}else{
            		$('#inputSoCMNDError').html("Số CMND không hợp lệ");
            	}
            	
            }
        });
	});
	
	
	
	
	//valid cap nhat
	$("#capnhattaikhoan #inputHoTen").change(function(){
		var hoTen = $(this).val();
		$.ajax({
            type: "post",
            url: "KiemTraCapNhatServlet",
            data: "inputHoTen="+ hoTen, 
            success: function(errHashMap) {
            	if(errHashMap.search("hoTen") == -1){
            		$('#inputHoTenError').html("");
            	}else{
            		$('#inputHoTenError').html("Họ tên không hợp lệ");
            	}
            }
        });
	});
	
	$("#capnhattaikhoan #inputQueQuan").change(function(){
		var queQuan = $(this).val();
		$.ajax({
            type: "post",
            url: "KiemTraCapNhatServlet",
            data: "inputQueQuan="+ queQuan, 
            success: function(errHashMap) {
            	if(errHashMap.search("queQuan") == -1){
            		$('#inputQueQuanError').html("");
            	}else{
            		$('#inputQueQuanError').html("Quê quán không hợp lệ");
            	}
            }
        });
	});
	
	$("#capnhattaikhoan #inputSoDienThoai").change(function(){
		var soDienThoai = $(this).val();
		$.ajax({
            type: "post",
            url: "KiemTraCapNhatServlet",
            data: "inputSoDienThoai="+ soDienThoai, 
            success: function(errHashMap) {
            	
            	if(errHashMap.search("soDienThoai") == -1){
            		$('#inputSoDienThoaiError').html("");
            	}else{
            		$('#inputSoDienThoaiError').html("Số điện thoại không hợp lệ");
            	}
            	
            }
        });
	});
	
	$("#capnhattaikhoan #inputSoCMND").change(function(){
		var soCMND = $(this).val();
		$.ajax({
            type: "post",
            url: "KiemTraCapNhatServlet",
            data: "inputSoCMND="+ soCMND, 
            success: function(errHashMap) {
            	
            	if(errHashMap.search("soCMND") == -1){
            		$('#inputSoCMNDError').html("");
            	}else{
            		$('#inputSoCMNDError').html("Số CMND không hợp lệ");
            	}
            	
            }
        });
	});
	
	
	
	$("nav li").hover(function(){
		 	$(this).addClass("active");
		  },function(){
			 $(this).removeClass("active");
	});
	
});


