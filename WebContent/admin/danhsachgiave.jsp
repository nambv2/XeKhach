<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.GiaVe"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%><html>
<head>
	<title>Danh sách giá vé</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
      <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

	<%@include file="../includes/admin_header.jsp" %>
	
	<div class="col-md-9" id="danhsachgiave">
        <h3>Danh sách giá vé</h3>
        <form  action="DanhSachGiaVeServlet" method="post" class="form-horizontal" role="form">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">Tìm theo tuyến</label>
            <div class="col-sm-5">
              <select type="text" id="matuyen" name="matuyen">
              <option value="null">------------------Chọn tất cả----------------------</option>
              
               <%
               
           ArrayList<TuyenDuong> arr;
            if(request.getAttribute("tuyen")!= null){
             arr = (ArrayList<TuyenDuong>)request.getAttribute("tuyen");
             for(int i = 0; i< arr.size(); i++){
            %>
             <option value="<%=arr.get(i).getMaTuyen() %>" 
             <%
                if(request.getAttribute("giaVe") != null){
                	GiaVe giaVe= (GiaVe) request.getAttribute("giaVe");
             	  if(giaVe.getMaTuyen().equals(arr.get(i).getMaTuyen())){
             		out.print("selected");
             		}
             	   }
              	if(request.getAttribute("matuyen") != null){
              	  String maTuyen=(String)request.getAttribute("matuyen");
              	  if(maTuyen.equals(arr.get(i).getMaTuyen())){
              		out.print("selected");
              		}
              	   }
             %>
             
             >
             <%=arr.get(i).getNoiDi()+"-"+arr.get(i).getNoiDen()%></option>
            <%
             }
            }
            %>
              </select>
            </div>
            <div class="col-sm-2">
              <button type="submit" class="btn btn-info">Tìm</button>
            </div>
            <div>
            
            <% 
            if("ok".equals(request.getAttribute("themOK"))&&request.getAttribute("themOK")!=null){%>
           <label style="color: green">THÊM THÀNH CÔNG</label> 
            <%}
            
            if("ok".equals(request.getAttribute("xoaOK"))&&request.getAttribute("xoaOK")!=null){%>
            <label style="color: green">XÓA THÀNH CÔNG</label>
            <%}
            if("ok".equals(request.getAttribute("capnhat"))&&request.getAttribute("capnhat")!=null){%>
           <label style="color: green">CẬP NHẬT THÀNH CÔNG</label>
            <%} %>
            </div>
          </div>
        </form>
        <table class="table table-hover">
          <thead>
            <th>Mã tuyến</th>
            <th>Biển số xe</th>
            <th>Giá vé</th>
            <th>Giảm giá vé khứ hồi</th>
            <th>Tùy chọn</th>
          </thead>
          <tbody>
           <% 
             if(request.getAttribute("giaVe")!=null){
		    GiaVe giaVe= (GiaVe) request.getAttribute("giaVe");%>
			
			<tr>
				<td><%=giaVe.getMaTuyen()%></td>
				<td><%=giaVe.getBienSoXe()%></td>
				<td><%=giaVe.getGiaVe()%></td>
				<td><%=giaVe.getGiamGiave()%></td>
              <td><a href="CapnhatGiaVeServlet?maTuyen=<%=giaVe.getMaTuyen() %>&bienSoXe=<%=giaVe.getBienSoXe() %>">Cập nhật</a> / 
             <a href="XoaGiaVeServlet?maTuyen=<%=giaVe.getMaTuyen() %>&bienSoXe=<%=giaVe.getBienSoXe() %> " onclick="xoa('${pageContext.request.contextPath}/XoaGiaVeServlet'); return false">Xóa</a> </td>
              <script language="JavaScript" type="text/javascript">
			function xoa(url) {
			var returnValue = confirm("Bạn có muốn xóa giá vé này không ?");
                if(returnValue == true)
                {
                	var maTuyen = document.forms[0].giaVe.get(i).getBienSoXe().value;
					location.href = url; 
                    alert("Bạn đã xóa thành công.");
                }
                
				}
			</script>
              </tr>
              <%}
			%>
            
            <% 
             if(request.getAttribute("giave")!=null){
		ArrayList<GiaVe> giaVe = (ArrayList<GiaVe>) request.getAttribute("giave");
			for(int i=0;i<giaVe.size();i++){%>
			<tr>
				<td><%=giaVe.get(i).getMaTuyen()%></td>
				<td><%=giaVe.get(i).getBienSoXe()%></td>
				<td><%=giaVe.get(i).getGiaVe()%></td>
				<td><%=giaVe.get(i).getGiamGiave()%></td>
              <td><a href="CapnhatGiaVeServlet?maTuyen=<%=giaVe.get(i).getMaTuyen() %>&bienSoXe=<%=giaVe.get(i).getBienSoXe() %>">Cập nhật</a> / 
             <a href="XoaGiaVeServlet?maTuyen=<%=giaVe.get(i).getMaTuyen() %>&bienSoXe=<%=giaVe.get(i).getBienSoXe() %> " onclick="xoa('${pageContext.request.contextPath}/XoaGiaVeServlet'); return false">Xóa</a> </td>
              <script language="JavaScript" type="text/javascript">
			function xoa(url) {
			var returnValue = confirm("Bạn có muốn xóa giá vé này không ?");
                if(returnValue == true)
                {
                	var maTuyen = document.forms[0].giaVe.get(i).getBienSoXe().value;
					location.href = url; 
                    alert("Bạn đã xóa thành công.");
                }
                
				}
			</script>
              </tr>
              <%}
			} %>
            
          </tbody>
        </table>
        <a class="btn btn-info" href="ThemGiaVeServlet_1">Thêm</a>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	
</body>
</html>