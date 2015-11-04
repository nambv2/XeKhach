<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="fpt.fsdn.svtt1213.controller.DanhSachGiaVeServlet"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.DanhSachVeDuocDat"%><html>
<head>
	<title>Chi tiết vé đặt</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
<%
DanhSachVeDuocDat chitietVe=new DanhSachVeDuocDat();
if(request.getAttribute("chitietVe")!=null){
	chitietVe=(DanhSachVeDuocDat)request.getAttribute("chitietVe");
	
}
%>
	<%@include file="../includes/admin_header.jsp" %>
	<div class="col-md-9" id="danhsachtuyen">
        <h3>Chi tiết vé</h3>
     
        <form action="ChapNhanVeServlet" method="post" class="form-horizontal" role="form">
		<input type="hidden" class="form-control" name="mave" id="mave" value="<%
		    	 if(request.getAttribute("chitietVe")!=null){
			    	 out.print(chitietVe.getMaVe());
			    	 }
		    %>">
		    
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Số CMND :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'> <%
		      if(request.getAttribute("chitietVe")!=null){
		    	  out.print(chitietVe.getCMND());
		      }
		      %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Số điện thoại :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'> <%
		      if(request.getAttribute("chitietVe")!=null){
		    	out.print(chitietVe.getSoDT());
		      }
		      %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Thời gian đi :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'> <%
		      if(request.getAttribute("chitietVe")!=null){
		    	  out.print(chitietVe.getThoiGiandi());
		      }
		      %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Chỗ ngồi :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'> <%
		      if(request.getAttribute("chitietVe")!=null){
		    	  out.print(chitietVe.getVitriNgoi())  ;
		      }
		      %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Tên tuyến :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'> <%
		      if(request.getAttribute("chitietVe")!=null){%>
		    	 <%out.print(chitietVe.getNoiDi()+'-'+chitietVe.getNoiDen());%>
		      <%}%>
		      </label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Giá vé :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'> <%
		      if(request.getAttribute("chitietVe")!=null){
		    	  out.print(chitietVe.getGiaTien());
		      }
		      %></label>
		    </div>
		  </div>
		  <div class="form-group">
		  <% 
		  if(request.getAttribute("chitietVe")!=null){
			  int trangthai=chitietVe.getTrangThai();
		  if(trangthai==0){
		  %>
		    <div class="col-sm-offset-3 col-sm-2">
		    <button type = "submit" class="btn btn-primary" name="button" value = "chapnhan"> Chấp nhận</button>
		    </div>
		    <div class="col-sm-offset-3 col-sm-2">
		   	 <button type = "submit" class="btn btn-primary" name="button" value = "huy">Hủy</button> 
		    </div>
		  <%}else {%>
		  <div></div>
		    <div class="col-sm-offset-1 col-sm-4">
		    	<button type = "submit" class="btn btn-primary" name="button" value = "trove"> Trở về</button>
		    		    </div>  <%} }%>
		  </div>
		</form>
        
    </div>
	
	
	<%@include file="../includes/admin_footer.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function(){
				history.back();
			});
		});
	</script>
</body>
</html>