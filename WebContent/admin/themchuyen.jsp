<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="fpt.fsdn.svtt1213.model.bean.TuyenDuong"%><html>
<head>
	<title>Trang Chu</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="../${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css"> <!-- css datepicker -->
</head>
<body>
	<%@include file="../includes/admin_header.jsp" %>
	<% ArrayList<String> listError = new ArrayList<String>();
		if(request.getAttribute("Error") != null){
			listError = (ArrayList<String>) request.getAttribute("Error");
		}		
	%><div align="center">
	 <label style=color:red><% 
          for(int i = 0; i<listError.size();i++)
			{
				if("LoiNgayDi".equals(listError.get(i))){
					out.print("Thời gian đi phải lớn hơn thời gian hiện tại");
					break;
				}else if("LoiNgayDen".equals(listError.get(i))){
					out.print("Thời gian về phải lớn hơn thời gian hiện tại");
					break;
				}else if("DiDen".equals(listError.get(i)) || "LoiTG".equals(listError.get(i))){
					out.print("Vui lòng kiểm tra lại thời gian đi và thời gian về");
					break;
					
				}
			}
          
          %> </label>
          </div>
          
          <div align="center">
	 <label style=color:red><% 
          for(int i = 0; i<listError.size();i++)
			{
				if("TrungMa".equals(listError.get(i))){
					out.print("Trùng mã tài xế 1 và tài xế 2");
				
			}
			}
          %> </label>
          </div>
	<div class="col-md-9"  id="themchuyen">
        <h3>Thêm chuyến xe</h3>
       <form class="form-horizontal" role="form" action="ThemChuyenServlet" method="post">
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-4 control-label">Mã chuyến : (*) </label>
          <div class="col-sm-3">
            <input type="text" name="maChuyen" class="form-control" id="inputmatuyen" 
            value="<% if(request.getAttribute("maChuyen") != null){
            	   out.print(request.getAttribute("maChuyen"));}
            	%>">
          </div>
          <label style=color:red><% 
          for(int i = 0; i<listError.size();i++)
			{
				if("MaTonTai".equals(listError.get(i))){
					out.print("Mã chuyến đã tồn tại");
				}else if("".equals(request.getAttribute("maChuyen"))){
					out.print("Vui lòng nhập mã chuyến"); 
					break;
				}else if("MaChuyen".equals(listError.get(i))){
					out.print("Vui lòng nhập đúng định dạng");
			}
			}
          %> </label>
        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Tên tuyến : (*) </label>
           <div class="form-group">
            <select name="maTuyen">
             
            <% 
            	ArrayList<TuyenDuong> listTuyen;
            if(request.getAttribute("TuyenDuong") !=null){
            	listTuyen=(ArrayList<TuyenDuong>) request.getAttribute("TuyenDuong");
            	for(int i=0;i<listTuyen.size();i++)
				{      
            %>
              <option value="<%=listTuyen.get(i).getMaTuyen()%>" 
              						<%
              						if(request.getAttribute("maTuyen") != null){
              							String maTuyen=(String)request.getAttribute("maTuyen");
              							if(maTuyen.equals(listTuyen.get(i).getMaTuyen())){
              								out.print("selected");
              							}
              						}
             						%>>
             							 <%=listTuyen.get(i).getTuyenDuong()%>
             </option>
            
              <%}    }%>
            </select>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-sm-4 control-label">Thời gian đi : (*) </label>
          <div class="col-md-8">
            <select name="gioDi">
            <% for(int i=0;i<24;i++){ %>
              <option value="<%=i  %>"
              <%if(request.getAttribute("gioDi")!= null){
            	  	String gioDi=(String)request.getAttribute("gioDi");
            	    if(Integer.parseInt(gioDi) == i) out.print("selected");          	  
              }
            	  %>><%
            	  if(i<10) out.print("0"+i);
     				else out.print(i);		%>
            	  </option>
             
             <%} %>
            </select> giờ
            <select name="phutDi">
              <% for(int i=0;i<60;i+=5){ %>
              <option value="<%=i%>"
              <%if(request.getAttribute("phutDi")!= null){
            	  	String gioDi=(String)request.getAttribute("phutDi");
            		if(Integer.parseInt(gioDi) == i) out.print("selected");            	  
              }
            	  %>><%if(i<10) out.print("0"+i);
               				else out.print(i);		%>
               	</option>
             
             <%} %>   </select> phút ; ngày
            <input readonly="readonly" class="datepicker" type="text" size="20" name="ngayDi" value="<%if(request.getAttribute("ngayDi") != null){
            	out.print(request.getAttribute("ngayDi"));
            	}else{
            		out.print(request.getAttribute("Date"));
            	}
            	%>"
            	>
          </div>
        </div>
        
        
        <div class="form-group">
          <label class="col-sm-4 control-label">Thời gian về : (*) </label>
          <div class="col-md-8">
            <select name="gioDen">
            <% for(int i=0;i<24;i++){ %>
             
              <option value="<%=i   %>"
              <%if(request.getAttribute("gioDen")!= null){
            	  	String gioDi=(String)request.getAttribute("gioDen");
            		if(Integer.parseInt(gioDi) == i) out.print("selected");         	  
              }
            	  %>><%
            	  if(i<10) out.print("0"+i);
   					else out.print(i);	
            	  %></option>
             <%} %>
            </select> giờ
            
            <select name="phutDen">
              <% for(int i=0;i<60;i+=5){ %>
              <option value="<%=i%>"
              <%if(request.getAttribute("phutDen")!= null){
            	  	String gioDi=(String)request.getAttribute("phutDen");
            		if(Integer.parseInt(gioDi) == i) out.print("selected");             	  
              }
            	  %>><%if(i<10) out.print("0"+i);
               				else out.print(i);		%>   
               	</option>
             
             
             <%} %>
            </select> phút ; ngày
           <input readonly="readonly"  class="datepicker" type="text" size="20" name="ngayDen" value="<%if(request.getAttribute("ngayDen") != null){
            	out.print(request.getAttribute("ngayDen"));	
            	}else{
            		out.print(request.getAttribute("Date"));
            	}%>"
            		
            	>
          </div>
        </div>
        
        <%ArrayList<String> taiXe = new ArrayList<String>(); 
        	if(request.getAttribute("ListTaiXe")!=null){
        		taiXe= (ArrayList<String>) request.getAttribute("ListTaiXe");
        		%>
        	
			       	 <div class="form-group">
			          <label class="col-sm-4 control-label">Mã tài xế 1 : (*) </label>
			          <div class="col-sm-3">
			            <select name="taiXe1">
			            <%	for(int i=0;i<taiXe.size();i++){%>
			          
			            <option value="<%=taiXe.get(i)%>"  
			            <%if(request.getAttribute("taiXe1")!=null){
			            	String taiXe12=(String) request.getAttribute("taiXe1");
			            	if(taiXe12.equals(taiXe.get(i))){
			            		out.print("selected");
			            	}			            	
			            } %>
			             > <%=taiXe.get(i)%> </option>
			            
			              <%} %>
			            </select>
			          </div>
			      <label style=color:red><% 
		          	for(int i = 0; i<listError.size();i++)
					{
						if("TaiXe1".equals(listError.get(i))){
							out.print("Không thể chọn tài xế này");
						}
					}
         			 %> </label>
			          
			        </div>
        <div class="form-group">
          <label class="col-sm-4 control-label">Mã tài xế 2 : (*) </label>
          <div class="col-sm-3">
            <select name="taiXe2">
                <%	for(int i=0;i<taiXe.size();i++){%>
              <option value="<%=taiXe.get(i)%>"  
			            <%if(request.getAttribute("taiXe2")!=null){
			            	String taiXe12=(String) request.getAttribute("taiXe2");
			            	if(taiXe12.equals(taiXe.get(i))){
			            		out.print("selected");
			            	}			            	
			            } %>
			             > <%=taiXe.get(i)%> </option>
             <%} %>
            </select>
          </div>
          <label style=color:red><% 
		          	for(int i = 0; i<listError.size();i++)
					{
						if("TaiXe2".equals(listError.get(i))){
							out.print("Không thể chọn tài xế này");
						}
					}
         			 %> </label>
        </div>
        <%} %>
        <div class="form-group">
        <%ArrayList<String> phuXe = new ArrayList<String>(); 
        	if(request.getAttribute("ListPhuXe")!=null){
        		phuXe= (ArrayList<String>) request.getAttribute("ListPhuXe");
        		%>
          <label class="col-sm-4 control-label">Mã phụ xe : (*) </label>
          <div class="col-sm-3">
            <select name="phuXe">
              <%for(int i=0;i<phuXe.size();i++){ %>
              
              <option value="<%=phuXe.get(i)%>"  
			            <%if(request.getAttribute("phuXe")!=null){
			            	String taiXe12=(String) request.getAttribute("phuXe");
			            	if(taiXe12.equals(phuXe.get(i))){
			            		out.print("selected");
			            	}			            	
			            } %>
			             > <%=phuXe.get(i)%> </option>
			             
              <%} %>
            </select>
          </div>
          <label style=color:red><% 
		          	for(int i = 0; i<listError.size();i++)
					{
						if("PhuXe".equals(listError.get(i))){
							out.print("Không thể chọn phụ xe này");
						}}
		        %> </label>
        </div>
        <%} %>
        <div class="form-group">
          <label class="col-sm-4 control-label">Biển số xe : (*) </label>
          <div class="col-sm-3">
            <select name="bienSoXe">
            <%ArrayList<String> listXe=new ArrayList<String>(); 
              if(request.getAttribute("ListXe")!=null){
                listXe = (ArrayList<String>) request.getAttribute("ListXe");
                for(int i=0;i<listXe.size();i++){
              %>
              <option value="<%=listXe.get(i)%>"              
              <%if(request.getAttribute("bienSoXe")!=null){
			            	String taiXe12=(String) request.getAttribute("bienSoXe");
			            	if(taiXe12.equals(listXe.get(i))){
			            		out.print("selected");
			            	}			            	
			            } %>
              
              > <%=listXe.get(i)%> </option>
              
              <%}} %>
            </select>
           
          </div>
          <label style=color:red><% 
		          	for(int i = 0; i<listError.size();i++)
					{
						if("Xe".equals(listError.get(i))){
							out.print("Không thể chọn xe này");
						}}
		          
         			 %> </label>
        </div>
        
        <div class="form-group">
          <label for="inputmatuyen" class="col-sm-4 control-label">Tỷ lệ đặt vé online : (*) </label>
          <div class="col-sm-2">
            <input  type="text" class="form-control" name="tiLeOnline"
            value="<%if(request.getAttribute("tiLeOnline") !=null){
            	out.print(request.getAttribute("tiLeOnline"));
            }%>">
                        
          </div>
          <div class="col-sm-1">%</div>
          
          <label style=color:red><% 
		          	for(int i = 0; i<listError.size();i++)
					{   if("".equals(request.getAttribute("tiLeOnline"))){
						out.print("Vui lòng nhập tỉ lệ"); 
						break;
					}else if("TiLe".equals(listError.get(i))){
							out.print("Vui lòng nhập đúng tỉ lệ");
						}}
         			 %> </label>
        </div>
        
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" name="them" value="them" class="btn btn-info">Thêm </button>
          </div>
        </div>
      </form>
    </div>
    	
	<%@include file="../includes/admin_footer.jsp" %>
</body>
</html>