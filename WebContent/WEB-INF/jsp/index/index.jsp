<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Utilizando taglib core c do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brendo projeto</title>
</head>
<body>

	<c:forEach items="${pessoas}" var="pessoa"> 
		${pessoa.nome}
	</c:forEach>
</body>
</html>