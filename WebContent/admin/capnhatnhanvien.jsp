<%@page import="fpt.fsdn.svtt1213.model.bean.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Cap Nhat Nhan Vien</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	
	<div class="col-md-9"  id="themnhanvien">
        <h3>Cập nhật nhân viên</h3>
       <form id="frm-themtuyen" class="form-horizontal" role="form" action="CapNhatNhanVienServlet" method="post">
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Họ tên : (*) </label>
          <div class="col-sm-5">
            <input type="hidden" class="form-control" id="inputmatuyen" name="maNhanVien" value="<%if(request.getAttribute("maNhanVien")!=null) out.print((String)request.getAttribute("maNhanVien"));%>">
            <input type="text" class="form-control" id="inputmatuyen" name="hoTen" value="<%if(request.getAttribute("hoTen")!=null) out.print((String)request.getAttribute("hoTen"));%>">
          </div>
          <%
			if(request.getAttribute("hoTenError")!=null){
				%>
				    <span ><label for="inputEmail3" id="message" style="color: red;font-size: 15px;font-weight: normal;" class="error"> Nhập sai!</label></span>
				<%
			}%>
        </div>
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Giới tính : (*) </label>
          <div class="col-sm-1">
            <input type="radio" class="form-control" name="gioiTinh" value="1" 
            <%if(request.getAttribute("gioiTinh") != null){
              			int gioiTinh = Integer.parseInt((String) request.getAttribute("gioiTinh"));
              			if(gioiTinh == 1) out.print("checked='checked'");
              			
              		} %>>
          </div>
          <label for="inputmatuyen" class="col-sm-1 control-label" >Nam</label>

           <div class="col-sm-1">
            <input type="radio" class="form-control" name="gioiTinh" value="2" 
            <%if(request.getAttribute("gioiTinh") != null){
              			int gioiTinh = Integer.parseInt((String) request.getAttribute("gioiTinh"));
              			if(gioiTinh == 2) out.print("checked='checked'");
              			
              		} %>>
          </div>
          <label for="inputmatuyen" class="col-sm-1 control-label">Nữ</label>
           
        </div>
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Số điện thoại : (*) </label>
          <div class="col-sm-5">
            <input type="text" class="form-control" id="inputmatuyen" name="dienThoai" value="<%if(request.getAttribute("dienThoai")!=null) out.print((String)request.getAttribute("dienThoai"));%>">
          </div>
          <%
			if(request.getAttribute("dienThoaiError")!=null){
				%>
				    <span ><label for="inputEmail3" id="message" style="color: red;font-size: 15px;font-weight: normal;" class="error"> Nhập sai!</label></span>
				<%
			}%>
        </div>
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Quê quán : (*) </label>
          <div class="col-sm-5">
            <input type="text" class="form-control" id="inputmatuyen" name="queQuan" value="<%if(request.getAttribute("queQuan")!=null) out.print((String)request.getAttribute("queQuan"));%>">
          </div>
          <% if(request.getAttribute("queQuanError")!=null){
				%>
				    <span ><label for="inputEmail3" id="message" style="color: red;font-size: 15px;font-weight: normal;" class="error"> Nhập sai!</label></span>
				<%
			}%>
        </div>
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label">Số CMND : (*) </label>
          <div class="col-sm-5">
            <input type="text" class="form-control" id="inputmatuyen" name="CMND" value="<%if(request.getAttribute("CMND")!=null) out.print((String)request.getAttribute("CMND"));%>">
          </div>
           <%
			if(request.getAttribute("CMNDError")!=null){
				%>
				    <span ><label for="inputEmail3" id="message" style="color: red;font-size: 15px;font-weight: normal;" class="error"> Nhập sai!</label></span>
				<%
			}%>
        </div>
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-3 control-label" >Vị trí: (*) </label>
          <div class="col-sm-5">
            <select name="viTri">
              <option value="1" 
              		<%if(request.getAttribute("viTri") != null){
              			int viTri = Integer.parseInt((String) request.getAttribute("viTri"));
              			if(viTri == 1) out.print("selected");
              			
              		} %>>Tài xế</option>
              <option value="2" 
              <%if(request.getAttribute("viTri") != null){
              			int viTri = Integer.parseInt((String) request.getAttribute("viTri"));
              			if(viTri == 2) out.print("selected");
              			
              		} %>>Phụ xe</option>
            </select>
          </div>
        </div>
        
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-info" id="btn-capnhat">Cập nhật</button>
          </div>
          <%if(request.getAttribute("capNhatThatBai")!=null){
				%>
			    <span ><label for="inputEmail3" id="message" style="color: red;font-size: 20px;font-weight: bold; margin-left: 170px" class="error"> Cập nhật thất bại !</label></span>
			<%
		}%>
        </div>
      </form>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	
	
</body>
</html>