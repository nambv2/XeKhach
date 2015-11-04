<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<html>
<head>
	<title>Trang Chu</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<form action="admin/themtuyen.jsp" method="post">
<%ArrayList<TuyenDuong> data = (ArrayList<TuyenDuong>)request.getAttribute("data");%>
	<%@include file="../includes/admin_header.jsp" %>
	
	<div class="col-md-9" id="danhsachtuyen">
        <h3>Danh sách tuyến đường</h3>
        <table class="table table-hover">
          <thead>
            <th>Mã chuyến</th>
            <th>Nơi đi</th>
            <th>Nơi đến</th>
            <th>Thời gian lập</th>
            <th>Tùy chọn</th>
          </thead>
          <tbody>
             <tr>
              <% for (int i = 0; i < data.size(); i++) { %>
            <tr>
            <td><%=data.get(i).getMaTuyen()%></td>
            <td><%=data.get(i).getNoiDi()%></td>
            <td><%=data.get(i).getNoiDen()%></td>
            <td><%=data.get(i).getNgayLap()%></td>
            <td><a href="${pageContext.request.contextPath}/CapnhattuyenServlet?maTuyen=<%=data.get(i).getMaTuyen() %>">Chỉnh sửa</a> / 
           	<a href="${pageContext.request.contextPath}/XoatuyenServlet?maTuyen=<%=data.get(i).getMaTuyen() %>" onclick="xoa('${pageContext.request.contextPath}/XoatuyenServlet'); return false" >Xóa</a>
            <script language="JavaScript" type="text/javascript">
			function xoa(url) {
			var returnValue = confirm("Bạn có muốn xóa chuyến xe này không ?");
                if(returnValue == true)
                {
                	var maTuyen = document.forms[0].data.get(i).getMaTuyen().value;
					location.href = url; 
                    alert("Bạn đã xóa thành công.");
                }
                else
                {
                    alert("Thao tác được hủy bỏ !");
                }
				}
			</script>
			 
            
            </tr>
         <% } %>

          </tbody>
        </table>
        <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/themtuyen.jsp" style="margin-bottom: 30px">Thêm</a>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	</form>
</body>
</html>