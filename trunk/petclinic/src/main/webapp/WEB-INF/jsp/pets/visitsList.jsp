<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<jsp:include page="../fragments/headTag.jsp" />

<body>
<script>
    $(function () {
        $("#start").datepicker({ dateFormat: 'yy/mm/dd'});
        $("#end").datepicker({ dateFormat: 'yy/mm/dd'});
    });
</script>
	
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h2>Visits</h2>
		
		<form:form modelAttribute="pet" method="POST" class="form-horizontal" >
		<table  style="width:100%;">			
			<tr>
				<td>Start</td>
				<td><input name="start" id="start"/></td>
				<td>End</td>
				<td><input name="end" id="end"/></td>
				<td><button type="submit">Filter</button></td>
			</tr>			
		</table>
		
		</form:form>		

		<table  style="width:100%;">
			<thead>
				<tr>
					<th>Visit Date</th>
					<th>Description</th>
					<th>Veterinarian</th>
				</tr>
			</thead>
			<c:forEach var="visit" items="${visits}">
				<tr>
					<td><joda:format value="${visit.date}" pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${visit.description}" /></td>
					<td><c:out value="${visit.vet.firstName}" /></td>
				</tr>
			</c:forEach>
		</table>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
</body>

</html>
