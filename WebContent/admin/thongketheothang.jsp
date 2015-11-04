<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Thống kê theo tháng</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	
	<div class="col-md-9"  id="thongkethang">
        <h3>Thống kê số lượng khách theo từng tháng</h3>

        <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/ThongKeTheoThangServlet" method="post">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-3 control-label">Chọn năm</label>
            <div class="col-sm-9">
              <select name="nam">
                <option value="2010" <%if("2010".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2010</option>
                <option value="2011" <%if("2011".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2011</option>
                <option value="2012" <%if("2012".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2012</option>
                <option value="2013" <%if("2013".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2013</option>
                <option value="2014" <%if("2014".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2014</option>
                <option value="2015" <%if("2015".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2015</option>
                <option value="2016" <%if("2016".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2016</option>
                <option value="2017" <%if("2017".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2017</option>
                <option value="2018" <%if("2018".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2018</option>
                <option value="2019" <%if("2019".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2019</option>
                <option value="2020" <%if("2020".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2020</option>
                <option value="2021" <%if("2021".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2021</option>
                <option value="2022" <%if("2022".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2022</option>
                <option value="2023" <%if("2023".equals((String) request.getAttribute("nam"))) out.print("selected"); %>>2023</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-primary" name="hienthi" value="hienthi">Hiển thị</button>
            </div>
          </div>
        </form>

        <!--hien thi bieu do-->
        <div id="thongketheothang"></div>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	<%
	if(request.getAttribute("thang") != null){
		float[] tile = (float[]) request.getAttribute("thang");
	%>
	
	<!-- javascript thong ke -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Tháng', 'tỉ lệ đặt'],
          ['1',  <%=tile[0]*100%>],
          ['2',  <%=tile[1]*100%>],
          ['3',  <%=tile[2]*100%>],
          ['4',  <%=tile[3]*100%>],
          ['5',  <%=tile[4]*100%>],
          ['6',  <%=tile[5]*100%>],
          ['7',  <%=tile[6]*100%>],
          ['8',  <%=tile[7]*100%>],
          ['9',  <%=tile[8]*100%>],
          ['10',  <%=tile[9]*100%>],
          ['11',  <%=tile[10]*100%>],
          ['12',  <%=tile[11]*100%>],

          
        ]);

        var options = {
          title: '',
          hAxis: {title: 'Thống kê tỉ lệ đặt vé theo từng tháng', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('thongketheothang'));
        chart.draw(data, options);
      }
    </script>
    
    <%
	}
	%>
</body>
