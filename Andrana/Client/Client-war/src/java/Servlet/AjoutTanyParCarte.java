/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class AjoutTanyParCarte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AjoutTanyParCarte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutTanyParCarte at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cin = request.getParameter("idcin");
        int idTany = Integer.parseInt(request.getParameter("idTany"));
        String nomTany = request.getParameter("nomTany");
        
        String concatenation = "";

             int maxPoints = 100; // Vous pouvez ajuster cette valeur en fonction de vos besoins
        
        // Créez des listes pour stocker les coordonnées
            List<Double> latitudes = new ArrayList<>();
            List<Double> longitudes = new ArrayList<>();
        
        // Parcourez les noms des champs de formulaire pour récupérer les coordonnées
            for (int i = 1; i <= maxPoints; i++) {
                String latitudeParam = request.getParameter("latitude" + i);
                String longitudeParam = request.getParameter("longitude" + i);

                System.out.println("latitude:"+ latitudeParam + "....longitude" + longitudeParam);

                // Vérifiez si les paramètres existent
                if (latitudeParam != null && longitudeParam != null) {
                    try {
                        double latitude = Double.parseDouble(latitudeParam);
                        double longitude = Double.parseDouble(longitudeParam);

                        System.out.println("DOUBLE CHECK latitude:"+ latitudeParam + "....longitude" + longitudeParam);

                        // Ajoutez les coordonnées aux listes
                        latitudes.add(latitude);
                        longitudes.add(longitude);
                    } catch (NumberFormatException e) {
                        // Gérez les erreurs de conversion si nécessaire
                    }
                } else {
                    // Si les paramètres ne sont pas trouvés, cela signifie que tous les points ont été traités
                    break;
                }
            }
                for (int i = 0; i < latitudes.size(); i++) {
                    System.out.println("Point " + (i + 1) + ": Latitude " + latitudes.get(i) + ", Longitude " + longitudes.get(i));
                    concatenation += "["+ latitudes.get(i) + "," + longitudes.get(i) + "];";

                    System.out.println(concatenation);

                }
        
                
                String apiUrl = "http://localhost:5102/api/AddTany?nom="+nomTany+"&cin="+cin;
                HttpURLConnection con = (HttpURLConnection) new URL(apiUrl).openConnection();
                con.setRequestMethod("POST");

                int responseCode = con.getResponseCode();
                if(responseCode== HttpURLConnection.HTTP_OK){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder resp = new StringBuilder();
                    String line;
                    System.out.println("done");

                    while((line= reader.readLine())!= null){
                        resp.append(line);
                    }
                    reader.close();
                }
                
            for(int i=0;i<longitudes.size();i++){
                System.out.println("miditra eto");
                String apiUrl2 = "http://localhost:5102/api/AddBornes?idTany="+idTany+"&longit="+longitudes.get(i)+"&lat="+latitudes.get(i);
                System.out.println(longitudes.get(i));
                HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl2).openConnection();
                conn.setRequestMethod("POST");

                int responseCode2 = conn.getResponseCode();
                if(responseCode2== HttpURLConnection.HTTP_OK){
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder resp2 = new StringBuilder();
                    String line;
                    System.out.println("done");
                    System.out.println("vita eto");

                    while((line= reader2.readLine())!= null){
                        resp2.append(line);
                    }
                    reader2.close();
                }
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
