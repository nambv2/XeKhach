<%@page import="java.util.Date"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Thống kê theo tuyến</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	<div class="col-md-9"  id="thongketuyen">
        <h3>Thống kê số lượng khách theo tuyến</h3>
        <form class="form-horizontal" action="ThongKeTheoTuyenServlet" method="post">
          <div class="form-group" style="width: 700px; margin-left: 114px; margin-bottom: 30px;">
            <label for="inputEmail3" class="col-sm-3 control-label">Chọn tuyến</label>
            <div class="col-sm-9">
              <select name="maTuyen">
	              <%
	              if(request.getAttribute("tuyen") != null) {
	            	  ArrayList<TuyenDuong> arr = (ArrayList<TuyenDuong>) request.getAttribute("tuyen");
	            	  for(int i = 0; i< arr.size(); i++){
	            	%>
	            	<option value="<%=arr.get(i).getMaTuyen()%>" 
	            			<%
	            			//kiem tra selected
	            			if(request.getAttribute("maTuyen") != null){
	            				String maTuyen = (String) request.getAttribute("maTuyen");
	            				if(maTuyen.equals(arr.get(i).getMaTuyen())) out.print("selected");
	            			} %>
	            			>
	            	
	            	<%String tenTuyen = arr.get(i).getNoiDi()+" - "+arr.get(i).getNoiDen(); out.print(tenTuyen); %>
	            	
	            	</option>
	            	
	            	<%
	            	  }
	              }
	              %>
                
              </select>
            </div>
          </div>
          <div class="form-group" style="width: 700px;">
            <label for="inputEmail3" class="col-sm-3 control-label">Thời gian </label>
            <div class="col-md-9">
              <div class="form-group">
                 <label for="inputEmail3" class="col-sm-3 control-label">Từ :</label>
                 <div class="col-sm-3">
                    <input readonly="readonly" type="text" class="form-control col-sm-4 datepicker" id="thoiGianTu" name="thoiGianTu" 
                    	   value="<%if(request.getAttribute("thoiGianTu") != null) {
                    			 String thoiGianTu = String.valueOf(request.getAttribute("thoiGianTu"));
                    	   out.print(thoiGianTu) ;
                    	   }%>"> 
                 </div>

                 <label for="inputEmail3" class="col-sm-3 control-label">đến :</label>
                 <div class="col-sm-3">
                    <input readonly="readonly" type="text" class="form-control col-sm-4 datepicker" id="thoiGianDen" name="thoiGianDen"
                    		 value="<%if(request.getAttribute("thoiGianDen") != null) {
                    			 String thoiGianDen = String.valueOf(request.getAttribute("thoiGianDen"));
                    	   out.print(thoiGianDen) ;
                    	   }%>"
                    		 >
                 </div>
              </div>
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-4 col-sm-8">
              <button type="submit"  style="margin-left: 30px;" class="btn btn-primary" value="hienthi" name="hienthi">Hiển thị</button>
            </div>
          </div>
        </form>

        <!--hien thi bieu do-->
        <div id="thongketheotuyen" style="margin-left: 30px"></div>
    </div>
	
	<%@include file="../includes/admin_footer.jsp" %>
	<%
	if(request.getAttribute("empty") != null){
		%>
		<script type="text/javascript">
			alert("Vui lòng nhập đầy đủ khoảng thời gian !");
		</script>
		<%
	}
	
	if(request.getAttribute("invalid") != null){
		%>
		<script type="text/javascript">
			alert("Khoảng thời gian không hợp lệ !");
		</script>
		<%
	}
	%>
	
	
	
	
	<%
	float t = 0;
	if(request.getAttribute("tile") != null){
		t = (Float) request.getAttribute("tile");
	%>
	<script type="text/javascript">
	    // Load the Visualization API and the piechart package.
	    google.load('visualization', '1.0', {'packages':['corechart']});
	
	    // Set a callback to run when the Google Visualization API is loaded.
	    google.setOnLoadCallback(drawChart);
	
	    // Callback that creates and populates a data table,
	    // instantiates the pie chart, passes in the data and
	    // draws it.
	    function drawChart() {
	
	      // Create the data table.
	      var data = new google.visualization.DataTable();
	      data.addColumn('string', 'Topping');
	      data.addColumn('number', 'Slices');
	      data.addRows([
	        ['Ghế ngồi', <%=t*10%>],
	        ['Ghế trống', <%=10-t*10%>]
	      ]);
	
	      // Set chart options
	      var options = {'title':'',
	                     'width':700,
	                     'height':600};
	
	      // Instantiate and draw our chart, passing in some options.
	      var chart = new google.visualization.PieChart(document.getElementById('thongketheotuyen'));
	      chart.draw(data, options);
	    }
	</script> 
	<%} %>
</body>
</html>