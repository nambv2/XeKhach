<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="fpt.fsdn.svtt1213.model.bean.ChuyenXe"%><html>
<head>
	<title>Cập nhật chuyến</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    
     <link href="../${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="../${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	
	<div class="col-md-9"  id="chitietchuyen">
        <h3>Chi tiết chuyến xe</h3>
       <form class="form-horizontal" role="form">
        <div class="form-group">
        <% ChuyenXe chuyenXe=new ChuyenXe(); 
           if(request.getAttribute("ChuyenXe")!=null)
           {
          	chuyenXe= (ChuyenXe)request.getAttribute("ChuyenXe");
          	
          	%>
          <label for="inputmatuyen" class="col-sm-4 control-label">Mã chuyến : </label>
          <div class="col-sm-3">
           <label for="inputmatuyen" class="control-label"><%=chuyenXe.getMaChuyen()   %></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Tên tuyến : </label>
          <div class="col-md-5">
            <label for="inputmatuyen" class="control-label"><%=chuyenXe.getTuyenDuong()   %></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Thời gian đi : </label>
          <div class="col-sm-3">
            <label for="inputmatuyen" class="control-label"><%=chuyenXe.getThoiGianDi()   %></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Thời gian đến :  </label>
          <div class="col-sm-3">
            <label for="inputmatuyen" class="control-label"><%=chuyenXe.getThoiGianDen()   %></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Mã tài xế 1 :  </label>
          <div class="col-sm-3">
             <label for="inputmatuyen" class="control-label"><%if(chuyenXe.getMaTaixe1()== null) out.print("Chưa có"); else out.print(chuyenXe.getMaTaixe1());   %></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Mã tài xế 2 :  </label>
          <div class="col-sm-3">
             <label for="inputmatuyen" class="control-label"><%if(chuyenXe.getMaTaixe2()== null) out.print("Chưa có"); else out.print(chuyenXe.getMaTaixe2());  %></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Mã phụ xe : </label>
          <div class="col-sm-3">
             <label for="inputmatuyen" class="control-label"><%if(chuyenXe.getMaPhuXe()== null) out.print("Chưa có"); else out.print(chuyenXe.getMaPhuXe());  %></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Biển số xe : </label>
          <div class="col-sm-3">
            <label for="inputmatuyen" class="control-label"><%=chuyenXe.getBienSoXe()   %></label>
          </div>
        </div>
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-4 control-label">Tỷ lệ đặt vé online :  </label>
          <div class="col-sm-3">
                    <label for="inputmatuyen" class="control-label"><%=chuyenXe.getTiLeDatVeOnline()   %></label> %
          </div>
          
        </div>
        <%} %>
        
        <div class="form-group">
          <div class="col-sm-6">
          <a class="btn btn-info" href="CapNhatChuyenServlet?maChuyen=<%=chuyenXe.getMaChuyen() %>">Cập Nhật</a>
          </div>
          <div class="col-sm-6">
          <input type="hidden" id="maChuyen" value="<%=chuyenXe.getMaChuyen() %>">
          <a class="btn btn-info" href="#" id="xoa-chuyen">Xóa</a>
          </div>
        </div>
      </form>
    </div>
   
	
	<%@include file="../includes/admin_footer.jsp" %>
	<% 
	String st = "";
	st = (String) request.getAttribute("message");
	if("OK".equals(st)){
				%>	<script type="text/javascript">
	alert("Bạn vừa cập nhật thông tin thành công!");
	
	</script>
	<%
	st="";}	%>

	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#xoa-chuyen").click(function(){
				if(confirm("Bạn chắc chắn muốn xóa?")){
					var maChuyen = $("#maChuyen").val();
					$.ajax({
						type:'post',
						  url: 'XoaChuyenServlet',
						  data: 'maChuyen='+maChuyen
						});
				window.location.href="DanhSachChuyenServlet";
				alert("Xóa chuyến xe thành công")
				}
			
			})
		});
	</script>
	
	
	
</body>
</html>