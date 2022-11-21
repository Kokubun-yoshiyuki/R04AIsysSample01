<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
 		<title>Sentiment Request</title>
 	</head>
 	
 	<body>
  		<h1>Cognitive Serviceを使うサイト</h1>
  		<h3>あなたの感情を教えてください</h3>
  		
  		<form method="POST" action="./sentimentResult">
   			<input type="TEXT" name="string" />
   			<input type="submit" />
  		</form>
 	</body>
</html>