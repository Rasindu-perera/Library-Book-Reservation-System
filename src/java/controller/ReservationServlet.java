package controller;

import dao.BookDAO;
import dao.ReservationDAO;
import model.Reservation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author RasinduPerera
 */
@WebServlet("/reserve")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String studentId = request.getParameter("studentId");
        int bookId = Integer.parseInt(request.getParameter("bookId"));

        try {
            Reservation reservation = new Reservation();
            reservation.setStudentName(studentName);
            reservation.setStudentId(studentId);
            reservation.setBookId(bookId);

            ReservationDAO rdao = new ReservationDAO();
            rdao.reserveBook(reservation);

            BookDAO bdao = new BookDAO();
            bdao.updateBookStatus(bookId, "Reserved");

            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}