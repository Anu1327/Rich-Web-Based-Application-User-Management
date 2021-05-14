<%@ page import= "com.Customer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/customer.js"></script>
</head>
<body>

<div class="container"><div class="row"><div class="col-6">

<h1>User Management </h1>
<form id="formCustomer" name="formCustomer" method="post" action="Customer.jsp">

 Customer Identity: 
<input id="customerIdentity" name="customerIdentity" type="text" 
 class="form-control form-control-sm">
 
<br> Customer Name: 
<input id="customerName" name="customerName" type="text" 
 class="form-control form-control-sm">
 
<br> Customer Email: 
<input id=customerEmail name="customerEmail" type="text" 
 class="form-control form-control-sm">
 
<br> Customer Address: 
<input id="customerAddress" name="customerAddress" type="text" 
 class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
<input type="hidden" id="hidcustomerIdentitySave" name="hidcustomerIdentitySave" value="">
</form>

<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

 
<br>
<div id="divCustomersGrid">

<%
 Customer customerObj = new Customer(); 
 out.print(customerObj.readCustomer()); 
%>
</div>

</div></div></div>




</body>
</html>