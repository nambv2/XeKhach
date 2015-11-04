<%@page import="fpt.fsdn.svtt1213.model.bean.DatVe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Chọn vị trí ngồi</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="includes/header.jsp" %>
	<div class="container" id="loadxe">
	
			<div class="col-md-12" >
			<%
			if(request.getAttribute("thongTinChuyen") != null){
			
				DatVe thongTinChuyen = (DatVe) request.getAttribute("thongTinChuyen");
				int[] viTri = (int[]) request.getAttribute("viTri");
				
				int soGhe = thongTinChuyen.getSoChoNgoi();
				if("Giường Nằm".equals(thongTinChuyen.getLoaiXe())){
					int tang = (soGhe - 1)/2;
					int day = (tang - 5)/2;
					%>
					<div id="giuongnam">
					<div  class="tang">
						    <div class="btn btn-success"></div> Đã đặt
						    <div class="btn btn-primary"></div> Chưa đặt
						    <div><img src="images/volang.jpg" width="60" height="50"></div>
						
						      <div class="dayghe">
						        <%
						      	for(int i = 1; i <= day; i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
							        
						      		<%
						      	}
						      %>
						      </div><!--end dayghe 1-->
						
						      <div class="dayghe" >
						         <%
						      	for(int i = (day + 1); i <= day*2; i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
							        
						      		<%
						      	}
						      %>
						      </div><!--end dayghe 2-->
						
						      <div id="daycuoi" >
						         <%
						      	for(int i = (day*2+1); i <= tang; i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      					
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
						       <%
						       		}
						        %>
						      </div><!--end dayghe 2-->
						      <div class="ten-tang">Tầng 1</div>
						  </div>
						
						<div class="tang" id="tang2">
						  
						    <div id="canhle"></div> 
						 <div class="dayghe">
						        <%
						        int tangStart = (soGhe-1)/2+1;//so ghe bat dau cua tang 2
						        int tang2 = (soGhe-1)/2; //so ghe cua tang 2
						        int day2 = (tang2-5)/2;//so ghe cua moi day, day cuoi 5 ghe
						        
						      	for(int i = tangStart; i < (tangStart+day2); i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
							        
						      		<%
						      	}
						      %>
						      </div><!--end dayghe 1-->
						
						      <div class="dayghe" >
						         <%
						      	for(int i = (tangStart+day2); i <= (tangStart+day2*2-1); i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
							        
						      		<%
						      	}
						      %>
						      </div><!--end dayghe 2-->
						
						      <div id="daycuoi" >
						         <%
						      	for(int i = (tangStart+day2*2); i <= (soGhe-1); i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      					
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
						       <%
						       		}
						        %>
						      </div><!--end dayghe 2-->
						
						       <div class="ten-tang">Tầng 2</div>
						  </div>
				  
					</div><!-- end #giuongnam -->
			
					
					
					<%
				}else{
					int day = (soGhe - 6)/2;
					%>
					
					<div id="ghengoi">
						 <div class="tang">
								    <div class="btn btn-success"></div> Đã đặt
								    <div class="btn btn-primary"></div> Chưa đặt
								    <div><img src="images/volang.jpg" width="60" height="50"></div>
								
								      <div class="dayghe">
								    	 <%
						      	for(int i = 1; i <= day; i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
							        
						      		<%
						      	}
						      %>
						        
								      </div><!--end dayghe 1  -->
								
								      <div class="dayghe" >
								     		  <%
						      
						      	for(int i = (day + 1); i <= (day*2); i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      					
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
							        
						      		<%
						      	}
						      %>
						       
								      </div><!-- day 2 -->
								
								      <div id="daycuoi" >
								       		<%
						      	for(int i = (day*2+1); i <= (soGhe -1); i++){
						      		%>
						      		<a 
						      			<%
						      			int s = 0;
						      			for(int k = 0; k < viTri.length; k++){
						      				if(viTri[k] == i){
						      					s = 1;
						      					break;
						      					
						      				}else{
						      					s = 0;
						      					
						      				}
						      			}
						      		if(s == 1){
						      			%>
				      					class="btn btn-primary dadat"
				      					<%
						      		}else{
						      			%>
				      					class="btn btn-primary ghe"
				      					<%
						      		}
						      			%>
						      		 ><%=i %></a>
							        
						      		<%
						      	}
					
						      %>
								      </div><!-- day cuoi -->
								  </div>
								  
					
					</div>
							
					
					<%
				}
				
			%>
			<form action="">
				<input type="hidden" value="<%=thongTinChuyen.getMaChuyen()%>" name="maChuyen" id="machuyen">
				
			</form>
			<%
			}
			
			%>
			
				      </div>
				      <div class="col-md-offset-2" style="margin-top: 50px;">
				      		<form class="form-horizontal" role="form" id="xuly">
							<div class="form-group">
							    <div class="col-sm-offset-1 col-sm-2">
							      <button type="button" class="btn btn-default" id=hoantat>Hoàn tất</button>
							    </div>
							    <div class="col-sm-offset-4 col-sm-2">
							      <a  class="btn btn-default" id="trove">Trở về</a>
							    </div>
							  </div>
							</form>
				      </div>
				      </div>
				      
	</div>
	
	
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Hướng dẫn chọn vi trí đặt</h4>
      </div>
      <div class="modal-body">
        <div class="huongdan">Quí khách vui lòng nhấp chuột chọn vị trí muốn đặt</div>
        <div class="huongdan">Nhấp đúp chuột để bỏ vị trí đã chọn</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
	
	
	<%@include file="includes/footer.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#myModal").modal();
			
			$(".ghe").click(function(){
				$(this).addClass("thaydoi");
			});
			
			$(".ghe").dblclick(function(){
				$(this).removeClass("thaydoi");
			});
			
			$("#hoantat").click(function(){
				var vitri="";
				$(".thaydoi").each(function(){
					vitri += $(this).html()+",";
				});
				var maChuyen = $("#machuyen").val();
				var loaiVe = $("#loaiVe").val();
				$.ajax({
		            type: "post",
		            url: "DatVeServlet",
		            data: "vitri="+ vitri+"&maChuyen="+maChuyen+"&trangThai=hoantat",
		            success: function(){
		            	history.back();
		            }
		        });
				
			});
			
			$("#trove").click(function(){
		            history.back();
			});
			
			
		});
	</script>
</body>
