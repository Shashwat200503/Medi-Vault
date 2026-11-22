<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MediVault | Prescriptions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
    
</head>
<body>
<div class="container mt-4">
    <h3>Prescriptions</h3>
    <table class="table table-striped mt-3">
        <thead class="table-dark">
            <tr><th>ID</th><th>Doctor</th><th>Hospital</th><th>Diagnosis</th><th>Status</th></tr>
        </thead>
        <tbody id="pres-body"></tbody>
    </table>
</div>

<script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
<script>loadPrescriptions();</script>
</body>
</html>
