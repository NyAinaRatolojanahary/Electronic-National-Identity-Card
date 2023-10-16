<%-- 
    Document   : AddPerson
    Created on : 11 oct. 2023, 22:46:29
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Commune"%>
<%Commune c  = new Commune();%>
<% ArrayList<Commune> cm  = c.getAllCommune();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout Personne</title>
    </head>
    <body>
        <form action="./AddPerson" method="post">
        <input type="text" name="name" placeholder="Nom">
        <input type="text" name="firstname" placeholder="Prenom">
        <input type="date" name="birthday">
        <select name="commune">
            <% for(int i=0; i<cm.size(); i++){%>
                <option value="<% out.print(cm.get(i).getId());%>"><% out.print(cm.get(i).getNomCommune());%></option>
            <% }%>
        </select>
        <input type="text" name="location" placeholder="addresse">
        <select name="gender">
            <option value="1">Male</option>
            <option value="0">Female</option>
        </select>
        <input type="submit" value="Enregistrer">
    </form>
    </body>
</html>
