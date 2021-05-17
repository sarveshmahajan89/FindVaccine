<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>
<div class="container form-style">
	<form:form method="post" modelAttribute="userData">
		<fieldset class="form-group">
			<form:label path="userName">Name</form:label>
			<form:input path="userName" type="text" class="form-control"
				required="required" />
			<form:errors path="userName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
        			<form:label path="userMob">Mobile Number</form:label>
        			<form:input path="userMob" type="number" class="form-control"
        				required="required" />
        			<form:errors path="userMob" cssClass="text-warning" />
        </fieldset>
		<fieldset class="form-group">
        			<form:label path="age">Age</form:label>
        			<form:input path="age" type="number" class="form-control"
        				required="required" />
        			<form:errors path="age" cssClass="text-warning" />
        </fieldset>
		<fieldset class="form-group">
        			<form:label path="pin">Pin Code</form:label>
        			<form:input path="pin" type="number" class="form-control"
        				required="required" />
        			<form:errors path="pin" cssClass="text-warning" />
        </fieldset>
		<fieldset class="form-group">
			<form:label path="vaccinedose">Please select type of Dose ?</form:label>
			<form:radiobutton path="vaccinedose" value="dose1" class="form-control radio-button"
						required="required" /> Dose 1
			<form:radiobutton path="vaccinedose" value="dose1" class="form-control radio-button"
						required="required" />Dose 2
		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>
<%@ include file="footer.jspf" %>