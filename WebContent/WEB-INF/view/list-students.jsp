
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>

	<div class="ui segment">
		<h3 id="head">List of Students</h3>

		<!--  add our html table here -->
		<table class="ui celled  striped table" id="list">
			<thead>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Semester</th>
				<th>Subjects Owned</th>
				<th>Resume</th>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICE')">
					<th>Condition</th>
					<th>Actions</th>
				</sec:authorize>
			</thead>
			<!-- loop over and print our customers -->
			<tbody>
			<c:forEach var="tempStudent" items="${students}">
				<tr>
					<td>${tempStudent.id}</td>
					<td>${tempStudent.firstName}</td>
					<td>${tempStudent.lastName}</td>
					<td>${tempStudent.email}</td>
					<td>${tempStudent.semester}</td>
					<td>${tempStudent.subjects_owned}</td>
					<td>${tempStudent.resume}</td>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICE')">
		<c:if test="${tempStudent.enabled=='0'}">
							<td>Pending</td>
					</c:if>	
					<c:if test="${tempStudent.enabled=='1'}">
						<td> Accepted! </td>
					</c:if>
					<c:if test="${tempStudent.enabled=='2'}">
						<td> Denied </td>
					</c:if>
						
						<td><a href="<c:url value="deleteStudent/${tempStudent.id}"></c:url>"><button class="btn btn-danger"
									type="submit" id="${tempStudent.id}" name="deleteStudent">
									<i class="remove user icon"></i>Delete</button></a> <c:if test="${tempStudent.enabled=='0'}">
								<a href="<c:url value="able/${tempStudent.id}"></c:url>"><button class="btn btn-success"
										type="submit" id="${tempStudent.id}" name="able">
										<i class="remove user icon"></i> Enable
									</button></a>
							</c:if></td>
					</sec:authorize>
				</tr>
			</c:forEach>
			
			</tbody>
		</table>
	  </div>



	<%@ include file="/WEB-INF/view/jspf/footer.jspf"%>