<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>


<body>
<script>
    $(function () {
        $("#date").datepicker({ dateFormat: 'yy/mm/dd'});
    });
</script>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2><c:if test="${visit['new']}">New </c:if>Visit</h2>

    <b>Pet</b>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Birth Date</th>
            <th>Weight</th>
            <th>Comments</th>
            <th>Type</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tr>
            <td><c:out value="${visit.pet.name}"/></td>
            <td><joda:format value="${visit.pet.birthDate}" pattern="yyyy/MM/dd"/></td>
            <td><c:out value="${visit.pet.weight}"/></td>
            <td><c:out value="${visit.pet.comments}"/></td>
            <td><c:out value="${visit.pet.type.name}"/></td>
            <td><c:out value="${visit.pet.owner.firstName} ${visit.pet.owner.lastName}"/></td>
        </tr>
    </table>

    <form:form modelAttribute="visit">
	    <div style="width:100%; overflow: hidden;">
		    <div style="float:left; width:50%;">
		        <div class="control-group">
		            <label class="control-label">Date </label>
		
		            <div class="controls">
		                <form:input path="date"/>
		                <span class="help-inline"><form:errors path="date"/></span>
		            </div>
		        </div>
		        <div class="control-group">
		            <label class="control-label">Description </label>
		
		            <div class="controls">
		                <form:input path="description"/>
		                <span class="help-inline"><form:errors path="description"/></span>
		            </div>
		        </div>
		        <div class="control-group">
		            <petclinic:selectVet name="vet" label="Vets " names="${vets}" size="5"/>
		        </div>
		    
		    </div>
		    <div style="float:left; width:50%;">
		    	<div class="control-group">
		            <label class="control-label">Diagnosis </label>
		
		            <div class="controls">
		                <form:textarea rows="2" cols="15" path="diagnosis"/>
		                <span class="help-inline"><form:errors path="diagnosis"/></span>
		            </div>
		        </div>
		        <div class="control-group">
		            <label class="control-label">Treatment </label>
		
		            <div class="controls">
		                <form:textarea rows="2" cols="15" path="treatment"/>
		                <span class="help-inline"><form:errors path="treatment"/></span>
		            </div>
		        </div>
		    
		    </div>
		</div>
        <div class="form-actions">
            <input type="hidden" name="petId" value="${visit.pet.id}"/>
            <c:choose>
                <c:when test="${visit['new']}">
                    <button type="submit">Add Visit</button>
                </c:when>
                <c:otherwise>
                    <button type="submit"  class="btn btn-default" >Update Visit</button>
              
                    <spring:url value="/owners/{ownerId}/pets/{petId}/visits/new" var="newVisitURL">
                        <spring:param name="ownerId" value="${visit.pet.owner.id}"/>
                        <spring:param name="petId" value="${visit.pet.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(newVisitURL)}" class="btn btn-default">Create New Visit</a>
                    
                    <spring:url value="/owners/{ownerId}/pets/{petId}/visits/{visitId}/delete" var="delVisitURL" >
                        <spring:param name="ownerId" value="${visit.pet.owner.id}"/>
                        <spring:param name="petId" value="${visit.pet.id}"/>
                        <spring:param name="visitId" value="${visit.id}"/>
                    </spring:url>       
                    <a href="${fn:escapeXml(delVisitURL)}" class="btn btn-default">Delete Visit</a>
			                    
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>

    <br/>
    <b>Previous Visits</b>
    <table style="width: 333px;">
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Veterinarian</th>
        </tr>
        <c:forEach var="visit" items="${visit.pet.visits}">
            <c:if test="${!visit['new']}">
                <tr>
                    <td><joda:format value="${visit.date}" pattern="yyyy/MM/dd"/></td>
                    <td><c:out value="${visit.description}"/></td>
                    <td><c:out value="${visit.vet.firstName}"/></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>

</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
