
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<body>
	<div class="ui segment" >
		<h3>View Your Application</h3>

		<!--  add our html table here -->
		<table class="ui celled  striped table" id="list">
			<thead>
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Resume</th>
				<th>Job Name</th>
				<th>Company Name</th>
				
				<sec:authorize access="hasRole('ROLE_STUDENT')">
				<th>Condition</th>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_COMPANY')">
					<th>Condition</th>
					<th>Actions</th>
				</sec:authorize>
			</thead>
			<!-- loop over and print our customers -->
			<c:forEach var="tempstdapps" items="${studentApplications}">

				<tr>
					<td>${tempstdapps.id}</td>
					<td>${tempstdapps.firstName}</td>
					<td>${tempstdapps.lastName}</td>
					<td>${tempstdapps.email}</td>
					<td>${tempstdapps.resume}</td>
					<td>${tempstdapps.job}</td>
					<td>${tempstdapps.companyName}</td>
					
					<sec:authorize access="hasRole('ROLE_STUDENT')">
						<c:if test="${tempstdapps.enabled=='0'}">
							<td>Pending</td>
					</c:if>	
					<c:if test="${tempstdapps.enabled=='1'}">
						<td> Accepted! </td>
					</c:if>
					<c:if test="${tempstdapps.enabled=='2'}">
						<td> Denied </td>
					</c:if>
					</sec:authorize>
						
					
					<sec:authorize access="hasRole('ROLE_COMPANY')">
						<c:if test="${tempstdapps.enabled=='0'}">
							<td>Pending</td>
					</c:if>	
					<c:if test="${tempstdapps.enabled=='1'}">
						<td> Accepted </td>
					</c:if>
					<c:if test="${tempstdapps.enabled=='2'}">
						<td> Denied </td>
					</c:if>
					
					<td><a
							href="<c:url value="deleteStdapps/${tempstdapps.id}"></c:url>"><button
									type="submit" id="${tempstdapps.id}" name="deleteStdapps"
									class="btn btn-danger">
									<i class="remove user icon"></i> Delete
								</button></a> <c:if test="${tempstdapps.enabled=='0'}">
								<a href="<c:url value="accept/${tempstdapps.id}"></c:url>"><button
										type="submit" id="${tempstdapps.id}" name="accept"
										class="btn btn-success">
										<i class="remove user icon"></i> Accept
									</button></a>
									<a href="<c:url value="deny/${tempstdapps.id}"></c:url>"><button
										type="submit" id="${tempstdapps.id}" name="deny"
										class="btn btn-warning">
										<i class="remove user icon"></i> Deny
									</button></a>	
							</c:if></td>
						
					</sec:authorize>
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