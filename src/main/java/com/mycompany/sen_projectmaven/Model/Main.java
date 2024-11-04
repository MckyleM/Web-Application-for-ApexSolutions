package com.mycompany.sen_projectmaven.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author mckyl
 */
@WebServlet(urlPatterns = {"/MainS", "/sms"})
public class Main extends HttpServlet { 

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainS at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/sms".equals(path)) {
            sms(request, response);
        } else {
            processRequest(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    protected void sms(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        // Use JSON structure to return the response
        try (PrintWriter out = response.getWriter()) {
            boolean smsSent = false;

            try {
                //TestAPI(); // Call your sms function
                smsSent = true;
            } catch (Exception e) {
                smsSent = false;
            }

            // Create JSON response
            String jsonResponse = "{\"status\":\"" + (smsSent ? "success" : "failed") + "\"}";
            out.print(jsonResponse);
        }
    }
}

