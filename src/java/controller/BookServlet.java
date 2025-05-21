package controller;

import dao.BookDAO;
import model.Book;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author RasinduPerera
 */
@WebServlet("/search")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");

        try {
            BookDAO dao = new BookDAO();
            List<Book> books = dao.searchBooks(title);
            request.setAttribute("bookList", books);
            RequestDispatcher rd = request.getRequestDispatcher("bookList.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}