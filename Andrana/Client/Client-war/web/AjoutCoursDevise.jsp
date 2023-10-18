<%-- 
    Document   : AjoutCoursDevise
    Created on : 16 oct. 2023, 21:33:39
    Author     : ASUS
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Bean.Devise"%>
<%Devise d  = new Devise();%>
<% ArrayList<Devise> dv  = d.getAllDevise() ;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container text-center">
            <div class="modal-header" style='margin-bottom: 30px'>
                <h5 class="modal-title">Ajout Devise</h5>
            </div>
            <form class="form-control" action="./AjoutCoursDevise" method="post">
                <label>Somme:</label><input class="form-control" type="number" min="0" name="somme" required placeholder="Somme">
                <label>Taux Vente:</label><input class="form-control" type="number" min="0" name="tauxvente" required placeholder="Somme">
                <select name="devise" class="form-select">
                    <% for(int i=0; i<dv.size(); i++){%>
                        <option value="<% out.print(dv.get(i).getIddevise());%>"><% out.print(dv.get(i).getNomDevise());%></option>
                    <% }%>
                </select>
                <label>Date:</label><input class="form-control" type="date"  name="dateCours" required>
                <input class="btn btn-primary mb-3" type="submit" value="Send" style="margin-top: 30px;">
            </form>
        </div>
        <a href="index.html">Home</a>
    </body>
</html>
