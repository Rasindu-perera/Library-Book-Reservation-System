<%--
Author     : RasinduPerera
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="includes/header.jsp" %>

<h2 class="card-title text-center mb-4">Book Results</h2>

<div class="list-group">
    <c:forEach var="book" items="${bookList}">
        <div class="list-group-item list-group-item-action">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">${book.title}</h5>
                <a href="reserveForm.jsp?bookId=${book.id}" class="btn btn-sm btn-primary">Reserve</a>
            </div>
            <p class="mb-1">Author: ${book.author}</p>
            <small class="text-muted">Status: ${book.status}</small>
        </div>
    </c:forEach>
</div>

<div class="mt-3 text-center">
    <a href="searchBook.jsp" class="btn btn-outline-secondary">Back to Search</a>
</div>

<%@ include file="includes/footer.jsp" %>