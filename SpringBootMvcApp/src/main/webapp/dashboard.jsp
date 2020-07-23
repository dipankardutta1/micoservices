<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>




<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
<script type="text/javascript">

$(document).ready(function(){


	$( "#dob" ).datepicker({ dateFormat: 'dd/mm/yy' });
	
	 
});


</script>
  
  

<style type="text/css">

body {
	padding: 25px;
}
</style>


</head>
<body>




<div class="panel panel-primary">
  <div class="panel-heading">User Entry</div>
  	<div class="panel-body">
  		
  		
  		
  		<form:form action="processUser" method="post" modelAttribute="userformData">
  		
  			<form:hidden path="id" id="id"  />
  			
  			
  			
  		
		  <div class="form-group">
		    <label for="name">Name:</label>
		    
		    <form:input path="name" id="name" cssClass="form-control"/>
		    
		    
		  </div>
		  
		  <div class="form-group">
		    <label for="phoneNo">Phone No:</label>
		    
		    <form:input path="phoneNo" id="phoneNo" cssClass="form-control"/>
		  </div>
		  
		  
		  <div class="form-group">
		    <label for="dob">DOB:</label>
		    <form:input path="dob" id="dob" cssClass="form-control" readonly="true"/>
		  </div>
		  
		  <div class="form-group">
		    <label for="username">Username:</label>
		    
		    <form:input path="username" id="username" cssClass="form-control"/>
		  </div>
		  
		  
		  <div class="form-group">
		    <label for="password">Password:</label>
		    
		    <form:input path="password" id="password" cssClass="form-control"/>
		  </div>
		  
		  
		  <button type="submit" class="btn btn-default">Submit</button>
  		</form:form>
  	
  	
  	</div>
  </div>





<div class="panel panel-primary">
  <div class="panel-heading">User List</div>
  	<div class="panel-body">
		
		<table class="table">
			<thead>
				<tr>
					<th>NAME</th>
					<th>PHONE NO</th>
					<th>DOB</th>
					<th>USERNAME</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				
				<c:forEach items="${users}" var="user">
				
					<tr>
						<td>  <c:out value="${user.name }"></c:out>  </td>
						<td> <c:out value="${user.phoneNo}"></c:out></td>
  						<td>  <f:formatDate value="${user.dob}" pattern="MM/dd/yyyy"/>   </td>
						<td> <c:out value="${user.username}"></c:out></td>
						<td> <a href="editUser?id=${user.id}">Edit</a> / <a href="deleteUser?id=${user.id}">Delete</a> </td>
					</tr>
				
				
				</c:forEach>
				
			</tbody>
			
		</table>



	</div>
</div>

</div>


</body>
</html>