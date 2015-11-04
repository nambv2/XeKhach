<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="fpt.fsdn.svtt1213.model.bean.GiaVe"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%><html>
<head>
	<title>Cập nhật giá vé</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
     <!-- Bootstrap -->
    <link href="../${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="../${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<%
String tenTuyen=null;
GiaVe giave=new GiaVe();
if(request.getAttribute("giave")!=null && request.getAttribute("tentuyen")!=null){
	giave=(GiaVe)request.getAttribute("giave");
	 tenTuyen=(String)request.getAttribute("tentuyen");
}

%>
	<%@include file="../includes/admin_header.jsp" %>
	<div class="col-md-9"  id="themgiave">
        <h3>Cập nhật giá vé</h3>
       <form action="CapnhatGiaVeServlet_1" method="post" id="frm-themtuyen" class="form-horizontal" role="form">
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-4 control-label">Tên tuyến : (*) </label>
          <div class="col-sm-6">
          <input  type="hidden" class="form-control" name="matuyen" id="matuyen" value="
          <%
             if(request.getAttribute("tentuyen")!=null){
             out.println(giave.getMaTuyen());
             }
             if (request.getAttribute("matuyen")!=null){
            	 out.println((String)request.getAttribute("matuyen"));
             }
             %>
          ">
            <label  id="matuyen">
             <%
             if(request.getAttribute("inputtenTuyen")!=null){
         		 out.print((String)request.getAttribute("inputtenTuyen"));
         	 }
             if(request.getAttribute("tentuyen")!=null){
             %>
            
             <%=tenTuyen%>
             
             <%} %>
            
            </label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Biển số xe : (*) </label>
          <div class="col-sm-3">
          <input type="hidden" class="form-control" name="inputbiensoxe" id="inputbiensoxe" value="
          <%
          if(request.getAttribute("inputbiensoXe")!=null){
     		 out.print((String)request.getAttribute("inputbiensoXe"));
     	 }
             if(request.getAttribute("tentuyen")!=null){
             %>
             
             <%=giave.getBienSoXe()%>
             
             <%} %>
          ">
          <label id="inputbiensoxe">
             <%
             if(request.getAttribute("inputbiensoXe")!=null){
         		 out.print((String)request.getAttribute("inputbiensoXe"));
         	 }
             if(request.getAttribute("tentuyen")!=null){
             %>
             
             <%=giave.getBienSoXe()%>
             
             <%} %>
             
            </label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Giá vé : (*) </label>
          <div class="col-sm-4">
             <input type="text" class="form-control" name="GiaVe" id="GiaVe" 
             value="<%if(request.getAttribute("giave")!=null){
            		 out.print((String)String.valueOf(giave.getGiaVe()));
            	 }
             if(request.getAttribute("inputgiave")!=null){
        		 out.print((String)request.getAttribute("inputgiave"));
        	 }
             if (request.getAttribute("giaVe") != null)
  				out.print((String)request.getAttribute("giaVe"));%>"> 
          </div>
          VNĐ
          <%if(request.getAttribute("GiaVeError")!=null){
        	  %>
        	  <span style="color: red"><label style="color: red; font-size: 15px;font-weight: normal"></label>Nhập sai</span>
        	  <%
          }
          %>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Giảm giá vé khứ hồi : (*) </label>
          <div class="col-sm-4">
             <input type="text" class="form-control" name="GiamGia" id="GiamGia" 
             value="<%if(request.getAttribute("giave")!=null){
            		 out.print((String)String.valueOf(giave.getGiamGiave()));
            	 }
             if(request.getAttribute("inputgiamgiave")!=null){
        		 out.print((String) request.getAttribute("inputgiamgiave"));
        	 }
             if (request.getAttribute("giamGia") != null)
 				out.print((String)request.getAttribute("giamGia"));%>">
          </div>
          %   
          <%if(request.getAttribute("GiamGiaError")!=null){
        	  %>
        	  <span style="color: red"><label style="color: red; font-size: 15px;font-weight: normal"></label>Nhập sai</span>
        	  <%
          }
          %>
        </div>
        
        <div class="form-group">
          <div class="col-sm-offset-4 col-sm-10">
            <button type="submit" class="btn btn-info">Cập nhật</button>
          </div>
        </div>
      </form>
    </div>
	
	
   
</body>
</html>