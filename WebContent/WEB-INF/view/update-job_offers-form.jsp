<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>



<h3>Update a Job Offer</h3>

<form:form action="updateJob_offers" modelAttribute="job_offers"
	method="POST" class="ui form">
	<label>ID of Job Offer</label>
	<div class="input-group mb-3">

		<form:input path="id" type="number" class="form-control" placeholder="xxxxx"
			aria-label="Recipient's username" aria-describedby="button-addon2" />

	</div>


	<label>Company Name</label>
	<div class="input-group mb-3">

		<form:input path="companyName" type="text" class="form-control" placeholder="Johnson's Company"
			aria-label="Recipient's username" aria-describedby="button-addon2" />
	</div>

	<label>Job Name</label>
	<div class="input-group mb-3">

		<form:input path="jobName" type="text" class="form-control" placeholder="Entrepreneur"
			aria-label="Recipient's username" aria-describedby="button-addon2" />
	</div>
	<label>Available Possitions</label>
	<div class="input-group mb-3">

		<form:input path="availablePositions" type="number" class="form-control" placeholder="xx"
			aria-label="Recipient's username" aria-describedby="button-addon2" />
	</div>
	<label>Job Description</label>
	<div class="input-group mb-3">
		<form:input path="jobDescription" type="text" class="form-control" 
			aria-label="Recipient's username" aria-describedby="button-addon2" />
	</div>

	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICE')">

		<label>Condition</label>
		<div class="input-group mb-3">
			<form:input path="enabled" type="text" class="form-control"
				placeholder="(1=Accept or 0=Pending)"
				aria-label="Recipient's username" aria-describedby="button-addon2" />
		</div>
	</sec:authorize>


	<div class="input-group-append">
		<button class="btn btn-outline-dark" type="submit"
			id="button-addon2" style="margin: auto; display: block;">Save</button>
	</div>

</form:form>

