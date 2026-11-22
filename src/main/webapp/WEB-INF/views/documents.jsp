<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MediVault | Documents</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
    
</head>
<body>
<div class="container mt-4">
    <h3>Upload Document</h3>
    <form action="${pageContext.request.contextPath}/documents/upload" method="post" enctype="multipart/form-data">
        <input type="hidden" name="userId" value="1">
        <div class="mb-3">
            <input type="file" name="file" class="form-control" required>
        </div>
        <button class="btn btn-primary">Upload</button>
    </form>

    <hr>
    <h4>All Documents</h4>
    <table class="table table-bordered mt-3">
        <thead class="table-dark">
            <tr><th>ID</th><th>File Name</th><th>Type</th><th>Size (bytes)</th><th>Actions</th></tr>
        </thead>
        <tbody id="docs-body"></tbody>
    </table>
</div>

<script src="${pageContext.request.contextPath}/frontend/js/main.js"></script>
<script>
loadDocuments();
</script>
</body>
</html>
