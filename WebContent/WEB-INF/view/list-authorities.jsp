
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<body>
	<div class="ui segment" >
		<h3>List of Authorities</h3>

		<!--  add our html table here -->
		<table class="ui celled  striped table" id="list">
			<thead>
				<th>ID</th>
				<th>Authority</th>
			</thead>
			<!-- loop over and print our customers -->
			<c:forEach var="tempAuthority" items="${authorities}">

				<tr>
					<td>${tempAuthority.id}</td>
					<td>${tempAuthority.authority}</td>
					<td>
				</tr>
			</c:forEach>
		</table>
	</div>



	<%@ include file="/WEB-INF/view/jspf/footer.jspf"%>