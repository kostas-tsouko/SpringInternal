<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>


	<h3>Add a Job_offer</h3>

	<form:form action="saveJob_offers" modelAttribute="job_offers" method="POST" class="ui form">
		
			<label>Company Name</label> 
				<div class="input-group mb-3">
			<form:input path="companyName" type="text" class="form-control" placeholder="Johnson's Company"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		
			<label>Job Name</label>
				<div class="input-group mb-3">
			<form:input path="jobName" type="text" class="form-control" placeholder="Entrepreneur"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		
			<label>Available Positions</label> 
				<div class="input-group mb-3">
			<form:input path="availablePositions" type="number" class="form-control" placeholder="xx"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
			
			<label>Job Description</label> 
				<div class="input-group mb-3">
			<form:input path="jobDescription" type="text" class="form-control" 
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
			
<div class="input-group-append">
		<button class="btn btn-outline-dark" type="submit"
			id="button-addon2" style="margin: auto; display: block;">Save</button>
	</div>
	</form:form>

