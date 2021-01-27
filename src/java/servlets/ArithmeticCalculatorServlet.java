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
        request.setAttribute("message", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first = request.getParameter("firstNumber");
        String second = request.getParameter("secondNumber");
        String submit = request.getParameter("submit");
        String url = "/WEB-INF/arithmeticcalculator.jsp";
        
        request.setAttribute("firstNumber", first);
        request.setAttribute("secondNumber", second);

        if (first == null || first.isEmpty() || second == null || second.isEmpty()) {
            request.setAttribute("message", "invalid");
        } else {
            try {
                int firstInt = Integer.parseInt(first);
                int secondInt = Integer.parseInt(second);

                switch (submit) {
                    case "+":
                        request.setAttribute("message", firstInt + secondInt);
                        break;
                    case "-":
                        request.setAttribute("message", firstInt - secondInt);
                        break;
                    case "*":
                        request.setAttribute("message", firstInt * secondInt);
                        break;
                    case "%":
                        request.setAttribute("message", firstInt % secondInt);
                        break;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("message", "invalid");
            } 
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}