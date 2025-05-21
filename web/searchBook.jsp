<%@ page session="true" %>
<%@ include file="includes/header.jsp" %>

<h2 class="card-title text-center mb-4">Search Books</h2>
<form action="search" method="post" onsubmit="return validateForm();" class="mb-4">
    <div class="input-group">
        <input type="text" class="form-control" name="title" id="title" placeholder="Enter book title">
        <button class="btn btn-primary" type="submit">Search</button>
    </div>
</form>
<div class="text-center">
    <a href="history" class="btn btn-outline-secondary">View Reservation History</a>
</div>

<script>
    function validateForm() {
        var title = document.getElementById("title").value;
        if (title.trim() === "") {
            alert("Please enter a book title.");
            return false;
        }
        return true;
    }
</script>

<%@ include file="includes/footer.jsp" %>