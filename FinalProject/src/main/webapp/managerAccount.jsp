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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  </head>
  <body>
        <jsp:include page="Left.jsp"></jsp:include> 
         <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title">
                <span class="page-title-icon bg-gradient-primary text-white me-2">
                  <i class="mdi mdi-home"></i>
                </span> Manager Account
              </h3>   
              <nav aria-label="breadcrumb">
                <ul class="breadcrumb">
                  <li class="breadcrumb-item active" aria-current="page">
                     <a href="#addEmployeeModal"  <c:if test="${acc.isSell ==1}"> style="display:none; </c:if> class="btn btn-success" data-toggle="modal"><i class="mdi mdi-plus-box"></i></a>
                  </li>
                </ul>
              </nav>                          
           </div>                       
          	<c:if test="${error!=null }">
                 <div class="alert alert-danger" role="alert">
						 ${error}
				</div>
			</c:if>
			<c:if test="${mess!=null }">
                <div class="alert alert-success" role="alert">
				  	${mess}
				</div>
			</c:if> 
	      <div class="card">         			
	        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-hover text-nowrap">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Username</th>
                  <th scope="col">is Sell</th>
                  <th scope="col">is Admin</th>
                  <th scope="col">Email</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${listA}" var="o">
                <tr>

                   <td>${o.accID}</td>
               		<td>${o.userName}</td>
                   <td>${o.isSell}</td>
                   <td>${o.isAdmin}</td>
                   <td>${o.email}</td>
                   <td>                   		
                        <a href="editAccountControl?accid=${o.accID}" <c:if test="${acc.isSell ==1}"> style="display:none; </c:if>><button type="button" class="btn btn-warning"><i class="mdi mdi-pencil" data-toggle="tooltip" title="Edit"></i></button></a>   
                     	<a href="deleteAccount?accid=${o.accID}" <c:if test="${acc.isSell ==1}"> style="display:none;</c:if>><button type="button" class="btn btn-danger"><i class="mdi mdi-delete-circle" data-toggle="tooltip" title="Delete"></i></button></a>
                   </td>
                </tr>
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
    <div id="addEmployeeModal" class="modal fade" >
		<div class="modal-dialog" >
                <div class="modal-content">
                    <form action="addAccount" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">New Account</h4>
                            <a href="managerAccount"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></a>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Username</label>
                                <input name="userName" type="text" class="form-control" required>
                            </div>
                            
                            <div class="form-group">
                                <label>Password</label>
                                <input name="pass" type="password" class="form-control" required>
                            </div>                                        			 
                			 <div class="form-group form-check">
			                    <input name="isAdmin" value="1" type="checkbox" class="form-check-input" id="isAdmin">
			                    <label class="form-check-label" for="isAdmin">Là Admin</label>
                			</div>
                			 <div class="form-group">
                                <label>Email</label>
                                <input name="email" type="text" class="form-control" required>
                            </div>
                            
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
    </div>
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
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- End custom js for this page -->
	
  </body>
</html>