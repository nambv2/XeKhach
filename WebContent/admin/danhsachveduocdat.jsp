<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.DanhSachVeDuocDat"%><html>
<head>
	<title>Danh sách vé đã đặt</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
<%
ArrayList<TuyenDuong> tuyen=new ArrayList<TuyenDuong>();
ArrayList<DanhSachVeDuocDat> danhsachVe = new ArrayList<DanhSachVeDuocDat> ();
ArrayList<DanhSachVeDuocDat> danhSachVeDat = new ArrayList<DanhSachVeDuocDat> ();
if(request.getAttribute("tuyen")!=null){
	tuyen=(ArrayList<TuyenDuong>)request.getAttribute("tuyen");
}
if(request.getAttribute("danhsachVe")!=null){
	danhsachVe=(ArrayList<DanhSachVeDuocDat>)request.getAttribute("danhsachVe");
	
}
if(request.getAttribute("danhSachVeDat")!=null){
	danhSachVeDat=(ArrayList<DanhSachVeDuocDat>)request.getAttribute("danhSachVeDat");
	
}

%>
	<%@include file="../includes/admin_header.jsp" %>
	<div class="col-md-9"  id="danhsachveduocdat">
        <h3>Danh sách đặt vé của khách hàng</h3>
        <form  action="DanhSachVeDuocDatServlet" method="post" role="form">
       	<div class="row col-sm-12">
       		  <div class="form-group col-sm-2">
			    <label>Tuyến đường</label>
			  </div>
			  <div class="form-group col-sm-4">
			    <select type="text" id="matuyen" name="matuyen">
			    <option value="null">------------------------Tất cả--------------------</option>
			    	<%
         
            if(request.getAttribute("tuyen")!= null){
            	tuyen = (ArrayList<TuyenDuong>)request.getAttribute("tuyen");
             for(int i = 0; i< tuyen.size(); i++){
            %>
             <option value="<%=tuyen.get(i).getMaTuyen() %>" 
             <%
              	if(request.getAttribute("maTuyen") != null){
              	String maTuyen=(String)request.getAttribute("maTuyen");
              	if(maTuyen.equals(tuyen.get(i).getMaTuyen())){
              	out.print("selected");
              	 }
                }
              	
             %>
             ><%
             out.println(tuyen.get(i).getNoiDi()+"-"+tuyen.get(i).getNoiDen()); %></option>
            <%
             }
            }
            %>
			    </select>
			  </div>
       		  <div class="form-group col-sm-offset-1 col-sm-2">
			    <label>Số CMND</label>
			  </div>
			  <div class="form-group col-sm-2">
			    <input type="text" class="form-control" name="CMND" id="CMND" value="<%
			    if(request.getAttribute("CMND")!=null){
			    	out.print(request.getAttribute("CMND"));
			    }
			    %>">
			  </div>
			  <div class="checkbox col-sm-1">
			  			  </div>
       	</div>
       	<div class="row col-sm-offset-7 col-sm-12">
       		  
       	</div>
       	<div class="row">
       		<div class="col-sm-offset-5 col-sm-7">
		  <input type="submit" class="btn btn-info" value="Tìm kiếm">
		    <%
		    if("huy".equals(request.getAttribute("xulyve")) &&request.getAttribute("xulyve")!=null)
		    {
		    %><label style="color: green ">HỦY VÉ THÀNH CÔNG</label>
		    <%} 
		    if("chapnhan".equals(request.getAttribute("xulyve")) &&request.getAttribute("xulyve")!=null)
		    {
		    %><label style="color: green ">VÉ ĐƯỢC CHẤP NHẬN</label><%}
		    %></div>
		    
       	</div>
       	</form>
       	<div class="row">
       		<table class="table table-hover">
			  <thead>
			  	
			  	<th>Tên người đặt</th>
			  	<th>Tên tuyến</th>
			  	<th>Thời gian đi</th>
			  	<th>Biển số xe</th>
			  	<th>Thanh toán</th>
			  	<th>Tùy chọn</th>
			  </thead>
			  <tbody>
			  
			  	<%  		
             if(request.getAttribute("danhsachVe")!=null){
			for(int i=0;i<danhsachVe.size();i++){%>
			<tr>
				
				<td><%=danhsachVe.get(i).getHoTen()%></td>
				<td><%=danhsachVe.get(i).getNoiDi()+'-'+danhsachVe.get(i).getNoiDen() %></td>
				<td><%=danhsachVe.get(i).getThoiGiandi()%></td>
			
				<td><%=danhsachVe.get(i).getBienSoxe()%></td>
				<td><%if(danhsachVe.get(i).getTrangThai()==1){%>
				      Đã thanh toán<%}else {%>Chưa thanh toán<%} %>
				</td>
              <td><a href="ChiTietVeAdminServlet?maVe=<%=danhsachVe.get(i).getMaVe()%>">Xem</a></td>
              </tr>
              <%}
			} %>
			  </tbody>
			</table>
       	</div>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	
	
</body>
</html>