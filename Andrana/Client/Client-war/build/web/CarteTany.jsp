<%-- 
    Document   : CarteTany
    Created on : 22 oct. 2023, 17:27:30
    Author     : ASUS
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    int id = Integer.parseInt(request.getParameter("id"));

    // Assuming your .NET web service URL is accessible at http://example.com/TanyWs/listsTanyCin/{cin}
    String apiUrl = "http://localhost:5102/api/BornesTanyById?idtany=" + id;

    URL url = new URL(apiUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    // Read the response from the web service
    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuilder content = new StringBuilder();

    while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
    }
    in.close();

    // Process the response (assuming it's JSON, you might need a JSON library)
    JSONArray jsonArray = new JSONArray(content.toString());
    
    List<String> coordinates = new ArrayList<String>();

    double latt=0;
    double longi=0;
    
    for(int i=0; i< jsonArray.length();i++){
        JSONObject landmark = jsonArray.getJSONObject(i);
        latt = landmark.getDouble("latitude");
        longi = landmark.getDouble("longitude");

        coordinates.add("[" + latt + "," + longi + "]");
    }

    String coord = String.join(",", coordinates);
%>
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
    </style>
</head>
<body>
    <div class="container text-center">
        <div class="modal-header" style='margin-bottom: 30px'>
            <h5 class="modal-title">Carte Tany <% out.print(id);%></h5>
        </div>
        <div id="map"></div>
        <script>
            var map = L.map('map').setView([ <%= latt%> , <%= longi%>], 20);
            
            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);
            
            var coord = [<%= coord %>]; // Pass the coordinates from JSP

            var polygon = L.polygon(coord).addTo(map);
            
            
        </script>
    </div>
</body>
</html>

