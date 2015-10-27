<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags' %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>

<!doctype html>
<html lang='nl'>
<head><v:head title='Brouwer op naam'/></head>

<body>
<v:menu/>

<h1>Brouwer zoeken op alfabet</h1>
<c:url value='/brouwers' var='url'/>
<form:form action='${url}' commandName='beginNaam' method='get'> 
	<form:label path='beginNaam'>Begin brouwernaam: </form:label> <form:errors path='beginNaam'/>
	<form:input path='beginNaam' type='text' required='required' autofocus='autofocus'/> 
	<input type='submit' value='Zoeken'>
	<form:errors cssClass='fout'/> 
</form:form>

<c:if test='${not empty brouwers}'>
    <table>
      <thead>
        <tr>
          <th>Nummer</th><th>Naam</th><th>Straat</th><th>HuisNr.</th><th>Postcode<th>Gemeente</th><th>Omzet</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items='${brouwers}' var='brouwer'>
          <tr>
            <td>${brouwer.brouwerNr}</td>
            <td>${brouwer.naam}</td>
            <td>${brouwer.adres.straat}</td>
            <td>${brouwer.adres.huisNr}</td>
            <td>${brouwer.adres.postcode}</td>
            <td>${brouwer.adres.gemeente}</td>
            <td>${brouwer.omzet}</td>   
          </tr>
        </c:forEach>
      </tbody>
    </table>  
</c:if>

</body>
</html> 