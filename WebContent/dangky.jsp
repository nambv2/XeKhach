<%@page import="java.util.HashMap"%>
<%@page import="fpt.fsdn.svtt1213.utility.Security"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.NguoiDung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Đăng ký</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="includes/header.jsp" %>
	<%
	String hoTen="";
	String queQuan="";
	String tenDangNhap="";
	String soDienThoai="";
	String soCMND="";
	int gioiTinh = 2;
	HashMap<String,String> hashMapError = new HashMap<String,String>();
	if(request.getAttribute("hashMapError") != null){
		hashMapError = (HashMap<String,String>) request.getAttribute("hashMapError");
	}
	if(request.getAttribute("nguoidung") != null ){
		NguoiDung u = (NguoiDung)request.getAttribute("nguoidung");
		hoTen = Security.stringToHTMLString(u.getHoTen());
		queQuan = Security.stringToHTMLString(u.getQueQuan());
		tenDangNhap = Security.stringToHTMLString(u.getTenDangNhap());
		soDienThoai = Security.stringToHTMLString(u.getSoDienThoai());
		soCMND = Security.stringToHTMLString(u.getSoCMND());
		gioiTinh = u.getGioiTinh();
	}
	%>
	<div class="container">
	<div class="col-md-offset-3 col-md-8 panel panel-info" id="dangky">
		  <h3>Đăng Ký</h3>
      	  <div class="error" id="message"><%if(request.getAttribute("message") != null) out.print((String)request.getAttribute("message"));%></div>
          <form action="DangKyServlet" method="post" class="form-horizontal" role="form">
              <div class="form-group">
                <label for="inputHoTen" class="col-sm-3 control-label">Họ tên (*) :</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="inputHoTen" name="inputHoTen" value="<%=hoTen%>">
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputHoTenError"><%if(hashMapError.get("hoTen") != null) out.print(hashMapError.get("hoTen")); %></label>
              </div>
             <div class="form-group">
                <label for="inputQueQuan" class="col-sm-3 control-label">Quê quán :</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="inputQueQuan" name="inputQueQuan" value="<%=queQuan%>">
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputQueQuanError"><%if(hashMapError.get("queQuan") != null) out.print(hashMapError.get("queQuan")); %></label>
              </div>
              <div class="form-group">
                <label for="inputGioiTinh" class="col-sm-3 control-label">Giới tính (*) :</label>
                <div class="col-sm-5">
                  <div class="radio">
					  <label>
					    <input type="radio" name="gioiTinh" value="1" <%if((gioiTinh == 1) || (gioiTinh == 2)) out.print("checked");%>>
					    Nam
					  </label>
				  </div>
				  <div class="radio">
					  <label>
					    <input type="radio" name="gioiTinh" value="0" <%if(gioiTinh == 0) out.print("checked");%>>
					    Nữ
					  </label>
				  </div>
                </div>
              </div>
              <div class="form-group">
                <label for="inputTenDangNhap" class="col-sm-3 control-label">Tên đăng nhập (*) :</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="inputTenDangNhap" name="inputTenDangNhap" value="<%=tenDangNhap%>">
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputTenDangNhapError" >
                	<%if(hashMapError.get("tenDangNhap1") != null) out.print(hashMapError.get("tenDangNhap1")); 
                		else if(hashMapError.get("tenDangNhap2") != null) out.print(hashMapError.get("tenDangNhap2")); 
                			else if(hashMapError.get("tenDangNhap") != null) out.print(hashMapError.get("tenDangNhap"));%>
                </label>
              </div>
              <div class="form-group">
                <label for="inputMatKhau" class="col-sm-3 control-label">Mật khẩu (*) :</label>
                <div class="col-sm-5">
                  <input type="password" class="form-control" id="inputMatKhau" name="inputMatKhau">
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputMatKhauError"><%if(hashMapError.get("matKhau") != null) out.print(hashMapError.get("matKhau")); %></label>
              </div>
              <div class="form-group">
                <label for="inputSoDienThoai" class="col-sm-3 control-label">Số điện thoại (*) :</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="inputSoDienThoai" name="inputSoDienThoai" value="<%=soDienThoai%>">
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputSoDienThoaiError"><%if(hashMapError.get("soDienThoai") != null) out.print(hashMapError.get("soDienThoai")); %></label>
              </div>
              <div class="form-group">
                <label for="inputSoCMND" class="col-sm-3 control-label">Số CMND (*) :</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="inputSoCMND" name="inputSoCMND" value="<%=soCMND%>">
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputSoCMNDError"><%if(hashMapError.get("soCMND") != null) out.print(hashMapError.get("soCMND")); %></label>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-4 col-sm-10">
                  <input type="submit" class="btn btn-info" value="Đăng Ký">
                </div>
              </div>
            </form>
    </div>
	</div>
	
	<%@include file="includes/footer.jsp" %>
</body>
</html>