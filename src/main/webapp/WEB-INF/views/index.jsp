<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MediVault | Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/css/style.css">
    <script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
    
</head>
<body>
    <div class="container text-center mt-5">
        <h1 class="mb-4">Welcome to MediVault</h1>
        <p class="lead">Your secure personal medical document management system.</p>
        <a href="login.jsp" class="btn btn-primary m-2">Login</a>
        <a href="register.jsp" class="btn btn-success m-2">Register</a>
    </div>
</body>
</html>
