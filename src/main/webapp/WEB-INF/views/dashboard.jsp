<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MediVault | Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
    
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="dashboard.jsp">MediVault</a>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" href="documents.jsp">Documents</a></li>
        <li class="nav-item"><a class="nav-link" href="prescriptions.jsp">Prescriptions</a></li>
        <li class="nav-item"><a class="nav-link" href="labreports.jsp">Lab Reports</a></li>
        <li class="nav-item"><a class="nav-link" href="users.jsp">Users</a></li>
        <li class="nav-item"><a class="nav-link text-danger" href="index.jsp">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-5 text-center">
    <h3>Welcome to MediVault Dashboard</h3>
    <p class="lead">Access and manage your medical records securely.</p>
</div>
</body>
</html>
