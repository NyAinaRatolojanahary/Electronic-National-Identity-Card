<%-- 
    Document   : AddCin
    Created on : 11 oct. 2023, 22:46:52
    Author     : ASUS
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Bean.Commune"%>
<%Commune c  = new Commune();%>
<% ArrayList<Commune> cm  = c.getAllCommune();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout CIN</title>
    </head>
    <body>
        <form action="./AddCin" method="post">
        <input type="text" name="name" placeholder="Nom">
        <input type="text" name="firstname" placeholder="Prenom">
        <input type="date" name="delivery">
        <input type="text" name="job" placeholder="Profession">
        <select name="commune">
            <% for(int i=0; i<cm.size(); i++){%>
                <option value="<% out.print(cm.get(i).getId());%>"><% out.print(cm.get(i).getNomCommune());%></option>
            <% }%>
        </select>
        <input type="submit" value="Enregistrer">
    </form>
    </body>
</html>
