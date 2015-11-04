<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.Xe"%><html>
<head>
	<title>Danh Sách xe</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

    
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	
	<%if("xoaok".equals(request.getAttribute("message"))){ %>
		<script type="text/javascript">
		alert("Bạn vừa xóa thành công!");
		</script>
		
	<% }%>
		
		
	<div class="col-md-9" id="danhsachxe">
        
        <table class="table table-hover">
          <caption><h3>Danh sách xe của công ty</h3></caption>
          <thead>
            <th>Biển số xe</th>
            <th>Loại xe</th>
            <th>Số chỗ ngôi</th>
            <th>Tùy chọn</th>
          </thead>
           <tbody>
          <% ArrayList<Xe> listXe = new ArrayList<Xe>();
             if(request.getAttribute("ListXe") != null){
            	 listXe = (ArrayList<Xe>) request.getAttribute("ListXe");
            	 for(int i = 0; i < listXe.size(); i++){
          %>
         <tr>
            <td><%=listXe.get(i).getBienSoXe() %></td>
            <td><%=listXe.get(i).getLoaiXe() %></td>
            <td><%=listXe.get(i).getSoCho() %></td>
            <td>
            <a  href="CapNhatXeServlet?bienSoXe=<%=listXe.get(i).getBienSoXe() %>">Cập nhật</a>/

			<a href="#" name="<%=listXe.get(i).getBienSoXe() %>" class="xoaxe">Xóa</a>              
            </td>
		</tr>
          <%}} %>
           </tbody>
        </table>
        
        <a class="btn btn-info" href="ThemXeServlet">Thêm</a>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	
      <script language="JavaScript" type="text/javascript">
      $(document).ready(function(){
    	  $(".xoaxe").click(function(){
    		  var bienSoXe = $(this).attr("name");
   		  if(confirm("Xóa xe sẽ làm thay đổi các bảng dữ liệu khác. Bạn chắc chắn muốn xóa xe?")){
    		  		 $.ajax({
    		     			type: "POST",
    		      			url: "XoaXeServlet",
    		    	    			data: "bienSoXe="+bienSoXe,
    		   	    			success: function(){
    		   	    				alert("Xoá thành công");
    		      				window.location.href="DanhSachXeServlet";
    		  	    			}
    		   	    		 });
    		     		  
   		  }
    	});
      });
		
</script>
	
</body>
</html>