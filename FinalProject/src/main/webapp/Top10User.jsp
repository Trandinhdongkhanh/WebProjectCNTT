<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
  </head>
  <body>
     
        <jsp:include page="Left.jsp"></jsp:include> 
         <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title">
                <span class="page-title-icon bg-gradient-primary text-white me-2">
                  <i class="mdi mdi-home"></i>
                </span> Top 10 Users
              </h3>                     
           </div>                       
           
	      <div class="card">         			
	        <div class="card-body">
	          <div class="table-responsive">
	            <table class="table table-hover text-nowrap">
	              <thead>
	                <tr>
	                  <th scope="col">ID</th>
	                  <th scope="col">User Name</th> 
	                  <th scope="col">Email</th> 
	                   <th scope="col">Total Spending</th>
	                </tr>
	              </thead>
	              <tbody>
	               <c:forEach items="${listTop10User}" var="t">
	               <c:forEach items="${listAllUser}" var="o">
	               	<c:if test="${t.accID==o.accID }">
		                <tr>
		                   <td>${o.accID}</td>
		               		<td>${o.userName}</td>
		               		<td>${o.email}</td>
		                   <td>${t.total}</td>
		                </tr>
		             </c:if>
	                </c:forEach>
	                </c:forEach>
	              </tbody>
	            </table>
	          </div>
	        </div>
	      </div>
    
            
          
                
          </div>
        </div> 
      </div>
          <!-- content-wrapper ends -->
          <!-- partial:partials/_footer.html -->
          <footer class="footer">
            <div class="container-fluid d-flex justify-content-between">
              <span class="text-muted d-block text-center text-sm-start d-sm-inline-block">Project Nhom 4 2022</span>
            </div>
          </footer>
          <!-- partial -->
        <!-- main-panel ends -->
      <!-- page-body-wrapper ends -->
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="assets/vendors/chart.js/Chart.min.js"></script>
    <script src="assets/js/jquery.cookie.js" type="text/javascript"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src="assets/js/dashboard.js"></script>
    <script src="assets/js/todolist.js"></script>
    <!-- End custom js for this page -->

  </body>
</html>