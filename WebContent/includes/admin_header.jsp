<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- kiem tra phan quyen -->
  <%@include file="kiemtraphanquyen.jsp" %>
    
  <!--slide show header -->
  <div id="header-slideshow">
      <div class="cycle-slideshow" data-cycle-fx="tileSlide" data-cycle-auto-height="4:3" data-cycle-speed="2000" data-cycle-delay="1000" style="height: 250px; overflow: hidden;">
        <img src="${pageContext.request.contextPath}/images/2.jpg" width="100%" height="250px">
        <img src="${pageContext.request.contextPath}/images/3.jpg" width="100%" height="250px">
        <img src="${pageContext.request.contextPath}/images/4.JPG" width="100%" height="250px">
        <img src="${pageContext.request.contextPath}/images/5.jpg" width="100%" height="250px">
     </div><!--end: slide show header -->
  </div>
   
 <nav class="navbar navbar-default" role="navigation">
	  <!-- Brand and toggle get grouped for better mobile display -->
	  <div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	      <span class="sr-only">Toggle navigation</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand"></a>
	    <a class="navbar-brand">Đặt vé xe khách</a>
	  </div>
	
	  <!-- Collect the nav links, forms, and other content for toggling -->
	  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    <ul class="nav navbar-nav">
	      <li><a href="${pageContext.request.contextPath}/TrangChuServlet">Trang chủ</a></li>
	      <li><a href="${pageContext.request.contextPath}/TimKiemVeXeServlet">Tìm kiếm</a></li>
	      <li><a href="#">Giới thiệu</a></li>
	      <li><a href="#">Liên hệ</a></li>
	    </ul>
	   
	    <ul class="nav navbar-nav navbar-right">
	      <%
	    if( session.getAttribute("tenDangNhap") == null){
	    	%>
	    	 <li><a href="dangky.jsp">Đăng ký</a></li>
	    	<%
	    }
	    %>
	      <li class="dropdown">
	        <%
	        if(session.getAttribute("tenDangNhap") != null){
	        	String tenDangNhap = (String) session.getAttribute("tenDangNhap");
				%>
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=tenDangNhap %> <b class="caret"></b></a>
				<ul class="dropdown-menu">
		          <li><a href="${pageContext.request.contextPath}/ThongTinTaiKhoanServlet">   Quản lý tài khoản   </a></li>
		          <li><a href="${pageContext.request.contextPath}/QuanlyveServlet">   Quản lý đặt vé   </a></li>
		          <li class="divider"></li>
		          <li><a href="${pageContext.request.contextPath}/DangXuatServlet">   Đăng xuất  </a></li>
		        </ul>
				<%
	        }else{
	        	%>
	        	<a href="dangnhap.jsp">Đăng nhập</a>
	        	<%
	        }
	        %>
	        
	        
	      </li>
	      <li><a href="#"></a></li>
	      <li><a href="#"></a></li>
	    </ul>
	  </div><!-- /.navbar-collapse -->
	</nav>
	
	
	
 
<div class="container">
  <div class="row">
    <div class="col-md-3">
      <div class="list-group">
        <a href="#" class="list-group-item active">
          Danh mục
        </a>
        <a href="${pageContext.request.contextPath}/DanhsachtuyenServlet" class="list-group-item">Quản lý tuyến đường</a>
        <a href="${pageContext.request.contextPath}/DanhSachChuyenServlet" class="list-group-item">Quản lý chuyến xe</a>
        <a href="${pageContext.request.contextPath}/DanhSachNhanVienServlet" class="list-group-item">Quản lý nhân viên</a>
        <a href="${pageContext.request.contextPath}/DanhSachVeDuocDatServlet" class="list-group-item">Quản lý đặt vé</a>
        <a href="${pageContext.request.contextPath}/DanhSachGiaVeServlet" class="list-group-item">Quản lý giá vé</a>
        <a href="${pageContext.request.contextPath}/DanhSachXeServlet" class="list-group-item">Quản lý xe</a>
        <a href="${pageContext.request.contextPath}/ThongKeTheoThangServlet" class="list-group-item">Thống kê theo tháng</a>
        <a href="${pageContext.request.contextPath}/ThongKeTheoTuyenServlet" class="list-group-item">Thống kê theo tuyến</a>
        <a href="${pageContext.request.contextPath}/BaoCaoServlet" class="list-group-item">Báo cáo</a>
      </div>
    </div>