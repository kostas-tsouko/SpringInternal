
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<body>
	<div class="ui segment" >
		<h3>List of Companies</h3>

		<!--  add our html table here -->
		<table class="ui celled  striped table" id="list">
			<thead>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Actions</th>
			</thead>
			<!-- loop over and print our customers -->
			<c:forEach var="tempCompany" items="${companies}">

				<tr>
					<td>${tempCompany.id}</td>
					<td>${tempCompany.firstName}</td>
					<td>${tempCompany.lastName}</td>
					<td>${tempCompany.email}</td>
					<td><a
						href="<c:url value="deleteCompany/${tempCompany.id}"></c:url>"><button
								class="btn btn-danger"type="submit" id="${tempCompany.id}" name="deleteStudent">
								<i class="remove user icon"></i> Delete
							</button></a> <!--   <a
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


	<%@ include file="/WEB-INF/view/jspf/footer.jspf"%>