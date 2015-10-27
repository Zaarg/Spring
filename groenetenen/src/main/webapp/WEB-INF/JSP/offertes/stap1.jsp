<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>

<!doctype html>
<html lang='nl'> 
<head>
<v:head title='Aanvraag offerte (stap 1)'/>
</head> 
<body>
<v:menu/>
<h1>Aanvraag offerte</h1>
<h2>Stap 1</h2>
<c:url value='/offertes' var='url'/>
<form:form action='${url}' commandName='offerte'>
	<form:label path='voornaam'>Voornaam:<form:errors path='voornaam'/></form:label>
	<form:input path='voornaam' autofocus='true' required='required'/>
	<form:label path='familienaam'>Familienaam:
	<form:errors path='familienaam'/></form:label> 
	<form:input path='familienaam' required='required'/>
	<form:label path='emailAdres'>E-mail adres:
	<form:errors path='emailAdres'/></form:label>
	<form:input path='emailAdres' required='required' type='email'/>
	<input type='submit' value='Volgende stap' name='van1naar2'>
</form:form> 
</body>
</html> 