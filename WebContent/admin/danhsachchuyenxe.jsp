<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.ChuyenXe"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%><html>
<head>
	<title>Danh sách chuyến xe</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    
    <link href="../${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="../${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	
	<%if("ok".equals(request.getAttribute("message"))) {
	%>
	<script type="text/javascript">alert("Cap Nhat OK");</script>
	<%} %>
	
	<%if(request.getAttribute("message")!=null) 
	{%>
	<script type="text/javascript">
	alert("Bạn vừa thêm tài khoản thành công!!");
	</script>
	<%} %>
	<%if(request.getAttribute("message")== "xoaok") 
	{%>
	<script type="text/javascript">
	alert("Xóa chuyến xe thành công!!");
	</script>
	<%} %>
	<div class="col-md-9" id="danhsachchuyen">
        <h3>Danh sách chuyến xe</h3>
       <form class="form-inline" role="form" 
       			action="DanhSachChuyenServlet" method="post">
          <div class="form-group">
            <label for="exampleInputEmail2">Chọn tuyến : </label>
          </div>
          <div class="form-group">
            <select name="maTuyen">
             <option value="all" >------- Tất cả --------</option>
            <% 
            	ArrayList<TuyenDuong> listTuyen;
            if(request.getAttribute("TuyenDuong") !=null){
            	listTuyen=(ArrayList<TuyenDuong>) request.getAttribute("TuyenDuong");
            	for(int i=0;i<listTuyen.size();i++)
				{      
            %>
              <option value="<%=listTuyen.get(i).getMaTuyen()%>" 
              						<%
              						if(request.getAttribute("maTuyen") != null){
              							String maTuyen=(String)request.getAttribute("maTuyen");
              							if(maTuyen.equals(listTuyen.get(i).getMaTuyen())){
              								out.print("selected");
              							}
              						}
             						%>>
             							 <%=listTuyen.get(i).getTuyenDuong()%>
             </option>
            
              <%}    }%>
            </select>
          </div>
          <button type="submit" class="btn btn-info">Tìm</button>
        </form>

        <table class="table table-hover">
          <thead>
            <th>Mã chuyến</th>
            <th>Tuyến đường</th>
            <th>Thời gian đi</th>
            <th>Thời gian về</th>
            <th>Xem</th>
          </thead>
          <% ArrayList<ChuyenXe> chuyenXe;
          if( request.getAttribute("ChuyenXe")!=null)
          {  chuyenXe =(ArrayList<ChuyenXe>) request.getAttribute("ChuyenXe"); 
           	 for(int i=0;i<chuyenXe.size();i++)
         	 {
          %>
          
          <tbody>
            <td><%=chuyenXe.get(i).getMaChuyen() %></td>
            <td><%=chuyenXe.get(i).getTuyenDuong() %></td>
            <td><%=chuyenXe.get(i).getThoiGianDi() %></td>
            <td><%=chuyenXe.get(i).getThoiGianDen() %></td>
            <td><a href="ChiTietChuyenServlet?maChuyen=<%=chuyenXe.get(i).getMaChuyen() %>">Xem</a></td>
          </tbody>
          
          <%}} %>
        </table>
      
        
      	<button class="btn btn-info" onclick="window.location.href='ThemChuyenServlet'"> Thêm</button>
       
     
        <ul class="pagination">
          <li><a href="#">&laquo;</a></li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li><a href="#">&raquo;</a></li>
        </ul>
    </div>
	<form action="ChiTietChuyenServlet" id="frmr">
		<input type="hidden" name="maChuyen" id="frm-submit">
	</form>
	<%@include file="../includes/admin_footer.jsp" %>
	
	<script type="text/javascript">
	function xem(maTuyen){
		document.getElementById("frm-submit").value=maTuyen;
		document.getElementById("frmr");
	}
	</script>
</body>
</html>