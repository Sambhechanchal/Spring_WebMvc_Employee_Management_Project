<%@ page  isELIgnored="false" import="java.util.*" %>

<h2>Result Page</h2>

<b> Sno:: ${sno}</b>
<br>
<b>Sname :: ${name} </b>
<br>
<b>String format :: ${sadd} </b>
<br>
<b>Array Format :: <%= Arrays.toString((String[])request.getAttribute("saddArr")) %></b>
<br>
<b>Set Format :: ${saddSet} </b>
<br>
<b>List Format :: ${saddList} </b>