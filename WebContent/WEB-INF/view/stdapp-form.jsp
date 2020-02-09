<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>


<div class="ui segment">

	<h3>Make an Application</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Company Name</th>
			<th>Job Name</th>
			<th>Available Positions</th>
			<th>Job Description</th>
			<c:forEach var="tempjob_offers" items="${job_offers}">
				<c:if test="${tempjob_offers.enabled=='1'}">
					<tr>
						<td>${tempjob_offers.companyName}</td>
						<td>${tempjob_offers.jobName}</td>
						<td>${tempjob_offers.availablePositions}</td>
						<td>${tempjob_offers.jobDescription}</td>
						<td>
					</tr>
				</c:if>
			</c:forEach>
	</table>



	<form:form action="saveStdapps" modelAttribute="Studentapplications"
		method="POST" class="ui form">


		<div class="input-group mb-3">

			<form:input path="companyName" type="text" class="form-control"
				placeholder="Company Name" aria-label="Recipient's username"
				aria-describedby="button-addon2"  />
			<div class="input-group-append"></div>
		</div>


		<div class="input-group mb-3">

			<form:input path="job" type="text" class="form-control"
				placeholder="Job Name" aria-label="Recipient's username"
				aria-describedby="button-addon2"  />
			<div class="input-group-append"></div>
		</div>



		<button class="btn btn-outline-dark" type="submit"
			id="button-addon2" style="margin: auto; display: block;">Save</button>


	</form:form>


</div>