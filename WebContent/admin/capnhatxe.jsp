<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="fpt.fsdn.svtt1213.model.bean.Xe"%><html>
<head>
	<title>Cập Nhật Xe</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
     <link href="../${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="../${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

	<%Xe xe = new Xe(); 
	if(request.getAttribute("Xe") != null){
		xe = (Xe) request.getAttribute("Xe");
	}
	%>
	
	<%if("Giường Nằm".equals(xe.getLoaiXe().trim())){%>
	<style type="text/css">
		.ghengoi{display: none;}
	</style>
	
	<%}else if("Ghế Ngồi".equals(xe.getLoaiXe().trim())){%>
	<style type="text/css">
		.giuongnam{display: none;}
	</style>
	<%} %>		

</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	
	
	
	
	
	
	<div class="col-md-9"  id="themxe">
        <h3>Cập nhật xe</h3>
       <form id="frm-themtuyen" class="form-horizontal" action="CapNhatXeServlet"
       method="post" role="form">
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Biển số xe : (*) </label>
          <div class="col-sm-3">
          <input type="hidden" name="bienSoXe" value="<%=xe.getBienSoXe() %>">
          </input>
           <label><%=xe.getBienSoXe() %></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">Loại xe : (*) </label>
          <div class="col-sm-3">
            <select name="loaiXe">
              <option value="Giường Nằm" <%if("Giường Nằm".equals(xe.getLoaiXe().trim()))
            	  								out.print("selected");
            	  %>>Giường Nằm</option>
              <option value="Ghế Ngồi" <%if("Ghế Ngồi".equals(xe.getLoaiXe().trim()))
            	  								out.print("selected");
            	  %>
              >Ghế Ngồi</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Số chỗ ngồi : (*) </label>
          <div class="col-sm-3">
          <select name="soChoNgoi">
          	<% if("Giường Nằm".equals(xe.getLoaiXe())){%>
	          	<option class='giuongnam' value="43" <%if("43".equals(xe.getSoCho())) 
	          		out.print("selected"); %>>43</option>
	          	<option class='giuongnam' value="51" <%if("51".equals(xe.getSoCho())) 
	          		out.print("selected"); %>>51</option>
	          	<option class='ghengoi' value="26">26</option>
				<option class='ghengoi' value="30">30</option>
				<option class='ghengoi' value="34">34</option>
	          
          	<% } if("Ghế Ngồi".equals(xe.getLoaiXe())){%>
	          	<option value="26" class='ghengoi'<%if("26".equals(xe.getSoCho())) 
	          		out.print("selected"); %>>26</option>
	          	<option value="30" class='ghengoi' <%if("30".equals(xe.getSoCho())) 
	          		out.print("selected"); %>>30</option>
	          	<option value="34" class='ghengoi' <%if("34".equals(xe.getSoCho())) 
	          		out.print("selected"); %>>34</option>
	          	<option class='giuongnam' value="43">43</option>
				<option class='giuongnam' value="51">51</option>
          	<% }       	%>
          	
          </select>
          
          </div>
        </div>
        
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" name="capnhat" value="capnhat" class="btn btn-info">Cập nhật</button>
          </div>
        </div>
      </form>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("select[name='loaiXe']").change(function(){
			var a = $(this).val();
			if(a == "Giường Nằm"){
				
				$(".ghengoi").css({"display":"none"});
				$(".giuongnam").css({"display":"block"});
				$(".giuongnam:first").attr("selected","selected");
			}else if(a == "Ghế Ngồi"){
				 
				$(".giuongnam").css({"display":"none"});
				$(".ghengoi").css({"display":"block"});
				$(".ghengoi:first").attr("selected","selected");
			}
		});
	});
</script>
	
</body>
</html>