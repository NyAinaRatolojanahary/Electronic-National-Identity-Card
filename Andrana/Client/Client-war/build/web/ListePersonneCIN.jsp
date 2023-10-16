<%-- 
    Document   : ListePersonneCIN
    Created on : 10 oct. 2023, 22:42:51
    Author     : ASUS
--%>


<%@page import="Bean.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Personne pr = (Personne)request.getAttribute("personne");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listes Personnes CIN</title>
    </head>
    <body>
        <div class="table-responsive">
            <table class="table table-hover" style="margin-left: 40px;width: 1000px">
            <thead>
                <tr>
                    <th>Numero CIN</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Date De naissance</th>
                    <th>Addresse</th>
                    <th>Commune</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><% out.print(pr.getId());%></td>
                    <td><% out.print(pr.getFamilyName());%></td> 
                    <td><% out.print(pr.getFirstName());%></td> 
                    <td><% out.print(pr.getBirthday());%></td> 
                    <td><% out.print(pr.getAddresse());%></td> 
                    <td><% out.print(pr.getCommune());%></td> 
                </tr>
            </tbody>
            </table>
        </div>  
    </body>
</html>
