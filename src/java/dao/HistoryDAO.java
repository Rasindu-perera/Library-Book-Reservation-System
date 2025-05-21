package dao;

import java.sql.*;
import java.util.*;
import model.Reservation;

public class HistoryDAO {
    private Connection conn;

    public HistoryDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb", "root", "");
    }

    public List<Reservation> getReservationsByStudentId(String studentId) throws Exception {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE student_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, studentId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Reservation r = new Reservation();
            r.setId(rs.getInt("id"));
            r.setStudentName(rs.getString("student_name"));
            r.setStudentId(rs.getString("student_id"));
            r.setBookId(rs.getInt("book_id"));
            r.setReservationDate(rs.getTimestamp("reservation_date"));
            list.add(r);
        }
        return list;
    }
}