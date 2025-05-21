package controller;

import dao.HistoryDAO;
import model.Reservation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentId = (String) session.getAttribute("studentId");

        if (studentId != null) {
            try {
                HistoryDAO dao = new HistoryDAO();
                List<Reservation> history = dao.getReservationsByStudentId(studentId);
                request.setAttribute("history", history);
                RequestDispatcher rd = request.getRequestDispatcher("history.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}