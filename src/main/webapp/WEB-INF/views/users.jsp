<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MediVault | Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
    
</head>
<body>
<div class="container mt-4">
    <h3>All Users</h3>
    <table class="table table-striped">
        <thead class="table-dark">
            <tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th></tr>
        </thead>
        <tbody id="users-body"></tbody>
    </table>
</div>

<script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
<script>loadUsers();</script>
</body>
</html>
