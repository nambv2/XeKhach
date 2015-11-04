<%@page import="java.util.Date"%>
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
<body >
	<%ArrayList<QuanLyVe> data = (ArrayList<QuanLyVe>)request.getAttribute("data");	
	  int maVe = Integer.parseInt(request.getAttribute("maVe").toString());
	  request.setAttribute("maVe", maVe);
	  %>
	  
	  
	  
	<%@include file="includes/header.jsp" %>
	<div class="container">
		<div class="col-md-9 col-md-offset-2 panel oanel-default" id="danhsachve">
        <h3>Chi tiết vé</h3>
        <%
        if(request.getAttribute("thongbao1") != null){
      		  %>
      		  <p align="center"><font color="Red">Mã vé không tồn tại !</font></p>
      		  <% 
        }
        else{
        	if(request.getAttribute("thongBao")!=null){ %>
        <center><font color="red">Không thể hủy vé đã thanh toán</font></center>
        <%} %>
        <form action="${pageContext.request.contextPath}/QuanlyveServlet?maVe=<%=maVe %>"  class="form-horizontal" role="form" method="post">
        <%
        for(int i = 0; i < data.size(); i++){ %>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Tên tuyến :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'><%=data.get(i).getNoiDi() %>-<%=data.get(i).getNoiDen() %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Thời gian đi :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'><%=data.get(i).getThoiGianDi()%></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Loại xe :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'><%=data.get(i).getLoaiXe()%></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Vị trí ngồi :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'><%=data.get(i).getViTriNgoi() %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Tổng tiền :</label>
		    <div class="col-sm-8">
		      <label class='thongtin'><%=data.get(i).getTongTien() %></label>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="inputEmail3" class="col-sm-4 control-label">Thời gian còn lại thanh toán :</label>
		     <div class="col-sm-8">
		      <label class='thongtin' id="bp_count_down_div">

		      
<% 
String thangDatVe = data.get(i).getThangDatVe();
int ngayDatVe = data.get(i).getNgayDatVe();
	  int namDatVe = data.get(i).getNamDatVe();
	  String thangDi = data.get(i).getThangDi();
int ngayDi = data.get(i).getNgayDi();
int namDi = data.get(i).getNamDi();

if(data.get(i).getNgayDatVe() == 0){
		      out.print("Đã thanh toán ");
		      }
		      else {
		    	  if(ngayDi-ngayDatVe<=2){
		    	      %>
				      <script language="JavaScript">
				      
		var bp_date_now = new Date("<%=thangDatVe%> <%=ngayDatVe%>,<%=namDatVe%> 00:00:00");// ngay di
		var bp_date_target = new Date("<%=thangDi%> <%=ngayDatVe%>,<%=namDatVe%> 02:00:00"); 
		var bp_count_down_complete_message = "Hết thời gian thanh toán";
		if (bp_date_now >= bp_date_target) { document.getElementById("bp_count_down_div").innerHTML = bp_count_down_complete_message; } 
		else 
		{ bp_time_difference = Math.floor(((bp_date_target - bp_date_now).valueOf()) / 1000); 
		display_time_difference(bp_time_difference); 
		}
		function display_time_difference(bp_time_difference) { if (bp_time_difference <= 0) { document.getElementById("bp_count_down_div").innerHTML = bp_count_down_complete_message; return; } bp_count_down_message = bp_format_seconds(bp_time_difference, 86400, 100000) + " Ngày, " + bp_format_seconds(bp_time_difference, 3600, 24) + " : " + bp_format_seconds(bp_time_difference, 60, 60) + " : " + bp_format_seconds(bp_time_difference, 1, 60) + " "; document.getElementById("bp_count_down_div").innerHTML = bp_count_down_message; setTimeout("display_time_difference(" + (bp_time_difference - 1) + ")", 1000); } function bp_format_seconds(secs, num1, num2) { num = ((Math.floor(secs / num1)) % num2).toString(); if (num.length < 2) s = "0" + num; return "" + num + ""; } 
		</script><%
		    	  }
		    	  else if(ngayDi-ngayDatVe >2){
		      %>
		      <script language="JavaScript">
var bp_date_now = new Date("<%=thangDatVe%> <%=ngayDatVe%>,<%=namDatVe%> 00:00:00");// ngay di
var bp_date_target = new Date("<%=thangDi%> <%=ngayDi-2%>,<%=namDi%> 00:00:00"); 
var bp_count_down_complete_message = "Hết thời gian đặt vé";
if (bp_date_now >= bp_date_target) { document.getElementById("bp_count_down_div").innerHTML = bp_count_down_complete_message; } 
else 
{ bp_time_difference = Math.floor(((bp_date_target - bp_date_now).valueOf()) / 1000); 
display_time_difference(bp_time_difference); 
}
function display_time_difference(bp_time_difference) { if (bp_time_difference <= 0) { document.getElementById("bp_count_down_div").innerHTML = bp_count_down_complete_message; return; } bp_count_down_message = bp_format_seconds(bp_time_difference, 86400, 100000) + " Ngày, " + bp_format_seconds(bp_time_difference, 3600, 24) + " : " + bp_format_seconds(bp_time_difference, 60, 60) + " : " + bp_format_seconds(bp_time_difference, 1, 60) + " "; document.getElementById("bp_count_down_div").innerHTML = bp_count_down_message; setTimeout("display_time_difference(" + (bp_time_difference - 1) + ")", 1000); } function bp_format_seconds(secs, num1, num2) { num = ((Math.floor(secs / num1)) % num2).toString(); if (num.length < 2) s = "0" + num; return "" + num + ""; } 
</script>

<%} 
		    	  } %>
</label>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-3 col-sm-2">
		    	<input type="hidden" id="id-maVe" value="<%=maVe %>">
		      <button type="button" class="btn btn-default" name="huy" value="huy" id="huy">Hủy</button>
		   
		    </div>
		    <div class="col-sm-offset-1 col-sm-4">
		      <button type="submit" class="btn btn-default" name="huy" value="troVe">Trở về</button>
		    </div>
		  </div>
		  <%}
        
     }
        %>
		</form>
        
    </div>
		
	</div>
	
	<%@include file = "includes/footer.jsp" %>
	
	<script language = "JavaScript" type="text/javascript">
	 		$(document).ready(function(){
				$("#huy").click(function(){
					if(confirm("Bạn có muốn hủy vé này không ?")){
						var maVe = $("#id-maVe").val();
						window.location.href="HuyVeServlet?maVe="+maVe;
						//alert("Bạn đã hủy thành công .");
					}
					else{
						alert("Thao tác đã bị hủy .");
				}
				});
		 	});
	</script>
</body>
</html>