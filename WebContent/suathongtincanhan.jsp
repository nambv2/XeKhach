<%@page import="java.util.HashMap"%>
<%@page import="fpt.fsdn.svtt1213.utility.Security"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.NguoiDung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Thay đổi thông tin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<%
String hoTen="";
String queQuan="";
String userName="";
String matKhau="";
String soDienThoai="";
String soCMND="";
int gioiTinh = 2;

HashMap<String,String> hashMapError = new HashMap<String,String>();
if(request.getAttribute("hashMapError") != null){
	hashMapError = (HashMap<String,String>) request.getAttribute("hashMapError");
}

NguoiDung u=new NguoiDung();
if(request.getAttribute("nguoidung")!=null){
	u=(NguoiDung)request.getAttribute("nguoidung");
	hoTen = Security.stringToHTMLString(u.getHoTen());
	queQuan = Security.stringToHTMLString(u.getQueQuan());
	soDienThoai = Security.stringToHTMLString(u.getSoDienThoai());
	soCMND = Security.stringToHTMLString(u.getSoCMND());
	gioiTinh = u.getGioiTinh();
}
%>
	<%@include file="includes/header.jsp" %>
	<div class="container">
	<div class="col-md-offset-3 col-md-8 panel panel-info" id="capnhattaikhoan">
		  <h3>Sửa thông tin cá nhân</h3>
      	  <div class="error" id="message"><%if(request.getAttribute("message") != null) out.print((String)request.getAttribute("message"));%></div>
          <form action="SuaThongTinTaiKhoanServlet" method="post" class="form-horizontal" role="form">
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
                  <input type="text" class="form-control" id="inputQueQuan" name="inputQueQuan" 
                  value="<%=queQuan%>">
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputQueQuanError"><%if(hashMapError.get("queQuan") != null) out.print(hashMapError.get("queQuan")); %></label>
              </div>
              <div class="form-group">
                <label for="inputGioiTinh" class="col-sm-3 control-label">Giới tính (*) :</label>
                <div class="col-sm-5">
                  <div class="radio">
					  <label>
					    <input type="radio" name="gioiTinh" value="1" <%if(gioiTinh == 1) out.print("checked"); %>>Nam
					  </label>
				  </div>
				  <div class="radio">
					  <label>
					     <input type="radio" name="gioiTinh" value="0" <%if(gioiTinh == 0) out.print("checked"); %>>Nữ
					  </label>
				  </div>
                </div>
              </div>
              <div class="form-group">
                <label for="inputSoDienThoai" class="col-sm-3 control-label">Số điện thoại (*) :</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="inputSoDienThoai" name="inputSoDienThoai" value="<%=soDienThoai%>" >
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputSoDienThoaiError"><%if(hashMapError.get("soDienThoai") != null) out.print(hashMapError.get("soDienThoai")); %></label>
              </div>
              <div class="form-group">
                <label for="inputSoCMND" class="col-sm-3 control-label">Số CMND (*) :</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="inputSoCMND" name="inputSoCMND"  value="<%=soCMND%>">
                </div>
                <label for="inputHoTen" class="col-sm-4 error" id="inputSoCMNDError"><%if(hashMapError.get("soCMND") != null) out.print(hashMapError.get("soCMND")); %></label>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-4 col-sm-10">
                  <input type="submit" class="btn btn-info" value="Cập nhật">
                </div>
              </div>
            </form>
	
    </div>
	</div>
	
	<%@include file="includes/footer.jsp" %>
</body>
</html>