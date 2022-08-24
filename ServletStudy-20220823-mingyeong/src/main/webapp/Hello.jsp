<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	// 선언식 (메소드도 선언 가능)
	String name = "김준일";
	// List<String> nameList = new ArrayList<String>(); 이 자리에 선언을 할 경우 호출을 다시 했을 때 다시 add가 일어난다.
%>

<%
	// 스크립틀릿
	List<String> nameList = new ArrayList<String>();
	
	nameList.add("김준일");
	nameList.add("조문기");
	nameList.add("박소영");
	nameList.add("서재호");
	nameList.add("신승한");
	nameList.add("이승환");
	nameList.add("최연호");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, th, td {
	text-align: center;
	border-collapse: collapse;
	
	border: 1px solid #bdbdbd;
	}
	
	th, td {
	width: 60px;
	height: 30px;
	}
	
	</style>
</head>

<body>
	<h1>hello jsp!</h1>
	<label>이름 : </label><%=name %>
	<%
		for(int i = 0; i < 10; i++) {
	%>
	<label>이름 : </label><%=name %><br>
	<%		// 태그들은 이어지며 중간에 선언을 끼워넣을 수 있다.
		}
	%>
	
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
<%
		for(int i = 0; i < nameList.size(); i++) {
%>
		<tr>
			<td><%=i + 1 %></td>
			<td><%= nameList.get(i) %></td>
		</tr>
<%
		}
%>
		
	</table>
</body>
</html>