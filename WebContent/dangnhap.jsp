<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Đăng nhập</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="includes/header.jsp" %>
	<div class="container">
	<div class="col-md-offset-3 col-md-6 panel panel-info" id="dangnhap">
			<h3>Đăng Nhập</h3>
			<h4 class="error" id="message"><%if(request.getAttribute("message") != null) out.print((String)request.getAttribute("message")); %></h4>
			<form class="form-horizontal" role="form" action="DangNhapServlet" method="post">
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">Tên đăng nhập</label>
                <div class="col-sm-7">
                  <input type="text" class="form-control" id="inputEmail3" name="tenDangNhap" value="<%if(request.getAttribute("tenDangNhap") != null) out.print((String) request.getAttribute("tenDangNhap"));%>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-3 control-label">Mật khẩu</label>
                <div class="col-sm-7">
                  <input type="password" class="form-control" id="inputPassword3" name="matKhau">
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-4 col-sm-10">
                  <input type="submit" class="btn btn-default" value="Đăng nhập">
                </div>
              </div>
            </form>
           </div>
	</div>
	
	<%@include file="includes/footer.jsp" %>
</body>
</html>