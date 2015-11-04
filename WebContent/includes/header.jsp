<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!--slide show header -->
  <div id="header-slideshow">
      <div class="cycle-slideshow" data-cycle-fx="tileSlide" data-cycle-auto-height="4:3" data-cycle-speed="2000" data-cycle-delay="1000" style="height: 250px; overflow: hidden;">
        <img src="images/2.jpg" width="100%" height="250px">
        <img src="images/3.jpg" width="100%" height="250px">
        <img src="images/4.JPG" width="100%" height="250px">
        <img src="images/5.jpg" width="100%" height="250px">
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
	    <%
	    if(session.getAttribute("phanQuyen") != null && (Integer.parseInt(session.getAttribute("phanQuyen").toString()) == 89)){
	    	%>
	    	<li><a href="admin/quantri.jsp">Quản trị</a></li>
	    	<%
	    }else{
	    	%>
	    	<li><a href="TrangChuServlet">Trang chủ</a></li>
	    	<%
	    }
	    %>
	      
	      <li><a href="TimKiemVeXeServlet">Tìm kiếm</a></li>
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
		          <li><a href="${pageContext.request.contextPath}/ThongTinTaiKhoanServlet">    Quản lý tài khoản    </a></li>
		          <li><a href="${pageContext.request.contextPath}/QuanlyveServlet">    Quản lý đặt vé    </a></li>
		          <li class="divider"></li>
		          <li><a href="${pageContext.request.contextPath}/DangXuatServlet">    Đăng xuất    </a></li>
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

