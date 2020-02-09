<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>


	<h3>Add a Company</h3>

	<form:form action="saveCompany" modelAttribute="company" method="POST"
		class="ui form">
		
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
		
			<label>Username</label> 
			<div class="input-group mb-3">	
			<form:input path="username" type="text" class="form-control" placeholder="1xxxx"
			aria-label="Recipient's username" aria-describedby="button-addon2"/>
		</div>
			
			<label>Password</label> 
			<div class="input-group mb-3">	
			<form:input path="password" type="text" class="form-control"
			aria-label="Recipient's username" aria-describedby="button-addon2" />
		</div>

			<label>Company Name</label>
			<div class="input-group mb-3">	
			<form:input path="company_name" type="text" class="form-control"
			aria-label="Recipient's username" aria-describedby="button-addon2" placeholder="Johnson's Company"/>
		</div>
			<label>Condition</label> 
			<div class="input-group mb-3">	
			<form:input path="enabled" type="text" class="form-control"
			aria-label="Recipient's username" aria-describedby="button-addon2" placeholder="(1=Accept or 0=Pending)"/>
		</div>
				<button class="btn btn-outline-dark" type="submit"
			id="button-addon2" style="margin: auto; display: block;">Save</button>
			
			
		
		
	</form:form>
