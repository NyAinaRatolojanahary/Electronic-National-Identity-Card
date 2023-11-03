<%-- 
    Document   : AjoutTanyParCoordonnee
    Created on : 24 oct. 2023, 22:30:40
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String cin = request.getParameter("idcin");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <title>Ajout Tany par Coordonee</title>
    </head>
    <body>
        <div class="container text-center">
            <div class="modal-header" style='margin-bottom: 30px'>
                <h5 class="modal-title">Coordonne Tany</h5>
            </div>
            <form action="./AjoutTanyParCoordonnee?idcin=<% out.print(cin);%>" method="post">
                <div class="input-group" style="margin-bottom: 20px">
                    <span class="input-group-text">Nom Tany</span>
                    <input type="text" name="nomTany" class="form-control">
                     <span class="input-group-text">ID Tany</span>
                    <input type="text" name="idTany" class="form-control">
                </div>
                <div id="coord">
                    <div class="input-group">
                        <span class="input-group-text">Longitude</span>
                        <input type="text" name="longitude[]" class="form-control">
                        <span class="input-group-text">Latitude</span>
                        <input type="text" name="latitude[]" class="form-control">
                    </div>
                </div>
                <input type="button" class="btn btn-success" value="Ajouter Coordonnées" style="margin-top: 20px" onclick="addCoordinates()">
                <input type="submit" class="btn btn-primary" value="Enregistrer" style="margin-top: 20px">
            </form>
         </div>
    </body>
</html>
<script>
    function addCoordinates() {
        var coordinatesDiv = document.getElementById("coord");
        coordinatesDiv.appendChild(document.createElement("br"));
        var grp = document.createElement("div");
        grp.setAttribute("class", "input-group");
        coordinatesDiv.appendChild(grp);

        var longitudelabel = document.createElement("span");
        longitudelabel.setAttribute("class", "input-group-text");
        longitudelabel.textContent = "Longitude";
        grp.appendChild(longitudelabel);

        var longitudeInput = document.createElement("input");
        longitudeInput.setAttribute("type", "text");
        longitudeInput.setAttribute("name", "longitude[]");
        longitudeInput.setAttribute("class", "form-control");
        grp.appendChild(longitudeInput);

        var latitudelabel = document.createElement("span");
        latitudelabel.setAttribute("class", "input-group-text");
        latitudelabel.textContent = "Latitude";
        grp.appendChild(latitudelabel);

        var latitudeInput = document.createElement("input");
        latitudeInput.setAttribute("type", "text");
        latitudeInput.setAttribute("name", "latitude[]");
        latitudeInput.setAttribute("class", "form-control");
        grp.appendChild(latitudeInput);
        

        coordinatesDiv.appendChild(document.createElement("br"));
    }
</script>
