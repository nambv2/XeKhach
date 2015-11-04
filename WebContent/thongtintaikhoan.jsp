<%@page import="fpt.fsdn.svtt1213.utility.Security"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="fpt.fsdn.svtt1213.model.bean.NguoiDung"%><html>
<head>
	<title>Thông tin tài khoản</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
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
NguoiDung u=new NguoiDung();
if(request.getAttribute("nguoiDung")!=null){
	u=(NguoiDung)request.getAttribute("nguoiDung");
	hoTen = u.getHoTen();
	queQuan = u.getQueQuan();
	userName = u.getTenDangNhap();
	matKhau = u.getMatKhau();
	soDienThoai = u.getSoDienThoai();
	soCMND = u.getSoCMND();
	gioiTinh = u.getGioiTinh();
}
%>
	<%@include file="includes/header.jsp" %>
		<div class="container">
			<div class="col-md-9 col-md-offset-2 panel oanel-default" id="thongtintaikhoan">
	        <div><center><h3></>Thông tin tài khoản</h3></center></div>
	        <form  action="CapnhatThongTinServlet" method="post"class="form-horizontal" role="form">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-4 control-label">Họ tên :</label>
			    <div class="col-sm-8 thongtin">
			    <input type="hidden" class="form-control" name="hoTen" id="hoTen" 
			    value="<%=hoTen%>">
			    
			      <label id="hoTen">
			      <%
			    	  out.println(hoTen);
			      %>
			      </label>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputEmail3" class="col-sm-4 control-label">Quê quán :</label>
			    <div class="col-sm-8 thongtin">
			    <input type="hidden" class="form-control" name="queQuan" id="queQuan" value="<%=queQuan%>">
			      <label><%
			     
			    	  out.println(queQuan);

			      %></label>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputEmail3" class="col-sm-4 control-label">Giới tính:</label>
			    <div class="col-sm-8 thongtin">
			    <input type="hidden" class="form-control" name="gioiTinh" id="gioiTinh" value="<%=gioiTinh%>">
			      <label id="gioiTinh"><%
			      
			    	  if(gioiTinh==1)
			    	  out.println("Nam");
			    	  if(gioiTinh==0)
				    	  out.println("Nữ");
			      %></label>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputEmail3" class="col-sm-4 control-label">Tên đăng nhập :</label>
			    <div class="col-sm-8 thongtin">
			    <input type="hidden" class="form-control" name="tenDangnhap" id="tenDangnhap" value="<%=userName%>">
			      <label><%
			    	  out.println(userName);
			      %></label>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputEmail3" class="col-sm-4 control-label">Số điện thoại :</label>
			    <div class="col-sm-8 thongtin">
			    <input type="hidden" class="form-control" name="soDT" id="soDT" value="<%=soDienThoai%>">
			      <label><%

			    	  out.println(soDienThoai);

			      %></label>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputEmail3" class="col-sm-4 control-label">Số CMND :</label>
			    <div class="col-sm-8 thongtin">
			    <input type="hidden" class="form-control" name="cmnd" id="cmnd" value="<%=soCMND%>">
			      <label><%
			    	  out.println(soCMND);
			      %></label>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-3 col-sm-2">
			      <button type="submit" class="btn btn-primary">Chỉnh sửa</button>
			    </div>
			    
			  </div>
			</form>
	        
	    </div>
			
		</div>
	
	<%@include file="includes/footer.jsp" %>
</body>
</html>