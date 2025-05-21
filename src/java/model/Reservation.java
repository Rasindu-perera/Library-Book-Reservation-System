package model;

import java.sql.Timestamp;
/**
 *
 * @author RasinduPerera
 */
public class Reservation {
    private int id;
    private String studentName;
    private String studentId;
    private int bookId;
    private Timestamp reservationDate;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public Timestamp getReservationDate() { return reservationDate; }
    public void setReservationDate(Timestamp reservationDate) { this.reservationDate = reservationDate; }
}