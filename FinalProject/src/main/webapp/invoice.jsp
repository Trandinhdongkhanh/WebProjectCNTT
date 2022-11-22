<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Invoice</title>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
    <style>
		.left-column {
		    width: auto;
		    height: auto;
		    background: #ddd;
		}
		.right-column {
		    width: auto;
		    height: auto;
		    background: #959595;
		}
		.search {
			padding: 5px 0px 5px 0px;
			text-align: center;
		}
	</style>
</head>
<body>
        <jsp:include page="Left.jsp"></jsp:include> 
         <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title">
                <span class="page-title-icon bg-gradient-primary text-white me-2">
                  <i class="mdi mdi-home"></i>
                </span> List Invoice
              </h3>  
              
                   	    
              <nav aria-label="breadcrumb">
              
                <ul class="breadcrumb">
                  <li class="breadcrumb-item active" aria-current="page">   
                 	<form action="exportExcelControl" class="search" method="get">
						<input oninput="searchByCreateDate(this)" type="date" id="createdate" name="createdate" class="form-control mb-0" style="width:100%; display: flex; align-items: center;">
						<button type="submit" class="mb-0 text-center btn btn-primary">Export Excel</button> 
						     	
			  </form> 
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
                  <th scope="col"></th>
                  <th scope="col">InvoiceID</th>
                  <th scope="col">AccountID</th>
                  <th scope="col">UserName</th>
                  <th scope="col">Total</th>
                  <th scope="col">Create_Date</th>
                </tr>
              </thead>
           
              <tbody id="content">
                <c:forEach items="${listAllInvoice}" var="i">
                	<c:forEach items="${listAllAccount}" var="a">
                  		<c:if test="${i.accID==a.accID }">
			                <tr>
			                  <th scope="row"></th>
			                  <td>${i.invoiceID }</td>			                  
			                  <td>${i.accID}</td>
			                  <td>${a.userName}</td>
			                  <td>${String.format("%.02f",i.total)}</td>
			                  <td>${i.create_date }</td> 
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
          <!-- content-wrapper ends -->
          <!-- partial:partials/_footer.html -->
          <footer class="footer">
            <div class="container-fluid d-flex justify-content-between">
              <span class="text-muted d-block text-center text-sm-start d-sm-inline-block">Project Nhom 4 2022</span>
            </div>
          </footer>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    
 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        
<!--Main layout-->
<!-- SCRIPTS -->
  <!-- JQuery -->
  <script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
    <!-- MDB Ecommerce JavaScript -->
    <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
 <!-- MDB -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    <!-- Custom scripts -->
    <script type="text/javascript" src="js/script.js"></script>
    <script src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
    

<script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
	 <!-- MDB -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    <!-- Custom scripts -->
    <script type="text/javascript" src="js/script.js"></script>
    <script>
    function searchByCreateDate(param){
        var txtSearchDate = param.value;
        $.ajax({
            url: "/FinalProject/searchAjaxCreateDate",
            type: "get", //send it through get method
            data: {
                createDate: txtSearchDate
            },
            success: function (responseData) {
                document.getElementById("content").innerHTML = responseData;
            }          
        });
    }
    </script>
</body>
</html>