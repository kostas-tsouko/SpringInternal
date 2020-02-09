<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>


	<h3>Update a Student</h3>

	<form:form action="updateStudent" modelAttribute="student" method="POST" class="ui form">
	<label>Student ID</label> 
			<div class="input-group mb-3">		
			<form:input path="id" type="number" class="form-control" placeholder="3xxxx"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>First Name</label>
	<div class="input-group mb-3">
			
			<form:input path="firstName" type="text" class="form-control" placeholder="Jonny"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>Last Name</label>
		<div class="input-group mb-3">
			
			<form:input path="lastName" type="text" class="form-control" placeholder="Johnson"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>Email</label> 
	<div class="input-group mb-3">
			
			<form:input path="email" type="text" class="form-control" placeholder="Jonny_Johnson@example.gr"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>Semester</label> 
		<div class="input-group mb-3">
			
			<form:input path="semester" type="number" class="form-control" placeholder="xx"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>Subjects Owned</label> 
	<div class="input-group mb-3">
			
			<form:input path="subjects_owned" type="number" class="form-control" placeholder="xx"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>Resume</label>
	<div class="input-group mb-3">
			 
			<form:input path="resume" type="text" class="form-control"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>Username</label> 
			<div class="input-group mb-3">
			
			<form:input path="username" type="text" class="form-control" placeholder="1xxxx"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>Password</label> 
			<div class="input-group mb-3">
			
			<form:input path="password" type="text" class="form-control" 
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
		<label>Enabled</label> 
		<div class="input-group mb-3">
			<form:input path="enabled" type="number" class="form-control" placeholder="(1=Accept or 0=Pending)"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
			<button class="btn btn-outline-dark" type="submit"
			id="button-addon2" style="margin: auto; display: block;">Save</button>
	</form:form>

