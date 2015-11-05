<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags' %>

<!doctype html>
<html lang='nl'>
<head><v:head title='Geen toegang'/></head> 
<body>
<v:menu/>
<h1>Geen toegang</h1>
<img id="indexbier" alt="Geen bier hier" src='<c:url value="/images/leegbier.jpg"/>'/>
<br>
<p>U hebt geen toegang tot dit onderdeel</p>
</body>
</html> 