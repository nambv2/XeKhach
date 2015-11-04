<%@page import="fpt.fsdn.svtt1213.model.bean.DatVe"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Hoàn tất đặt vé</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
	<%@include file="includes/header.jsp" %>
	<%
		if(request.getAttribute("thongtindatve") != null){
			ArrayList<DatVe> arr = (ArrayList<DatVe>) request.getAttribute("thongtindatve");
			session.setAttribute("datve", arr);
			%>
		
	<div class="container">
		<div class="col-md-9 col-md-offset-2 panel oanel-default" id="danhsachve">
        <h3 style="margin-left: 352px">Chi tiết vé</h3>
        <form class="form-horizontal" role="form">
         
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-5 control-label">Họ tên :</label>
		    <div class="col-sm-7">
		      <label class='thongtin'><%=arr.get(0).getHoTen() %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-5 control-label">Giới tính :</label>
		    <div class="col-sm-7">
		      <label class='thongtin'><% if(arr.get(0).getGioiTinh() == 1) out.print("Nam"); else  out.print("Nữ");%></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-5 control-label">Quê quán :</label>
		    <div class="col-sm-7">
		      <label class='thongtin'><%=arr.get(0).getQueQuan() %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-5 control-label">Số điện thoại :</label>
		    <div class="col-sm-7">
		      <label class='thongtin'><%=arr.get(0).getSoDienThoai() %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-5 control-label">Số CMND :</label>
		    <div class="col-sm-7">
		      <label class='thongtin'><%=arr.get(0).getSoCMND() %></label>
		    </div>
		  </div>
		  
		  
		  <table class="table table-hover">
			<thead>
				<th>Tên tuyến</th>
				<th>Thời gian đi</th>
				<th>Loại xe</th>
				<th>Số chỗ ngồi</th>
				<th>Vị trí ghế</th>
				<th>Giá vé</th>
			</thead>
			<tbody>
			<%
				for(int i = 0; i < arr.size(); i++){
					
					%>
					<tr>
						<td><%=arr.get(i).getTuyenDuong() %></td>
						<td><%=arr.get(i).getThoiGianDi() %></td>
						<td><%=arr.get(i).getLoaiXe()%></td>
						<td><%=arr.get(i).getSoChoNgoi()%></td>
						<td><%=arr.get(i).getViTriNgoiDat()%></td>
						<td><%=arr.get(i).getGiaVe()%></td>
					</tr>
					<%
				
				}
			%>
				
			</tbody> 
		  </table>
		  
		  
		  
		  <div class="form-group">
		    <div class="col-sm-offset-3 col-sm-2">
		      <button type="button" class="btn btn-default" id="chapnhan">Chấp nhận đặt vé</button>
		    </div>
		    <div class="col-sm-offset-1 col-sm-4">
		      <a  class="btn btn-default" id="huy">Hủy đặt vé</a>
		    </div>
		  </div>
		</form>
        
    </div>
		
	</div>
		<%
		}
	%>
	<%@include file="includes/footer.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#chapnhan").click(function(){
				$.ajax({
					type: "POST",
					url: "DatVeServlet",
					data: "trangThai=chapnhan",
					success: function(){
						alert("Đặt vé thành công, vui lòng quí khách đến công ty thanh toán !");
							window.location.href="TimKiemVeXeServlet";
						
					},
					error: function(){
						alert("Có lỗi, vui lòng kiểm tra thông tin !");
					}
				});
			});
			
			$("#huy").click(function(){
				$.ajax({
					type: "POST",
					url: "DatVeServlet",
					data: "trangThai=huy",
					success: function(){
						if(confirm("Đã hủy thành công !")){
							window.location.href="TimKiemVeXeServlet";
						}
					},
					error: function(){
						alert("Lỗi hủy đặt vé !");
					}
				});
			});
		});
	</script>
</body>
</html>