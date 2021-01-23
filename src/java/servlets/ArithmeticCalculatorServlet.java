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
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first = request.getParameter("firstNumber");
        String second = request.getParameter("secondNumber");
        String submit = request.getParameter("submit");
        
        request.setAttribute("firstNumber", first);
        request.setAttribute("secondNumber", second);
        
        if (first == null || first.equals("") || second == null || second.equals("")) {
            request.setAttribute("message", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
            return;
        }
        
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            if (c < '0' || c > '9') {
                request.setAttribute("message", "invalid");
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);
                return;    
            }
        }
        
        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            if (c < '0' || c > '9') {
                request.setAttribute("message", "invalid");
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);
                return;    
            }
        }
        
        if (submit.equals("+")) {
            request.setAttribute("message", Integer.parseInt(first) + Integer.parseInt(second));
        } else if (submit.equals("-")) {
            request.setAttribute("message", Integer.parseInt(first) - Integer.parseInt(second));
        } else if (submit.equals("*")) {
            request.setAttribute("message", Integer.parseInt(first) * Integer.parseInt(second));
        } else {
            request.setAttribute("message", Integer.parseInt(first) % Integer.parseInt(second));
        }

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }
}