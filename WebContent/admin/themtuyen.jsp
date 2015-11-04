<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%><html>
<head>
	<title>Trang Chu</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

	
	<%@include file="../includes/admin_header.jsp" %>
	<%
	String maTuyen = "";
	String noiDi = "";
	String noiDen = "";
	
	%>
	<div class="col-md-9"  id="themtuyen">
        <h3>Thêm tuyến đường</h3>
      <form action="${pageContext.request.contextPath}/ThemtuyenServlet" method="post" class="form-horizontal" style="padding-left: 60px;">
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Mã tuyến : (*) </label>
          <div class="col-sm-4">
            
            <%
				if(request.getAttribute("thongbao1")!=null){
					if(request.getAttribute("thongbao4")!=null){
						 maTuyen = (String)request.getAttribute("maTuyen");
						 %>
							<input type="text" class="form-control" name="maTuyen" value="<%=maTuyen %>" maxlength="20">
							<font color=red >Mã tuyến đã tồn tại !</font>
							
							<%
					}
					else{
						
					
					 maTuyen = (String)request.getAttribute("maTuyen");
				%>
					<input type="text" class="form-control" name="maTuyen" value="<%=maTuyen %>" maxlength="20">
					<font color=red >Dữ liệu không hợp lệ !</font>
					
					<%}}
				else{
					if(request.getAttribute("thongbao4")!=null){
						 maTuyen = (String)request.getAttribute("maTuyen");
						 %>
							<input type="text" class="form-control" name="maTuyen" value="<%=maTuyen %>" maxlength="20">
							<font color=red >Mã tuyến đã tồn tại !</font>
							
							<%
					}else{
					maTuyen = (String)request.getAttribute("maTuyen");
					if(maTuyen == null){
	           			maTuyen = "";
					}
	           			%>
	           		<input type="text" class="form-control" name="maTuyen" value="<%=maTuyen %>" maxlength="15">
	           			
	           		<%
				}}
           		
			%>
			
           
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">Nơi đi : (*) </label>
          <div class="col-sm-4">
            <%
				if(request.getAttribute("thongbao2")!=null){
					noiDi=(String)request.getAttribute("noiDi");
			%>
					<input type="text" class="form-control" name="noiDi" value="<%=noiDi %>" maxlength="50">
					<font color=red >Dữ liệu không hợp lệ !</font>
			<%}
				else{
					
					if(request.getAttribute("thongbao5")!=null){
						noiDi=(String)request.getAttribute("noiDi");
						%>
						<input type="text" class="form-control" name="noiDi" value="<%=noiDi %>" maxlength="50">
						<font color=red >Nơi đi, nơi đến của tuyến đã tồn tại  !</font>
				<%
					}
					else{
						if(request.getAttribute("thongbao6")!=null){
							noiDi=(String)request.getAttribute("noiDi");
							%>
							<input type="text" class="form-control" name="noiDi" value="<%=noiDi %>" maxlength="50">
							<font color=red >Nơi đi, nơi đến không thể trùng nhau  !</font>
					<%
						}
						else{
					noiDi=(String)request.getAttribute("noiDi");
					if(noiDi == null){
	            		noiDi = "" ;
					}
	            	%>
	            	<input type="text" class="form-control" name="noiDi" value="<%=noiDi %>" maxlength="50">
	            	<% 
				}}}
			%>
			
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">Nơi đến : (*) </label>
          <div class="col-sm-4">
          <%if(request.getAttribute("thongbao3")!=null){
        	  noiDen=(String)request.getAttribute("noiDen");
		%>
		<input type="text" class="form-control" name="noiDen" value="<%=noiDen %>" maxlength="30">
		<font color=red >Dữ liệu không hợp lệ !</font>
			<%}
          else{
        	  if(request.getAttribute("thongbao5")!=null){
        		  noiDen=(String)request.getAttribute("noiDen");
					%>
					<input type="text" class="form-control" name="noiDen" value="<%=noiDen %>" maxlength="50">
					<font color=red >Nơi đi, nơi đến của tuyến đã tồn tại  !</font>
			<%
        	  }
        	  else{
        		  if(request.getAttribute("thongbao6")!=null){
        			  noiDen=(String)request.getAttribute("noiDen");
  					%>
  					<input type="text" class="form-control" name="noiDen" value="<%=noiDen %>" maxlength="50">
  					<font color=red >Nơi đi, nơi đến không thể trùng nhau  !</font>
  			<%
  				}
        		  else{
          noiDen=(String)request.getAttribute("noiDen");
          if(noiDen == null ){
        	  noiDen = "";
          }%>
          <input type="text" class="form-control" name="noiDen" value="<%=noiDen %>" maxlength="30">
          <%}}}
		%>
			
          </div>
        </div>
        
        <div class="form-group">
          <div class="col-sm-offset-3 col-sm-10">
            <button type="submit" class="btn btn-info" style="margin-left: 40px;">Thêm tuyến</button>
          </div>
        </div>
      </form>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	
</body>
</html>