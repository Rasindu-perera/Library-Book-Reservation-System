package dao;

import java.sql.*;
import model.Reservation;
/**
 *
 * @author RasinduPerera
 */
public class ReservationDAO {
    private Connection conn;

    public ReservationDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb", "root", "");
    }

    public void reserveBook(Reservation res) throws Exception {
        String sql = "INSERT INTO reservations (student_name, student_id, book_id) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, res.getStudentName());
        ps.setString(2, res.getStudentId());
        ps.setInt(3, res.getBookId());
        ps.executeUpdate();
    }
}