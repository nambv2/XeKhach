<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.GiaVe"%><html>
<head>
	<title>Thêm giá vé</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="../${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

      <%
  		GiaVe giaVe=new GiaVe();

      if(request.getAttribute("VeTonTai")!=null){
      giaVe=(GiaVe)request.getAttribute("VeTonTai");}
      if(request.getAttribute("VeTontai")!=null){
      giaVe=(GiaVe)request.getAttribute("VeTontai");}
      %>

	<%@include file="../includes/admin_header.jsp" %>
	
	<div class="col-md-9"  id="themgiave">
        <h3>Thêm giá vé</h3>
       <form action="ThemGiaVeServlet" method="post" id="frm-themtuyen" class="form-horizontal" role="form">
        <div class="form-group">
          <label   for="inputmatuyen" class="col-sm-4 control-label">Tên tuyến : (*) </label>
          <div class="col-sm-6">
            <select type="text" id="inputmatuyen" name="inputmatuyen">
            <option value="all">-----------------Chọn tuyến----------------</option>
             <%
            ArrayList<TuyenDuong> arr;
            if(request.getAttribute("tuyen")!= null){
             arr = (ArrayList<TuyenDuong>)request.getAttribute("tuyen");
             for(int i = 0; i< arr.size(); i++){
            %>
             <option value="<%=arr.get(i).getMaTuyen() %>" 
             <%
              		if(request.getAttribute("matuyen") != null){
              		String maTuyen=(String)request.getAttribute("matuyen");
              		if(maTuyen.equals(arr.get(i).getMaTuyen())){
              		out.print("selected");
              							}
              						}
             if(request.getAttribute("VeTonTai")!=null){
                 String maTuyen=(String)giaVe.getMaTuyen();
  			   if(maTuyen.equals(arr.get(i).getMaTuyen())){
  					out.print("selected");}}
                   if(request.getAttribute("VeTontai")!=null){
                   String maTuyen=(String)giaVe.getMaTuyen();
    			   if(maTuyen.equals(arr.get(i).getMaTuyen())){
    					out.print("selected");}}
             						%>
             ><%=arr.get(i).getNoiDi()+"-"+arr.get(i).getNoiDen()%>
            </option>
            <%
             }
            }
            %>
             
            </select>
          <%
          if("ErrorMatuyen".equals(request.getAttribute("inputmatuyen"))&&request.getAttribute("inputmatuyen")!=null){
        	  %>
        	  <span style="color: red "><label style="color: red; font-size: 15px;font-weight: normal"></label>Bạn chưa chọn Tuyến</span>
        	  <%
          }
         
          
          if(request.getAttribute("VeTontai")!=null){
        	  %>
        	  <span style="color: red "><label style="color: red; font-size: 15px;font-weight: normal"></label>Giá vé đã tồn tại</span>
        	  <%
          }
          
          %></div>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Biển số xe : (*) </label>
          <div class="col-sm-4">
            <select type="text" id="inputbiensoxe" name="inputbiensoxe">
              <option value="all"> ---------------Chọn biển số xe------------</option>
              <%
           
            if(request.getAttribute("tuyen")!= null){
             arr = (ArrayList<TuyenDuong>)request.getAttribute("tuyen");
             for(int i = 0; i< arr.size(); i++){
            %>
             <option value="<%=arr.get(i).getBienSoXe()%>"
              <% 
              if(request.getAttribute("VeTonTai")!=null){
                  String bienSoXe=(String)giaVe.getBienSoXe();
     				if(bienSoXe.equals(arr.get(i).getBienSoXe())){
     					out.print("selected");}}
              if(request.getAttribute("VeTontai")!=null){
             String bienSoXe=(String)giaVe.getBienSoXe();
				if(bienSoXe.equals(arr.get(i).getBienSoXe())){
					out.print("selected");}}%>
             ><%=arr.get(i).getBienSoXe()%>
            
             </option>
            <%
             }
            }
            %>
            </select></div>
            <%
            if("ErrorBiensoXe".equals(request.getAttribute("inputbiensoxe"))&&request.getAttribute("inputbiensoxe")!=null){
          	  %>
          	  <span style="color: red"><label style="color: red; font-size: 15px;font-weight: normal"></label>Bạn chưa chọn biển số xe</span>
          	  <%
            }
          if(request.getAttribute("VeTontai")!=null){
        	  %>
        	  <span style="color: red"><label style="color: red; font-size: 15px;font-weight: normal"></label>Giá vé đã tồn tại</span>
        	  <%
          }
           
          %>
          
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Giá vé : (*) </label>
          <div class="col-sm-4">
             <input type="text" class="form-control" name="inputgiave" value="<%
            	 if(request.getAttribute("inputgiave")!=null){
            		 out.print((String)request.getAttribute("inputgiave"));
            	 }
           	    if(request.getAttribute("ktra_giaVe")!=null){
        		 out.print((String)request.getAttribute("ktra_giaVe"));
        		 }
             %>"> 
          </div>
          VNĐ
          <%
          if(request.getAttribute("ktra_giaVe")!=null){
        	  %>
        	  <span style="color: red" ><label style="color: red; font-size: 15px;font-weight: normal"></label>Giá vé đã tồn tại</span>
        	  <%  
          }
          if(request.getAttribute("GiaVeError")!=null){
        	  %>
        	  <span style="color: red"><label style="color: red; font-size: 15px;font-weight: normal"></label>Nhập sai</span>
        	  <%
          }
          %>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Giảm giá vé khứ hồi : (*) </label>
          <div class="col-sm-4">
             <input type="text" class="form-control" name="inputgiamgiave" 
             value="<%
            	 if(request.getAttribute("inputgiamgiave")!=null){
            		 out.print((String) request.getAttribute("inputgiamgiave"));
            	 }
            	 if(request.getAttribute("ktra_giamGia")!=null){
        		 out.print((String)request.getAttribute("ktra_giamGia"));
        	 }
             %>"
             >
          </div>
          %
          <%
          if(request.getAttribute("ktra_giamGia")!=null){
        	  %>
        	  <span style="color: red"><label style="color: red; font-size: 15px;font-weight: normal"></label>Giá vé đã tồn tại</span>
        	  <%  
          }
          if(request.getAttribute("GiamGiaError")!=null){
        	  %>
        	  <span style="color: red"><label style="color: red; font-size: 15px;font-weight: normal"></label>Nhập sai</span>
        	  <%
          }
          %>
        </div>
        
        <div class="form-group">
          <div class="col-sm-offset-4 col-sm-10">
            <button type="submit" class="btn btn-info">Thêm tuyến</button>
          </div>
        </div>
      </form>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
</body>
</html>