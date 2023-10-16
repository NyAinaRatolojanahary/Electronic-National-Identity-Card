<%-- 
    Document   : Detail
    Created on : 12 oct. 2023, 19:58:12
    Author     : ASUS
--%>

<%@page import="Bean.Mombamoomba"%>
<%@page import="Bean.Banque"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Mombamoomba m = (Mombamoomba)request.getAttribute("personne");%>
<%Banque b = (Banque)request.getAttribute("banque");%>

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
                <h5 class="modal-title">Info Personnel</h5>
            </div>
            <div class="list-group" style="margin-top: 30px;margin-left: 40px;width: auto"> 
                <div class="table-responsive">
                    <table class="table table-bordered" style="margin-left: 40px;width: auto">
                    <thead>
                        <tr>
                            <th>Numero CIN</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Date De naissance</th>
                            <th>Addresse</th>
                            <th>Commune</th>
                            <th>Profession</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><% out.print(m.getCn().getId());%></td>
                            <td><% out.print(m.getPr().getFamilyName());%></td> 
                            <td><% out.print(m.getPr().getFirstName());%></td> 
                            <td><% out.print(m.getPr().getBirthday());%></td> 
                            <td><% out.print(m.getPr().getAddresse());%></td> 
                            <td><% out.print(m.getCm().getNomCommune());%></td>
                            <td><% out.print(m.getCn().getProfession());%></td> 
                        </tr>
                    </tbody>
                    </table>
                </div>  
            </div>
        </div>
        <div class="container text-center">
            <div class="modal-header" style='margin-bottom: 30px'>
                <h5 class="modal-title">Info Banque</h5>
            </div>
            <div class="list-group" style="margin-top: 30px;margin-left: 40px;width: auto">                
                <div class="table-responsive">
                    <table class="table table-bordered" style="margin-left: 40px;width: auto">
                    <thead>
                        <tr>
                            <th>Numero Compte</th>
                            <th>Type de compte</th>
                            <th>Nom banque</th>
                            <th>Addresse banque</th>
                            <!--<th>Commune Banque</th>-->
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><% out.print(b.getId());%></td>
                            <td><% out.print(b.getCount_name());%></td> 
                            <td><% out.print(b.getBank_name());%></td> 
                            <td><% out.print(b.getBank_location());%></td> 
                            <!--<td><% // out.print(b.getCommune());%></td>--> 
                        </tr>
                    </tbody>
                    </table>
                </div>  
            </div>
        </div>
        <div class="container text-center">
           <div class="modal-header" style='margin-bottom: 30px'>
               <h5 class="modal-title">Info Foncier</h5>
           </div>
            <div class="table-responsive">
                <table class="table table-bordered" style="margin-left: 40px;width: auto">
                <thead>
                    <tr>
                        <th>Numero Tany</th>
                        <th>Nom Tany</th>
                        <th>Superficie</th>
                        <th>Secteur</th>
                        <th>District</th>
                        <th>Status</th>
                        <th>CIN Proprietaire</th>
                    </tr>
                </thead>
                <tbody>        
                    <%
                        JSONArray tanyLists = (JSONArray)request.getAttribute("tanyList");

                        for(int i=0; i< tanyLists.length();i++){
                            JSONObject property = tanyLists.getJSONObject(i);
                            String id = property.getString("id");
                            String nomTany = property.getString("nomTany");
                            double superficie = property.getDouble("superficie");
                            String secteur = property.getString("secteur");
                            String district = property.getString("district");
                            String status = property.getString("statusTany");
                            String tompony = property.getString("tompony");
                    %>
                    <tr>
                            <td><%= id %></td>
                            <td><%= nomTany%></td> 
                            <td><%= superficie%> m²</td> 
                            <td><%= secteur%></td> 
                            <td><%= district%></td> 
                            <td><%= status%></td>
                            <td><%= tompony%></td> 
                        <%}
                    %>
                    </tr>
                </tbody>
                </table>
            </div>  
        </div>
        <a href="index.html">Home</a>
    </body>
</html>
