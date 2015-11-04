<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags' %>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>


<!doctype html>
<html lang='nl'>
<head><v:head title='Brouwers'/></head>

<body>
<v:menu/>

<h1>Alles over brouwers</h1>
<img id="indexbier" alt="Bier hier" src='<c:url value="/images/biertap.jpg"/>'/>
<h2><fmt:message key="${groeten}"/></h2> 

</body>
</html> 