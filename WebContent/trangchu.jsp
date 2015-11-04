<%@page import="fpt.fsdn.svtt1213.model.bean.DropdownlistTuyenDuong"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.NguoiDung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Trang chủ</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
	<%@include file="includes/header.jsp" %>
	<div>
	<div class="container">
  <div class="row">
    <!--Tim kiem-->
    <div class="col-md-6 panel panel-info transparent" id="timkiem-trangchu">
      <h3>TÌM KIẾM VÉ XE</h3>
      <form action="TimKiemVeXeServlet" method="post" >
      <div>
      <% ArrayList<DropdownlistTuyenDuong> tuyenDuong = new ArrayList<DropdownlistTuyenDuong>();
      	if(request.getAttribute("tuyenDuong") != null)  
      	{
      		tuyenDuong = (ArrayList<DropdownlistTuyenDuong>)request.getAttribute("tuyenDuong");
    	}%>
        <span>Tuyến đường : </span> <select name="tenTuyen">
        <%for(int i = 0;i<tuyenDuong.size();i++){ %>
                   <option><%=tuyenDuong.get(i).getTenTuyen() %></option>
             <%} %>
                </select>
                <input type="submit" value="Tìm Kiếm" class="btn btn-info" >
		
      </div>
      <div>
      	<div class="col-sm-6">
        	<span>Loại vé : </span> <input type="radio" name="loaiVe" value="motchieu" checked/> Một chiều
        </div>
        <div class="col-sm-6">
                                <input type="radio" name="loaiVe" value="khuhoi"/> Khứ hồi
        </div>

      </div>
      <div>
      	<div class="col-sm-6">
        	<span>Loại xe: </span> <input type="radio" name="loaiXe" value="giuongNam"/> Giường Nằm
        </div>
        <div class="col-sm-6">
                                <input type="radio" name="loaiXe" value="gheNgoi"/> Ghế ngồi
        </div>

      </div>
      <div>
      		<div class="col-sm-6">
		        <span>Số chỗ: </span> <select name="soCho"> 
		                                      <option value="1"> -- Chọn số chỗ -- </option>
		                                      <option value="16">16</option>
		                                      <option value="20">20</option>
		                                      <option value="30">30</option>
		                                      <option value="46">46</option>
		                                    </select> 
          </div>
          <div class="col-sm-6">
		         <span>Giá tiền: </span> <select name="giaVe">
		                                      <option value="1"> -- Chọn giá vé -- </option>
		                                      <option value="2">Dưới 200000</option>
		                                      <option value="3">200000 - 400000</option>
		                                      <option value="4">400000 - 600000</option>
		                                      <option value="5">Trên 600000</option>
		                                    </select>vnđ
           </div>                         

      </div>
      <div>
       <div class="col-sm-6"><span>Ngày đi: </span> <input type="text" size="15" readonly="readonly" id="datepicker" name="ngayDi" value="<%if(request.getAttribute("currentDate")!=null) out.print((String)request.getAttribute("currentDate"));%>"></div>
                                    
		<div class="ngayve" class="col-sm-6"><span>Ngày về: </span> <input type="text" size="15" readonly="readonly" id="ngayve" name="ngayVe"></div>
      </div>
      </form>
    </div><!--end tim kiem-->
	
     <div class="col-md-6">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
          </ol>

          <!-- Wrapper for slides -->
          <div class="carousel-inner">
            <div class="item active">
              <img src="images/2.jpg" alt="sdvdfv">
            </div>
             <div class="item">
              <img src="images/3.jpg" alt="fgbfgb">
            </div>
             <div class="item">
              <img src="images/4.JPG" alt="bfgb">
            </div>
             <div class="item">
              <img src="images/5.jpg" alt="bfgb">
            </div>
          </div>

          <!-- Controls -->
          <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
          </a>
          <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
        </div>
     </div>
  </div>


  <!--bang gia -->
  <div class="row">
    <div class="col-md-2 thumbnail price">
      <div class="caption">
        <h4>Đà Nẵng - Nha Trang</h4>
        <p>450.000 VND</p>
      </div>
    </div>
    <div class="col-md-2 thumbnail price">
       <div class="caption">
        <h4>Đà Nẵng - Sài Gòn</h4>
        <p>450.000 VND</p>
      </div>
    </div>
    <div class="col-md-2 thumbnail price">
      <div class="caption">
        <h4>Đà Nẵng - Hài Nội</h4>
        <p>450.000 VND</p>
      </div>
    </div>
    <div class="col-md-2 thumbnail price">
      <div class="caption">
        <h4>Đà Nẵng - Nha Trang</h4>
        <p>450.000 VND</p>
      </div>
    </div>
    <div class="col-md-2 thumbnail price">
       <div class="caption">
        <h4>Đà Nẵng - Hải Phòng</h4>
        <p>450.000 VND</p>
      </div>
    </div>

  </div>

  <div class="row">
    <div class="col-md-2 thumbnail price">
      <div class="caption">
        <h4>Đà Nẵng - Hải Dương</h4>
        <p>450.000 VND</p>
      </div>
    </div>
    <div class="col-md-2 thumbnail price">
       <div class="caption">
        <h4>Đà Nẵng - Thái Bình</h4>
        <p>450.000 VND</p>
      </div>
    </div>
    <div class="col-md-2 thumbnail price">
      <div class="caption">
        <h4>Đà Nẵng - Bình Dương</h4>
        <p>450.000 VND</p>
      </div>
    </div>
    <div class="col-md-2 thumbnail price">
      <div class="caption">
        <h4>Đà Nẵng - Hưng Yên</h4>
        <p>450.000 VND</p>
      </div>
    </div>
    <div class="col-md-2 thumbnail price">
       <div class="caption">
        <h4>Đà Nẵng - Cần Thơ</h4>
        <p>450.000 VND</p>
      </div>
    </div>

  </div>
  </div><!--end container-->
</div>


	<%@include file="includes/footer.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			
			//hien thi ngay ve khi chon khu hoi	
			var check = $("input[name='loaiVe']:checked").val();
			if(check == "khuhoi"){
				$(".ngayve").css({"display": "inline","display":"block"});
			}else{
				$(".ngayve").css("display","none");
			}
			
			//hien thi ngay ve khi chon khu hoi	
			$("input[name='loaiVe']").click(function(){
				var check = $("input[name='loaiVe']:checked").val();
				if(check == "khuhoi"){
					$(".ngayve").css({"display": "inline","display":"block"});
				}else{
					$(".ngayve").css("display","none");
				}
			});
		});
	</script>
</body>
</html>