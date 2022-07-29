<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<jsp:include page="./inc/_style.jsp"/>

</head>
<body>
<jsp:include page="./inc/_header.jsp"/>
<jsp:include page="./inc/_menu.jsp"/>


<main>


<form action="/demo1/api/User" method="POST">
	<input type="text" name="nom">
	<input type="text" name="prenom">
	<input type="submit" value="envoyer">

</form>


<input type="button" value="Recup" id="get">
</main>



 <jsp:include page="/WEB-INF/pages/inc/_footer.jsp"/>
 
 
 <script>
 
	 document.querySelector('#get').addEventListener('click',()=>{
			 fetch("/demo1/api/User")
			 .then((response) => response.json())
			 .then((data)=>{
				console.log(data); 
			 });
	});

 
 </script>
</body>
</html>