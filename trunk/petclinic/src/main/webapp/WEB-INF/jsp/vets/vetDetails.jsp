<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Vet Information</h2>

    <table class="table table-striped" style="width:600px;">
        <tr>
            <th>First Name</th>
            <td><b><c:out value="${vet.firstName}"/></b></td>
        </tr>
        <tr>
            <th>Last Name</th>
            <td><b><c:out value="${vet.lastName}"/></b></td>
        </tr>
        <tr>
        	<th>Specialities</th>
				<td><c:forEach var="specialty" items="${vet.specialties}">
						<c:out value="${specialty.name}" />
					</c:forEach> 
					<c:if test="${vet.nrOfSpecialties == 0}">none</c:if></td>
		</tr>
		<tr>
            <th>House Calls</th>
            	<td><b><c:if test="${!vet.houseCalls}">No</c:if>
            	<c:if test="${vet.houseCalls}">Yes</c:if></b></td>
        </tr>
        <tr>
            <th>Telephone</th>
            <td><c:out value="${vet.telephone}"/></td>
        </tr>
        <tr>
            <td>
            	<c:choose>
	   				<c:when test="${todayVisits != null}">
	                </c:when>
		   			<c:otherwise> 
		   				<spring:url value="{vetId}/edit.html" var="editUrl">
		                    <spring:param name="vetId" value="${vet.id}"/>
		                </spring:url>
		                <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit Vet</a>
		   			</c:otherwise>
   				 </c:choose>
             </td>
         </tr>
    </table>
    
    <h2>Visits</h2>
	
	<c:choose>
	   <c:when test="${todayVisits != null}">
	   	<table class="table-condensed">
			<thead>
				<tr>
					<th>Visit Date</th>
					<th>Description</th>
					<th>Pet</th>
				</tr>
			</thead>
			<c:forEach var="visit" items="${todayVisits}">
				<tr>
					<td><joda:format value="${visit.date}" pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${visit.description}" /></td>
					<td><c:out value="${visit.pet.name}" /></td>
				</tr>
			</c:forEach>
		</table>
	   </c:when>
	   <c:otherwise>
		<spring:url value="{vetId}/today" var="todayVisits">
			<spring:param name="vetId" value="${vet.id}"/>
		</spring:url>
		<a href="${fn:escapeXml(todayVisits)}">Only today visits</a>
		
		<table class="table-condensed">
			<thead>
				<tr>
					<th>Visit Date</th>
					<th>Description</th>
					<th>Pet</th>
					<th>Edit</th>
				</tr>
			</thead>
			<c:forEach var="visit" items="${vet.visits}">
				<tr>
					<td><joda:format value="${visit.date}" pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${visit.description}" /></td>
					<td><c:out value="${visit.pet.name}" /></td>
					<td>
                       <spring:url value="/vets/{vetId}/pets/{petId}/visit/{visitId}/edit" var="visitUrl">
                       	  <spring:param name="vetId" value="${vet.id}"/>
                       	  <spring:param name="petId" value="${visit.pet.id}"/>
		                  <spring:param name="visitId" value="${visit.id}"/>
		              </spring:url>
		              <a href="${fn:escapeXml(visitUrl)}">Edit</a>
                   </td>
				</tr>
			</c:forEach>
		</table>
       </c:otherwise>
    </c:choose>
		
	

    <jsp:include page="../fragments/footer.jsp"/>

</div>

</body>

</html>
