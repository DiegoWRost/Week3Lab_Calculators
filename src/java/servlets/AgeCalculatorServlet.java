/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Weidle Rost
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String age = request.getParameter("enterAge");
        String url = "/WEB-INF/agecalculator.jsp";

        request.setAttribute("enterAge", age);
        
        if (age == null || age.isEmpty()) {
            request.setAttribute("message", "You must give your current age");
        } else {
            try {
                request.setAttribute("message", "Your age next birthday will be " + (Integer.parseInt(age) + 1));
            } catch (NumberFormatException e) {
                request.setAttribute("message", "You must enter a valid number");  
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
