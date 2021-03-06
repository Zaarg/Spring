<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<%@taglib prefix='v' uri='http://vdab.be/tags' %>

<!doctype html>
<html lang='nl'> 
<head>
<v:head title='Filialen per postcode'/>
</head> 

<body>
<v:menu/>

<h1>Filialen per postcode</h1>
<c:url value='/filialen' var='url'/>
<form:form action='${url}' commandName='postcodeReeks' method='get'> 
	<form:label path='vanpostcode'>Van:</form:label> <form:errors path='vanpostcode'/>
	<form:input path='vanpostcode' type='number' min='1000' max='9999' required='required' autofocus='autofocus'/>
	<form:label path='totpostcode'>Tot:</form:label> <form:errors path='totpostcode'/>
	<form:input path='totpostcode' type='number' min='1000' max='9999' required='required'/> 
	<input type='submit' value='Zoeken'>
	<form:errors cssClass='fout'/> 
</form:form>
<c:forEach items='${filialen}' var='filiaal'> 
  <spring:url var='url' value='/filialen/{id}'>
    <spring:param name='id' value='${filiaal.id}'/>
  </spring:url>
  <h2><a href='${url}'>${filiaal.naam}</a></h2>
  <p>${filiaal.adres.straat} ${filiaal.adres.huisNr}<br>
  ${filiaal.adres.postcode} ${filiaal.adres.gemeente}</p>
</c:forEach>

</body>
</html> 