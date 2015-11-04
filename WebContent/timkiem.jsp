<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.DropdownlistTuyenDuong"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.KetQuaTimKiemVeXe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.Xe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Tìm kiếm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker --> 
</head>
<body>
	<%@include file="includes/header.jsp" %>
	
	<div class="container">
	<form action="TimKiemVeXeServlet" method="post" class="panel panel-default transparent">
		<div class="row">
		<div class="col-md-offset-3 col-md-6" id="timkiem">
		<% ArrayList<DropdownlistTuyenDuong> tuyenDuong = new ArrayList<DropdownlistTuyenDuong>();
      	if(request.getAttribute("tuyenDuong") != null)  
      	{
      		tuyenDuong = (ArrayList<DropdownlistTuyenDuong>)request.getAttribute("tuyenDuong");
      	}%>
			<h3>TÌM KIẾM VÉ XE</h3>
			
		      <div>
		      	<div class="col-sm-4">
		        	<span>Tuyến đường : </span> 
		        </div>
		        <div class="col-sm-6">
		        	<select name="tenTuyen"
		        	<%for(int i = 0;i<tuyenDuong.size();i++){ out.print(tuyenDuong.get(i).getTenTuyen());%>>
                   		<option <%if(request.getAttribute("tenTuyen") != null){
	              				String tenTuyen = (String) request.getAttribute("tenTuyen");
	              				if(tenTuyen.equals(tuyenDuong.get(i).getTenTuyen())) out.print("selected");
	              				} %>><%=tuyenDuong.get(i).getTenTuyen() %></option>
				    <%} %>
				   </select>
		                                    
				</div>
		      </div>
		      <div>
		      	<div class="col-sm-6">
		        	<span>Loại vé : </span> <input type="radio" name="loaiVe" value="motchieu" 
		        	<%if(request.getAttribute("loaiVe") != null){
		        		String loaiVe = (String) request.getAttribute("loaiVe");
              			if("motchieu".equals(loaiVe)) out.print(" checked");
              		} %>/> Một chiều
		        </div>
		        <div class="col-sm-6">
		                                <input type="radio" name="loaiVe" value="khuhoi" 
		           <%if(request.getAttribute("loaiVe") != null){
              			String loaiVe = (String) request.getAttribute("loaiVe");
              			if("khuhoi".equals(loaiVe)) out.print(" checked");		
              		} %>/> Khứ hồi
		        </div>
		
		      </div>
		      <div>
		      	<div class="col-sm-6">
		        	<span>Loại xe: </span> <input type="radio" name="loaiXe" value="giuongNam" 
		        	 <%if(request.getAttribute("loaiXe") != null){
              			String loaiVe = (String) request.getAttribute("loaiXe");
              			if("giuongNam".equals(loaiVe)) out.print(" checked");}%>/> Giường Nằm
		        </div>
		        <div class="col-sm-6">
		                <input type="radio" name="loaiXe" value="gheNgoi" 
		                 <%if(request.getAttribute("loaiXe") != null){
              			String loaiVe = (String) request.getAttribute("loaiXe");
              			if("gheNgoi".equals(loaiVe)) out.print(" checked");}%>/> Ghế ngồi
		        </div>
		
		      </div>
		      <div>
		      		<div class="col-sm-6">
				        <span>Số chỗ: </span> <select name="soCho"> 
		                                      <option value="1" <%if(request.getAttribute("soCho") != null){
              														int soCho = Integer.parseInt((String) request.getAttribute("soCho"));
              														if(soCho == 1) out.print("selected");
              			
              													} %>> ---- Chọn số chỗ ----- </option>
		                                      				<option value="26"	<%if(request.getAttribute("soCho") != null){
              														int soCho = Integer.parseInt((String) request.getAttribute("soCho"));
              														if(soCho == 26) out.print("selected");
              			
              													} %>>26</option>
              													<option value="30"<%if(request.getAttribute("soCho") != null){
              														int soCho = Integer.parseInt((String) request.getAttribute("soCho"));
              														if(soCho == 30) out.print("selected");
              			
              													} %>>30</option>
              													<option value="34"<%if(request.getAttribute("soCho") != null){
              														int soCho = Integer.parseInt((String) request.getAttribute("soCho"));
              														if(soCho == 34) out.print("selected");
              			
              													} %>>34</option>
              													<option value="43"<%if(request.getAttribute("soCho") != null){
              														int soCho = Integer.parseInt((String) request.getAttribute("soCho"));
              														if(soCho == 43) out.print("selected");
              			
              													} %>>43</option>
              													<option value="51"<%if(request.getAttribute("soCho") != null){
              														int soCho = Integer.parseInt((String) request.getAttribute("soCho"));
              														if(soCho == 51) out.print("selected");
              			
              													} %>>51</option>
				                                    </select> 
		          </div>
		          <div class="col-sm-6">
				         <span>Giá tiền: </span> <select name="giaVe">
		                                      <option value="1" <%if(request.getAttribute("giaVe") != null){
              														int giaVe = Integer.parseInt((String) request.getAttribute("giaVe"));
              														if(giaVe == 1) out.print("selected");
              													} %>> -- Chọn giá vé -- </option>
		                                      <option value="2" <%if(request.getAttribute("giaVe") != null){
              														int giaVe = Integer.parseInt((String) request.getAttribute("giaVe"));
              														if(giaVe == 2) out.print("selected");
              													} %>>Dưới 200000</option>
		                                      <option value="3" <%if(request.getAttribute("giaVe") != null){
              														int giaVe = Integer.parseInt((String) request.getAttribute("soCho"));
              														if(giaVe == 3) out.print("selected");
              													} %>>200000 - 400000</option>
		                                      <option value="4" <%if(request.getAttribute("giaVe") != null){
              														int giaVe = Integer.parseInt((String) request.getAttribute("giaVe"));
              														if(giaVe == 4) out.print("selected");
              													} %>>400000 - 600000</option>
		                                      <option value="5" <%if(request.getAttribute("giaVe") != null){
              														int giaVe = Integer.parseInt((String) request.getAttribute("giaVe"));
              														if(giaVe == 5) out.print("selected"); 
              													} %>>Trên 600000</option>
				                                    </select>vnđ
		           </div>                         
		
		      </div>
		      <div>
		        <div class="col-sm-6"><span>Ngày đi: </span> <input type="text"  size="20" id="datepicker" name="ngayDi" readonly="readonly" value="<%if(request.getAttribute("ngayDi")!=null) out.print((String)request.getAttribute("ngayDi"));%>"></div>                         
				<div class="col-sm-6 ngayve"><span>Ngày về: </span> <input type="text"  size="17" id="ngayve" name="ngayVe" readonly="readonly" value="<%if(request.getAttribute("ngayVe")!=null) out.print((String)request.getAttribute("ngayVe"));%>"></div>
		      	<div>
		      		<%if(request.getAttribute("ngayVeError")!=null){%>
				    <span ><label for="inputEmail3" id="message" style="color: red;font-size: 15px;font-weight: normal;" class="error">Ngày về phải sau ngày đi</label></span>
					<%}%>
				</div>
		      </div>
		</div>
			
		</div><!-- end row 1-->
		<div class="row">
			<div class="col-md-offset-5 col-md-6">
		      	<input type="submit" value="Tìm Kiếm" class="btn btn-info">
		    </div>
		     
		</div><!-- end row -->
		</form> 
		<%
		ArrayList<KetQuaTimKiemVeXe> kqNgayDi = new ArrayList<KetQuaTimKiemVeXe>();
		ArrayList<KetQuaTimKiemVeXe> kqNgayVe = new ArrayList<KetQuaTimKiemVeXe>();
		if(request.getAttribute("loaiVe")!=null) {
			String loaiVe = (String)request.getAttribute("loaiVe");
		
			if(request.getAttribute("ketquaTimKiemNgayDi")!=null){
				kqNgayDi = (ArrayList<KetQuaTimKiemVeXe>) request.getAttribute("ketquaTimKiemNgayDi");
			}
			if("khuhoi".equals(loaiVe)){
				kqNgayVe = (ArrayList<KetQuaTimKiemVeXe>) request.getAttribute("ketquaTimKiemNgayVe");
			}
		%>
		<div class="row hienthi-timkiem">
		<div class="col-md-12">
		<%if(request.getAttribute("ketquaTimKiemNgayDi")!=null){%>
			<table class="table table-hover">
				<caption>Lựa chọn chiều đi</caption>
				<thead>
				  	<th>Loại xe</th>
				  	<th>Ngày xuất bến</th>
				  	<th>Giờ xuất bến</th>
				  	<th>Số chỗ</th>
				  	<th>Trạng thái</th>
				  	<th>Giá vé</th>
				  	<%if("khuhoi".equals(loaiVe)){
					  		%>
					  			<th>Giảm giá</th>
					  		<%
					}%>
				  	<th>Đặt vé</th>
				</thead>
				<tbody>
				
				<%for(int i = 0 ; i < kqNgayDi.size() ; i++){ %>
					<tr>
						<td><%=kqNgayDi.get(i).getLoaiXe()%></td>
					  	<td><%=kqNgayDi.get(i).getNgayDi()%></td>
					  	<td><%=kqNgayDi.get(i).getGioDi()%></td>
					  	<td><%=kqNgayDi.get(i).getSoCho()%></td>
					  	<td><%if(kqNgayDi.get(i).getSoGheDaDat()<kqNgayDi.get(i).getSoCho()) out.print("Còn chỗ");
					  			else out.print("Hết chỗ");%></td>
					  	<td><%=kqNgayDi.get(i).getGiaVe() %></td>
					  	<%if("khuhoi".equals(loaiVe)){
					  		%>
					  			<td><%if(kqNgayDi.get(i).getGiamGia()<0) out.print("Chưa đặt giá"); 
					  							else out.print(kqNgayDi.get(i).getGiamGia()); %></td>
					  		<%
					  	}%>
					  	<td>
					  	<%
					  	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					  	Date now = new Date();//ngay gio hien tai
					  	
					  	String day1 = dateFormat.format(now);
					  	
					  	Date ngayDat;
					  	
					  	ngayDat = dateFormat.parse(day1);
					  	
					  	String dateDi = kqNgayDi.get(i).getNgayDi()+" "+kqNgayDi.get(i).getGioDi();
					  	Date ngayDi = dateFormat.parse(dateDi);
					  	
					  	
					  	if(ngayDat.compareTo(ngayDi) >= 0){
					  		%>
					  		<a href="#" class="chon">Chọn ghế</a>
					  		<%
					  	}else{
					  		%>
					  		<a href="LoadGheNgoiServlet?maChuyen=<%=kqNgayDi.get(i).getMaChuyen()%>" class="dat">Chọn ghế</a>
					  		<%
					  	}
					  	
					  	%>
					  	
					  	</td>
					</tr>
					<%} }%>
			</table>
			<%if(request.getAttribute("ketquaTimKiemNgayVe")!=null){%>
			<table class="table table-hover">
				<caption>Lựa chọn chiều về</caption>
				<thead>
				  	<th>Loại xe</th>
				  	<th>Ngày xuất bến</th>
				  	<th>Giờ xuất bến</th>
				  	<th>Số chỗ</th>
				  	<th>Trạng thái</th>
				  	<th>Giá vé</th>
<!-- 				  	<th>Giảm giá</th> -->
				  	<th>Đặt vé</th>
				</thead>
				<tbody>
				
					<%for(int i = 0 ; i < kqNgayVe.size() ; i++){ %>
					<tr>
						<td><%=kqNgayVe.get(i).getLoaiXe() %></td>
					  	<td><%=kqNgayVe.get(i).getNgayDi()%></td>
					  	<td><%=kqNgayVe.get(i).getGioDi()%></td>
					  	<td><%=kqNgayVe.get(i).getSoCho()%></td>
					  	<td><%if(kqNgayVe.get(i).getSoGheDaDat()<kqNgayVe.get(i).getSoCho()) out.print("Còn chỗ");
					  			else out.print("Hết chỗ");%></td>
					  	<td><%=kqNgayVe.get(i).getGiaVe()%></td>
<%-- 					  	<td><%if(kqNgayVe.get(i).getGiamGia()<0) out.print("Chưa đặt giá");  --%>
<%-- 					  							else out.print(kqNgayVe.get(i).getGiamGia()); %></td> --%>
					  	<td>
					  	<%
					  	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					  	Date now = new Date();//ngay gio hien tai
					  	
					  	String day1 = dateFormat.format(now);
					  	
					  	Date ngayDat;
					  	
					  	ngayDat = dateFormat.parse(day1);
					  	
					  	String dateDi = kqNgayVe.get(i).getNgayDi()+" "+kqNgayVe.get(i).getGioDi();
					  	Date ngayDi = dateFormat.parse(dateDi);
					  	
					  	
					  	if(ngayDat.compareTo(ngayDi) >= 0){
					  		%>
					  		<a href="#" class="chon">Chọn ghế</a>
					  		<%
					  	}else{
					  		%>
					  		<a href="LoadGheNgoiServlet?maChuyen=<%=kqNgayVe.get(i).getMaChuyen()%>" class="dat">Chọn ghế</a>
					  		<%
					  	}
					  	
					  	%>
					  	</td>
					</tr>
				</tbody>
				<%} }%>
			</table>
			<%}%>
			</div>
			
		</div><!-- end row 2 -->
		
		<!-- Chap nhap dat ve -->
		<form action="">
			<input type="hidden" name="kiemTraChonCho" value="">
			<input type="hidden" name="layNgayDi" value="">
		</form>
		<%
		if((request.getAttribute("ketquaTimKiemNgayDi") != null) || (request.getAttribute("ketquaTimKiemNgayVe") != null)){
			%>
			<form class="form-horizontal" action="DatVeServlet" method="post" id="frm-btn-tieptuc">
              <div class="form-group">
             	
                <div class="col-sm-offset-5 col-sm-7">
                  <input type="hidden" name="trangThai" value="tieptuc">
                  <button type="submit" class="btn btn-primary">Tiếp tục</button>
                </div>
              </div>
            </form>
			<%
		}
		%>
		
		
		
	</div><!-- end container -->
	
	<%
		if(request.getAttribute("error") != null){
			%>
			<script type="text/javascript">
				alert("Vui lòng đăng nhập !");
				window.location.href="dangnhap.jsp";
			</script>
			<%
		}
	%>
	<%
		if(request.getAttribute("chuachon") != null){
			%>
			<script type="text/javascript">
				alert("Vui lòng chọn chỗ ngồi trước !");
			</script>
			<%
		}
	%>
	
	
	<%@include file="includes/footer.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$(".chon").click(function(){
				alert("Đã hết thời gian đặt chuyến này");
			});
			
			
			
	
			$(".dat").click(function(){
				$("input[name='kiemTraChonCho']").val("yes");
			});
				
			
			//hien thi ngay ve khi chon khu hoi	
			var check = $("input[name='loaiVe']:checked").val();
			if(check == "khuhoi"){
				$(".ngayve").css({"display": "inline","display":"block"});
			}else{
				$(".ngayve").css("display","none");
			}
			
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