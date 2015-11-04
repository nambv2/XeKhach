<%@page import="fpt.fsdn.svtt1213.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Danh Sach Nhan Vien</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="../${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	
	<div class="col-md-9" id="danhsachnhanvien">
        <h3>Danh sách nhân viên</h3>
        <form class="form-horizontal" role="form" action="TimKiemNhanVienServlet" method="post">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Tìm kiếm</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="inputEmail3" name="hoTen" value="<%if(request.getAttribute("hoTen")!=null) out.print((String)request.getAttribute("hoTen"));%>">
            </div>
            <div class="col-sm-2">
              <button type="submit" class="btn btn-info">Tìm</button>
              
            </div>
	       <%
			if(request.getAttribute("kohople")!=null){
				%>
				    <span ><label for="inputEmail3" id="message" style="color: red;font-size: 15px;font-weight: normal; " class="error">Nhập sai!</label></span>
				<%
			}
			if(request.getAttribute("kotontai")!=null){
				%>
				    <span ><label for="inputEmail3" id="message" style="color: red;font-size: 15px;font-weight: normal; " class="error">Không tìm thấy nhân viên này</label></span>
				<% 
			}
			if(request.getAttribute("themThanhCong")!=null){
				%>
			 		<span ><label for="inputEmail3" id="message" style="color: green;font-size: 20px;font-weight: bold;" class="error">Thêm thành công</label></span>
				<% 
			}
			if(request.getAttribute("capNhatThanhCong")!=null){
				%>
			 		<span ><label for="inputEmail3" id="message" style="color: green;font-size: 20px;font-weight: bold;" class="error">Cập nhật thành công</label></span>
				<% 
			}
			%>
          </div>
        </form>
        <table class="table table-hover">
          <thead>
            <th>Mã nhân viên</th>
            <th>Họ tên</th>
            <th>Giới tính</th>
            <th>Số điện thoại</th>
            <th>Số CMND</th>
            <th>Vị trí</th>
            <th>Tùy chọn</th>
          </thead>
          <tbody>
          
          <%if(request.getAttribute("kotontai")==null){
        	  if(session.getAttribute("nhanvien")!=null){
          		ArrayList<NhanVien> nhanvien = new ArrayList<NhanVien>();
            	nhanvien = (ArrayList<NhanVien>) session.getAttribute("nhanvien");
            	for(int i = 0; i<nhanvien.size();i++){
          %>
            <tr>
              <td><%=nhanvien.get(i).getMaNhanVien()%></td>
              <td><%=nhanvien.get(i).getHoTen()%></td>
              <td><%if("1".equals(nhanvien.get(i).getGioiTinh())) out.print("Nam");
              		else out.print("Nữ");%></td>
              <td><%=nhanvien.get(i).getDienThoai() %></td>
              <td><%=nhanvien.get(i).getCMND() %></td>
              <td><%if("1".equals(nhanvien.get(i).getViTri())) out.print("Tài xế");
              		else out.print("Phụ xe");%></td>
              <td><a href="TimKiemCapNhatNhanVienServlet?i=<%=nhanvien.get(i).getMaNhanVien()%>">Cập nhật</a> / <a class="xoa" name="<%=nhanvien.get(i).getMaNhanVien()%>" href="#">Xóa</a></td>
            </tr>  
            	<%}
            	}
        	  }%>    
          </tbody>
          <%if(session.getAttribute("nhanvien")!=null){
        	 session.removeAttribute("nhanvien");
          } %>
        </table>
        <ul class="pagination">
          <li><a href="#">&laquo;</a></li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li><a href="#">&raquo;</a></li>
        </ul>
        <a href="admin/themnhanvien.jsp" class="btn btn-info" >Thêm</a>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$(".xoa").click(function(){
				if(confirm("Bạn có chắc chắn muốn xóa nhân viên này?")){
					var maNhanVien = $(this).attr("name");
					$.ajax({
						type: "post",
						url: "XoaNhanVienServlet",
						data: "maNhanVien="+maNhanVien,
						success: function(){
							alert("Xóa thành công !");
							window.location.href="DanhSachNhanVienServlet";
						},
						error: function(){
							alert("Xóa thất bại vì nhân viên này không tồn tại trong cơ sở dữ liệu !");
							window.location.href="DanhSachNhanVienServlet";
						}
					});
				}
				
			});
		});
	</script>
</body>
</html>