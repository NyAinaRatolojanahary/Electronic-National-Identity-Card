/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Devise;
import Bean.TransfertArgent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author ASUS
 */
public class Transfert extends HttpServlet {

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
            out.println("<title>Servlet Transfert</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Transfert at " + request.getContextPath() + "</h1>");
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
        String cin1 = request.getParameter("cin1");
        String cin2 = request.getParameter("cin2");
        double somme = Double.parseDouble(request.getParameter("somme"));
        int devise =  Integer.parseInt(request.getParameter("devise"));
        
        Devise dv = new Devise();
        TransfertArgent tr = new TransfertArgent();
        double sommeAr = dv.changeDeviseEnAr(devise,somme);
        System.out.println(sommeAr);
        try {
            tr.tauxAchatAction(cin1, 5, devise, somme);
        } catch (Exception ex) {
            Logger.getLogger(Transfert.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean solde = tr.checkCount(cin1, sommeAr);
        
        if(solde=true){
            try {
                tr.transfererArgent(cin1, cin2, 1, devise, sommeAr);
                response.sendRedirect("Transfert.jsp");
            } catch (Exception ex) {
                Logger.getLogger(Transfert.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            String err = "Votre solde ne vous permet pas de faire cette transaction";
            request.setAttribute("error", err);
            RequestDispatcher disp = request.getRequestDispatcher("Transfert.jsp");
            disp.forward(request, response);
            response.sendRedirect("Transfert.jsp");
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
