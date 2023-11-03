/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Banque;
import Bean.BanqueLocal;
import Bean.Mombamoomba;
import Bean.MombamoombaLocal;
import Bean.Personne;
import Bean.PersonneLocal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class PersonByCIN extends HttpServlet {

    @EJB
//    PersonneLocal p;
//    Personne prs;
    MombamoombaLocal m;
    Mombamoomba mb;
    BanqueLocal b;
    Banque bq;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonByCIN</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersonByCIN at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet PersonByCIN at " + request.getParameter("cin") + "</h1>");
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
        
//        try{
//            String num = request.getParameter("cin");
//            prs = p.getPersonneByCIN(num);
//            request.setAttribute("personne", prs);
//            RequestDispatcher disp = request.getRequestDispatcher("ListePersonneCIN.jsp");
//            disp.forward(request, response);
//        }
//        catch(Exception e){
//            e.printStackTrace(response.getWriter());
//        }
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
        try{
            String num = request.getParameter("cin");
            
                // Assuming your .NET web service URL is accessible at http://example.com/TanyWs/listsTanyCin/{cin}
            String apiUrl = "http://localhost:5102/api/listsTanyCin?cin=" + num;

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
            

            // Now you can use jsonArray in your servlet logic
            // For example, you can set it as an attribute to use in your JSP
            request.setAttribute("tanyList", jsonArray);
            
            
            mb = new Mombamoomba().getInfoPersonneByCIN(num);
            bq = new Banque().getBanqueInfoByCIN(num);
            System.out.println(bq.getBank_name());
            request.setAttribute("personne", mb);
            request.setAttribute("banque", bq);
            System.out.println(bq.getBank_name());
            RequestDispatcher disp = request.getRequestDispatcher("Detail.jsp");
            disp.forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace(response.getWriter());
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
