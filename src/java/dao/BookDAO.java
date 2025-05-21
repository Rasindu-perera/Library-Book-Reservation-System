package dao;

import java.sql.*;
import java.util.*;
import model.Book;
/**
 *
 * @author RasinduPerera
 */
public class BookDAO {
    private Connection conn;

    public BookDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb", "root", "");
    }

    public List<Book> searchBooks(String title) throws Exception {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + title + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setStatus(rs.getString("status"));
            list.add(book);
        }
        return list;
    }

    public Book getBookById(int id) throws Exception {
        String sql = "SELECT * FROM books WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setStatus(rs.getString("status"));
            return book;
        }
        return null;
    }

    public void updateBookStatus(int bookId, String status) throws Exception {
        String sql = "UPDATE books SET status=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, bookId);
        ps.executeUpdate();
    }
}