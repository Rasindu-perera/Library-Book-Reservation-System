<%--
Author     : RasinduPerera
--%>
<%@ include file="includes/header.jsp" %>

<html>
<body>
    <h2 class="card-title text-center mb-4">Reserve Book</h2>
    <form action="reserve" method="post" class="needs-validation" novalidate>
        <input type="hidden" name="bookId" value="${param.bookId}"/>
        
        <div class="mb-3">
            <label for="studentName" class="form-label">Student Name</label>
            <input type="text" class="form-control" id="studentName" name="studentName" required>
        </div>
        
        <div class="mb-3">
            <label for="studentId" class="form-label">Student ID</label>
            <input type="text" class="form-control" id="studentId" name="studentId" required>
        </div>
        
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary">Reserve</button>
        </div>
    </form>

    <div class="mt-3 text-center">
        <a href="searchBook.jsp" class="btn btn-outline-secondary">Back to Search</a>
    </div>
</body>
</html>

<%@ include file="includes/footer.jsp" %>