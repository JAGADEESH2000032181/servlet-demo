package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String item = request.getParameter("item");

        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        cart.add(item);
        response.sendRedirect("shop.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("view".equals(action)) {
            HttpSession session = request.getSession();
            List<String> cart = (List<String>) session.getAttribute("cart");

            response.setContentType("text/html");
            response.getWriter().println("<h1>Shopping Cart</h1>");

            if (cart == null || cart.isEmpty()) {
                response.getWriter().println("<p>Your cart is empty.</p>");
            } else {
                response.getWriter().println("<ul>");
                for (String item : cart) {
                    response.getWriter().println("<li>" + item + "</li>");
                }
                response.getWriter().println("</ul>");
            }

            response.getWriter().println("<a href='shop.html'>Go Back to Shopping</a>");
        }
    }
}
