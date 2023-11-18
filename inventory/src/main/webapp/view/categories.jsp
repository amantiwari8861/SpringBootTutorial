<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AdminLTE 3 | DataTables</title>
  <jsp:include page="header.jsp" />
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <jsp:include page="navbar.jsp" />

  <jsp:include page="sidebar-menu.jsp" />

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Mobile Phones</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Mobile</a></li>
              <li class="breadcrumb-item active">DataTables</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">

            <div class="card">
              <div class="card-header">
                <h3 class="card-title">DataTable with default features</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>Id</th>
                    <th>Category Name</th>
                    <th>Record Created</th>
                    <th>Action</th>
                  </tr>
                  </thead>
                  <tbody>
                    <c:forEach var = "category" items="${categories}">
                      <tr>
                        <td>${category.getId()}</td>
                        <td>${category.getCategoryName()}</td>
                        <td>${category.getRecordCreated()}</td>
                        <td>
                          <a href="/category/update/${category.getId()}" class="btn btn-sm btn-warning">Update</a>
                          <a href="/category/delete/${category.getId()}" class="btn btn-sm btn-danger">Delete</a>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                  <tfoot>
                  <tr>
                    <th>Id</th>
                    <th>Category Name</th>
                    <th>Record Created</th>
                    <th>Action</th>
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <jsp:include page="footer.jsp" />

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<jsp:include page="footer-scripts.jsp" />
</body>
</html>
