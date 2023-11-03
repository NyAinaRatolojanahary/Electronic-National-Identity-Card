<%-- 
    Document   : AjoutTanyParCarte
    Created on : 24 oct. 2023, 22:31:13
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String cin = request.getParameter("idcin");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/leaflet/leaflet.css">
    <script src="assets/leaflet/leaflet.js"></script>
    <title>Maps</title>
    <style>
       #map{height: 380px;} 
        body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
        }
        form {
            margin-top: 20px;
            padding-top: 100px;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        h2 {
            text-align: center;
            margin-top: 20px;
        }
        #inputForm {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        #inputQuestion {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #0056b3;
        }
            select,
        input[type="file"],
        input[type="date"],
        input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            transition: border-color 0.3s ease-in-out;
        }
        select:focus,
        input[type="file"]:focus,
        input[type="date"]:focus,
        input[type="text"]:focus {
            border-color: #007BFF;
        }
    </style>
</head>
<body>
    <div class="container text-center">
        <div class="modal-header" style='margin-bottom: 30px'>
            <h5 class="modal-title">Carte Tany</h5>
        </div>
        <div id="map"></div>
        <form action="./AjoutTanyParCarte?idcin=<% out.print(cin);%>" method="post">
                <input type="text" name="nomTany">
                <input type="text" name="idTany">
                <input type="hidden" id="markers" name="markers">
                <input type="hidden" name="latitude" id="latitudeInput">
                <input type="hidden" name="longitude" id="longitudeInput">
            <input type="submit" class="btn btn-success" value="Insérer">
        </form>
        <script>
            var map = L.map('map').setView([-18.962604592639682 ,47.54297696660276], 20);
            
            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);
            
            
            var markers = [];
            var polygon = L.polygon([], { color: 'blue' }).addTo(map);
            
            
            
            var pointCounter = 1; // Compteur de points

            map.on('click', function (e) {
                var latlng = e.latlng;

                // Créez un champ de formulaire caché pour la latitude et la longitude du point actuel
                var latitudeInput = document.createElement('input');
                latitudeInput.type = 'hidden';
                latitudeInput.name = 'latitude' + pointCounter;
                latitudeInput.value = latlng.lat;
                document.querySelector('form').appendChild(latitudeInput);

                var longitudeInput = document.createElement('input');
                longitudeInput.type = 'hidden';
                longitudeInput.name = 'longitude' + pointCounter;
                longitudeInput.value = latlng.lng;
                document.querySelector('form').appendChild(longitudeInput);

                // Incrémente le compteur de points
                pointCounter++;
    
    
                // Créer un marqueur avec un popup contenant les coordonnées
                var marker = L.marker(latlng).addTo(map);
                marker.bindPopup('Latitude: ' + latlng.lat + '<br>Longitude: ' + latlng.lng).openPopup();
                markers.push(marker);

                // Mettre à jour la polyligne
                var coordinates = markers.map(function (marker) {
                    return marker.getLatLng();
                });
                
                document.getElementById('latitudeInput').value = latlng.lat;
                document.getElementById('longitudeInput').value = latlng.lng;

                polyline.setLatLngs(coordinates);
                document.getElementById('markers').value = JSON.stringify(markers);
                document.querySelector('form').submit();
        });
            
        </script>
    </div>
</body>
</html>
