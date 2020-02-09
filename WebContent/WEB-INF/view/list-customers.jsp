
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf" %>
<body>
	<div class="ui segment">
	<h3>List of Customers</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempCustomer" items="${customers}">

			<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
				<td><a
					href="<c:url value="deleteCustomer/${tempCustomer.id}"></c:url>"><button type="submit" id="${tempCustomer.id}"
					name="deleteCustomer"><i class="remove user icon"></i>
					 Delete</button></a>
				<!--   <a
					href="<c:url value="/customer/${tempCustomer.id}"></c:url>"><i class="unhide icon"></i>
					View</a>-->	
			</tr>
		</c:forEach>
	</table>
</div>
<!-- 
<script type="text/javascript">
	$("[name='deleteCustomer']").click(function() {
		var urlCall = "<c:url value="/api/customer/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/customer/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>-->


<%@ include file="/WEB-INF/view/jspf/footer.jspf" %>
