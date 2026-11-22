<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MediVault | Lab Reports</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
    
</head>
<body>
<div class="container mt-4">
    <h3>Lab Reports</h3>
    <table class="table table-striped mt-3">
        <thead class="table-dark">
            <tr><th>ID</th><th>Test</th><th>Laboratory</th><th>Status</th></tr>
        </thead>
        <tbody id="lab-body"></tbody>
    </table>
</div>

<script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
<script>loadLabReports();</script>
</body>
</html>
