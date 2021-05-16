<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="userData">
		<fieldset class="form-group">
			<form:label path="userName">Name</form:label>
			<form:input path="userName" type="text" class="form-control"
				required="required" />
			<form:errors path="userName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
        			<form:label path="userMob">Mobile Number</form:label>
        			<form:input path="userMob" type="text" class="form-control"
        				required="required" />
        			<form:errors path="userMob" cssClass="text-warning" />
        </fieldset>
		<fieldset class="form-group">
        			<form:label path="age">Age</form:label>
        			<form:input path="age" type="text" class="form-control"
        				required="required" />
        			<form:errors path="age" cssClass="text-warning" />
        </fieldset>
		<fieldset class="form-group">
        			<form:label path="pin">Pin Code</form:label>
        			<form:input path="pin" type="text" class="form-control"
        				required="required" />
        			<form:errors path="pin" cssClass="text-warning" />
        </fieldset>
		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="footer.jspf" %>