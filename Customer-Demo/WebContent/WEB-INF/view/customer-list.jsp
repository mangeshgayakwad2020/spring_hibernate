<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>

<!-- Reference CSS Style Sheet here -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h3>CRM - Customer Relationship Manager</h3>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>
			
				<!-- Add new button - Add Customer -->
				<input type="button" value="Add Customer" onClick="window.location.href='showFormForAdd';return false;" class="add-button"/>
				
				<!--  Add table header here -->
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<!-- Add Customer List here -->
				<c:forEach var="customer" items="${customerList}">
				
					<!-- Construct an "Update" link with Customer Id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<!-- Construct an "Delete" link with Customer Id -->
					<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						
						<td>
						<!-- Display the update link -->
						<a href="${updateLink}">Update</a>
						|
						<!-- Display the delete link -->
						<a href="${deleteLink}"
						onClick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>