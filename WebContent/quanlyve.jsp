<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.QuanLyVe"%><html>
<head>
	<title>Trang Chu</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
	<%ArrayList<QuanLyVe> data= (ArrayList<QuanLyVe>)request.getAttribute("data");%>
	<%@include file="includes/header.jsp" %>
	<div class="container">
		<div class="col-md-9 col-md-offset-2 panel panel-default" id="danhsachve">
        <h3>Danh sách vé</h3>
        
        <table class="table table-hover">
          <thead>
            <th>Tên tuyến</th>
            <th>Thời gia đi</th>
            <th>Tổng tiền</th>
            <th>Thanh toán</th>
            <th>Chi tiết</th>
          </thead>
           <tbody>
             <tr>
              <% for (int i = 0; i < data.size(); i++) { %>
            <tr>
            <td><%=data.get(i).getNoiDi()%>-<%=data.get(i).getNoiDen() %></td>
            <td><%=data.get(i).getThoiGianDi()%></td>
            <td><%=data.get(i).getTongTien()%></td>
            <td><%
            if(data.get(i).getTrangThai() == 1){
            	out.print("Đã thanh toán");
            }
            else{
            	out.print("Chưa");
            }%></td>
			<td><a href="${pageContext.request.contextPath}/ChiTietVeServlet?maVe=<%=data.get(i).getMaVe()%>">Xem</a></td>
            
            </tr>
         <% } %>

          </tbody>
        </table>
    </div>
		
	</div>
	
	<%@include file="includes/footer.jsp" %>
</body>
</html>