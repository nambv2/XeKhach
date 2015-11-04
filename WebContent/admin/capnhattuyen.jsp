<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Cập nhật tuyến</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>

	
	<div class="col-md-9" id="themtuyen">
        <h3>Cập nhật tuyến đường</h3>
       <form action="CapnhattuyenServlet" class="form-horizontal" method="post" style="margin-left: 78px;">
       	<%
    	
    	ArrayList<String> error = new ArrayList<String>();
    	if(request.getAttribute("thongBao")!=null){
    		String maTuyen = "";
        	String noiDi = "";
        	String noiDen = "";
    	}
    	else{
    		String maTuyen = (String)request.getAttribute("maTuyen");
        	String noiDi = (String)request.getAttribute("noiDi");
        	String noiDen = (String)request.getAttribute("noiDen");
    	
    	if(request.getAttribute("error") != null){
    		error = (ArrayList<String>) request.getAttribute("error");
    	}
    	
       	%>
              	
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Mã tuyến : (*) </label>
          <div class="col-sm-4">
            <input type="text" class="form-control" id="inputmatuyen" value="<%=maTuyen %>" readonly="readonly" name="maTuyen">
          </div>
          <div align="center">
       			<label class="note"><% 
						if( error != null){
							for(int i = 0; i < error.size(); i++ ){
								if("TrungTen".equals(error.get(i))){
									out.print("Nơi đi và nơi đến trùng nhau");
								}else if("TuyenDuongDaCo".equals(error.get(i))){
									out.print("Tuyến đường này đã tồn tại");
								}}}
						
					%></label>
			</div>
        </div>
         <div class="form-group">
          <label class="col-sm-3 control-label">Nơi đi : (*) </label>
          <div class="col-sm-4">
           
					<input type="text" class="form-control" name="noiDi" value="<%=noiDi %>" maxlength="50">
					<label class="note"><% 
						if( error != null){
							if("".equals(noiDi)){
								out.print("Vui lòng nhập nơi đi");
							}else{
							for(int i = 0; i < error.size(); i++ ){
								
								if("LoiNoiDi".equals(error.get(i))){
									out.print("Vui lòng nhập đúng định dạng");
								}
							
						}
						}}
					%></label>
					
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">Nơi đến : (*) </label>
          <div class="col-sm-4">
           
					<input type="text" class="form-control" name="noiDen" value="<%=noiDen %>" maxlength="50">
					<label class="note"><% 
						if( error != null){
							if("".equals(noiDen)){
								out.print("Vui lòng nhập nơi đến");
							}else{
							for(int i = 0; i < error.size(); i++){
								
								if("LoiNoiDen".equals(error.get(i))){
									out.print("Vui lòng nhập đúng định dạng");
								}
							
						}
						}}}
					%></label>
					
          </div>
        </div>
        
        <div class="form-group">
          <div class="col-sm-offset-3 col-sm-10">
            <button type="submit" class="btn btn-info" name="submit" value="submit" style="margin-left: 40px;">Cập nhật</button>
          </div>
        </div>
      </form>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
</body>
</html>