<%@page import="fpt.fsdn.svtt1213.model.bean.BaoCao"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Báo Cáo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
	
	<%@include file="../includes/admin_header.jsp" %>
	<div class="col-md-9"  id="baocao">
        <h3>BÁO CÁO SỐ LƯỢNG KHÁCH ĐI CỦA MỖI TUYẾN</h3>
       <form class="form-inline" role="form" action="BaoCaoServlet" method="post">
		  <div class="form-group col-sm-2">
		    <label class=" control-label" for="exampleInputEmail2">Chọn năm từ :</label>
		  </div>
		  <div class="form-group col-sm-1">
		    <select name="namTu">
		    <%
		    	if(request.getAttribute("namDau") != null){
		    		int namDau = Integer.parseInt((String) request.getAttribute("namDau"));
		    		Calendar now = Calendar.getInstance(); 
		    		int hienTai = now.get(Calendar.YEAR);
		    		for(int i = namDau; i <= hienTai; i++){
		    			%>
		    			<option value="<%=i%>" <%if((String.valueOf(i)).equals((String) request.getAttribute("namTu"))) out.print("selected"); %>><%=i %></option>
		    			<%
		    		}
		    	}
		    %>
		    	
		    </select>
		  </div>
		   <div class="form-group col-sm-1">
		    <label class="control-label" for="exampleInputEmail2">đến :</label>
		  </div>
		  <div class="form-group col-sm-1">
		   <select name="namDen">
		    <%
		    	if(request.getAttribute("namDau") != null){
		    		int namDau = Integer.parseInt((String) request.getAttribute("namDau"));
		    		Calendar now = Calendar.getInstance(); 
		    		int hienTai = now.get(Calendar.YEAR);
		    		for(int i = namDau; i <= hienTai; i++){
		    			%>
		    			<option value="<%=i%>" <%if((String.valueOf(i)).equals((String) request.getAttribute("namDen"))) out.print("selected"); %>><%=i %></option>
		    			<%
		    		}
		    	}
		    %>
		    	
		    </select>
		  </div>
		  <div class="form-group col-sm-1">
		    <button type="submit" class="btn btn-default" value="hienthi" name="hienthi">Hiển thị</button>
		  </div>
		</form>
		<%
		if(request.getAttribute("baocao") != null){
			//kiem tra co bao nhieu nam duoc hien thi
			ArrayList<BaoCao> arr = (ArrayList<BaoCao>) request.getAttribute("baocao");
			int namTu = Integer.parseInt((String) request.getAttribute("namTu"));
			int namDen = Integer.parseInt((String) request.getAttribute("namDen"));
			if(namTu == namDen){
		%>
			<table class="table table-hover" style="overflow: auto;">
			  <thead>
			  	<th>Mã tuyến</th>
			  	<th>Tên tuyến</th>
			  	<th><%=namTu %></th>
			  </thead>
			  <tbody>
			  <%
			  	for(int i = 0; i < arr.size(); i++){
			  		%>
			  			<tr>
					  		<td><%=arr.get(i).getMaTuyen() %></td>
					  		<td><%=arr.get(i).getTenTuyen() %></td>
					  		<td><%=arr.get(i).getTiLeNam()[0] %>%</td>
					  	</tr>
			  		<%
			  	}
			  %>
			  	
			  </tbody>
			</table>
		<%
			}else{
				//lay so nam
				int soNam = namDen - namTu + 1;
				%>
				<table class="table table-hover" style="overflow: auto;">
				  <thead>
				  	<th>Mã tuyến</th>
				  	<th>Tên tuyến</th>
				  	<%
				  	for(int i = namTu; i <= namDen; i++){
				  		%>
				  		<th><%=i %></th>
				  		<%
				  	}
				  	%>
				  </thead>
				  <tbody>
				  <%
				  	for(int i = 0; i < arr.size(); i++){
				  		%>
				  			<tr>
						  		<td><%=arr.get(i).getMaTuyen() %></td>
						  		<td><%=arr.get(i).getTenTuyen() %></td>
						  		<%
						  		for(int j = 0; j < soNam; j++){
						  			%>
						  			<td><%=arr.get(i).getTiLeNam()[j] %>%</td>
						  			<%
						  		}
						  		%>
						  		
						  	</tr>
				  		<%
				  	}
				  %>
				  	
				  </tbody>
				</table>
				<%
			}
		}
		%>
		
		
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	<%
	if(request.getAttribute("error") != null){
		%>
		<script type="text/javascript">
			alert("Năm chọn không hợp lệ");
		</script>
		<%
	}
	%>
</body>
</html>