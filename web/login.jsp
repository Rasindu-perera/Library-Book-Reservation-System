<%@ include file="includes/header.jsp" %>

<h2 class="card-title text-center mb-4">Student Login</h2>
<form action="login" method="post" class="needs-validation" novalidate>
    <div class="mb-3">
        <label for="studentId" class="form-label">Student ID</label>
        <input type="text" class="form-control" id="studentId" name="studentId" required>
    </div>
    <div class="d-grid gap-2">
        <button type="submit" class="btn btn-primary">Login</button>
    </div>
</form>
<% if(request.getAttribute("error") != null) { %>
    <div class="alert alert-danger mt-3" role="alert">
        ${error}
    </div>
<% } %>

<%@ include file="includes/footer.jsp" %>