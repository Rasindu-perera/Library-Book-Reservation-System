package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");

        if (studentId != null && !studentId.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("studentId", studentId);
            response.sendRedirect("searchBook.jsp");
        } else {
            request.setAttribute("error", "Student ID cannot be empty.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}