<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int phanQuyen;
if(session.getAttribute("phanQuyen") != null){
	phanQuyen = Integer.parseInt(session.getAttribute("phanQuyen").toString());
}else{
	phanQuyen = 0;
}

if(phanQuyen != 89){
	response.sendRedirect("TrangChuServlet");
}
%>