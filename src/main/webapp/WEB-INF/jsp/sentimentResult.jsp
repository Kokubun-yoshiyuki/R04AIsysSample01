<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<% float positive = (float) request.getAttribute("positive"); %>
	<% float neutral = (float) request.getAttribute("neutral"); %>
	<% float negative = (float) request.getAttribute("negative"); %>
	<body>
		<H1>Sentiment</H1>
		<h3>positive: <%= positive * 100%>%</h3>
		<h3>neutral: <%= neutral * 100%>%</h3>
		<h3>negative: <%= negative * 100%>%</h3>
	</body>
</html>