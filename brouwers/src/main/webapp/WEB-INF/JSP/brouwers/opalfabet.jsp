<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags' %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<!doctype html>
<html lang='nl'>
<head><v:head title='Brouwer op naam'/></head>

<body>
<v:menu/>

<h1>Brouwer zoeken op alfabet</h1>

<div id="alfabet">
<c:forTokens items='A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z' delims=',' var='letter'>
	<spring:url var='letterURL' value='/opalfabet/{letter}'>   
  		<spring:param name='letter' value='${letter}'/> 
  	</spring:url>
  	<h2 class="middle"><a href="<c:url value='${letterURL}'/>">${letter}</a></h2>
</c:forTokens>
</div>

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