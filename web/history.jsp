<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="includes/header.jsp" %>

<h2 class="card-title text-center mb-4">Your Reservation History</h2>

<table class="table table-striped">
    <thead>
        <tr>
            <th>Book ID</th>
            <th>Student Name</th>
            <th>Reservation Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="r" items="${history}">
            <tr>
                <td>${r.bookId}</td>
                <td>${r.studentName}</td>
                <td>${r.reservationDate}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div class="mt-3 text-center">
    <a href="searchBook.jsp" class="btn btn-outline-secondary">Back to Search</a>
</div>

<%@ include file="includes/footer.jsp" %>