<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>


	<h3>Update a Company</h3>

	<form:form action="updateCompany" modelAttribute="company" method="POST"
		class="ui form">
		<label>ID of Company</label>
		<div class="input-group mb-3">
			
			<form:input path="id" type="number" class="form-control"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
			
		</div>
	<div class="input-group mb-3">
			
			<form:input path="firstName" type="text" class="form-control"
				placeholder="First Name" aria-label="Recipient's username"
				aria-describedby="button-addon2" />
			
		</div>
		<div class="input-group mb-3">
		
			<form:input path="lastName" type="text" class="form-control"
				placeholder="Last Name" aria-label="Recipient's username"
				aria-describedby="button-addon2"/>
			
		</div>
	<div class="input-group mb-3">
		
			<form:input path="email" type="text" class="form-control"
				placeholder="Email" aria-label="Recipient's username"
				aria-describedby="button-addon2"/>
				
		</div>
	<div class="input-group mb-3">
		
			<form:input path="username" type="text" class="form-control"
				placeholder="Username" aria-label="Recipient's username"
				aria-describedby="button-addon2"/>
		</div>
	<div class="input-group mb-3">
			
			<form:input path="password" type="text" class="form-control"
				placeholder="Password" aria-label="Recipient's username"
				aria-describedby="button-addon2"/>
				
		</div>
		<div class="input-group mb-3">
			
			<form:input path="company_name" type="text" class="form-control"
				placeholder="Company Name" aria-label="Recipient's username"
				aria-describedby="button-addon2"/>
				
		</div>
	<div class="input-group mb-3">
		
			<form:input path="enabled" type="number" class="form-control"
				placeholder="Enabled" aria-label="Recipient's username"
				aria-describedby="button-addon2"/>
		
		</div>
		
		
		<button class="btn btn-outline-dark" type="submit"
			id="button-addon2" style="margin: auto; display: block;">Save</button>
	</form:form>
