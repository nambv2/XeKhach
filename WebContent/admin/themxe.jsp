<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="fpt.fsdn.svtt1213.model.bean.ChuyenXe"%><html>
<head>
<title>Thêm Xe</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">

<link href="../${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<%
	if (request.getAttribute("BienSoXe") == null
			|| request.getAttribute("loaiXe") == null
			|| request.getAttribute("SoChoNgoi") == null) {
%>
<style type="text/css">
.ghengoi {
	display: none;
}
</style>

<%
	}
%>


</head>
<body>
	<%@include file="../includes/admin_header.jsp"%>

	<%
		if (request.getAttribute("BienSoXe") == null
				|| request.getAttribute("loaiXe") == null
				|| request.getAttribute("SoChoNgoi") == null) {
	%>
	<style type="text/css">
.ghengoi {
	display: none;
}
</style>

	<%
		}
	%>

	<div class="col-md-9" id="themxe">
		<h3>Thêm xe</h3>
		<form id="frm-themtuyen" class="form-horizontal"
			action="${pageContext.request.contextPath}/ThemXeServlet"
			method="post" role="form">



			<div class="form-group">
				<label for="inputmatuyen" class="col-sm-3 control-label">Biển
					số xe : (*) </label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="bienSoXe"
						value="<%if (request.getAttribute("BienSoXe") != null)
				out.print(request.getAttribute("BienSoXe"));%>">
				</div>
				<label class=note> <%
 	if ("TonTai".equals(request.getAttribute("message"))) {
 		out.print("Xe đã tồn tại");
 	} else if ("Error".equals(request.getAttribute("message"))) {
 		out.print("Vui lòng nhập đúng biển số xe");
 	}
 %></label>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">Loại xe : (*) </label>
				<div class="col-sm-3">
					<select name="loaiXe">
						<option value="Giường Nằm"
							<%if ("Giường Nằm".equals(request.getAttribute("LoaiXe")))
				out.print("selected");%>>Giường
							Nằm</option>
						<option value="Ghế Ngồi"
							<%if ("Ghế Ngồi".equals(request.getAttribute("LoaiXe")))
				out.print("selected");%>>Ghế
							Ngồi</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputmatuyen" class="col-sm-3 control-label">Số
					chỗ ngồi : (*) </label>
				<div class="col-sm-3">
					<select name="soChoNgoi">
						<%
							if ("Giường Nằm".equals(request.getAttribute("LoaiXe"))) {
						%>

						<option class='giuongnam' value="43"
							<%if ("43".equals(request.getAttribute("SoChoNgoi")))
					out.print("selected");%>>43</option>
						<option class='giuongnam' value="51"
							<%if ("51".equals(request.getAttribute("SoChoNgoi")))
					out.print("selected");%>>51</option>
						<option class='ghengoi' value="26">26</option>
						<option class='ghengoi' value="30">30</option>
						<option class='ghengoi' value="34">34</option>

						<%
							} else if ("Ghế Ngồi".equals(request.getAttribute("LoaiXe"))) {
						%>


						<option class='ghengoi' value="26"
							<%if ("26".equals(request.getAttribute("SoChoNgoi")))
					out.print("selected");%>>26</option>
						<option class='ghengoi' value="30"
							<%if ("30".equals(request.getAttribute("SoChoNgoi")))
					out.print("selected");%>>30</option>
						<option class='ghengoi' value="34"
							<%if ("34".equals(request.getAttribute("SoChoNgoi")))
					out.print("selected");%>>34</option>
						<option class='giuongnam' value="43">43</option>
						<option class='giuongnam' value="51">51</option>
						<%
							} else {
						%>
						<option class='giuongnam' value="43">43</option>
						<option class='giuongnam' value="51">51</option>
						<option class='ghengoi' value="26">26</option>
						<option class='ghengoi' value="30">30</option>
						<option class='ghengoi' value="34">34</option>

						<%
							}
						%>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" name="them" value="them" class="btn btn-info">Thêm</button>
				</div>
			</div>
		</form>
	</div>

	<%@include file="../includes/admin_footer.jsp"%>

	<script type="text/javascript">
		$(document).ready(function() {
			$("select[name='loaiXe']").change(function() {
				var a = $(this).val();
				if (a == "Giường Nằm") {

					$(".ghengoi").css({
						"display" : "none"
					});
					$(".giuongnam").css({
						"display" : "block"
					});
					$(".giuongnam:first").attr("selected", "selected");
				} else if (a == "Ghế Ngồi") {

					$(".giuongnam").css({
						"display" : "none"
					});
					$(".ghengoi").css({
						"display" : "block"
					});
					$(".ghengoi:first").attr("selected", "selected");
				}
			});
		});
	</script>





</body>
</html>