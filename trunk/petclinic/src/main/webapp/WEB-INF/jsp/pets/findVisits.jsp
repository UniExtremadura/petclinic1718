<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
<script>
    $(function () {
        $("#date").datepicker({ dateFormat: 'yyyy-mm-dd'});
    });
</script>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />

		<h2>Find Visit</h2>

		<spring:url value="/pets/visits.html" var="formUrl" />
		<form:form modelAttribute="visit" action="${fn:escapeXml(formUrl)}"
			method="get" class="form-horizontal" id="search-visit-form">
			<div class="control-group">
				<label class="control-label">Date </label>

				<div class="controls">
					<form:input path="date" />
					<span class="help-inline"><form:errors path="date" /></span>
				</div>
			</div>


			<div class="form-actions">
				<button type="submit">Find Visits</button>
			</div>

		</form:form>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
</body>
</html>
