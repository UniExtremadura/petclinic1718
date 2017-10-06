<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Find Pet</h2>

    <spring:url value="/pets.html" var="formUrl"/>
    <form:form  modelAttribute="pet" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-owner-form">
        <div class="control-group">
            <petclinic:inputField label="Name" name="name"/>
        </div>
        
        <div class="control-group">
            <petclinic:selectField name="type" label="Type" names="${types}" size="3"/>
        </div>
        
        <div class="control-group">		        	        
		    <petclinic:selectField name="breed" label="Breed" names="${breeds}" size="3"/>
		</div>
            
            <div class="form-actions">
                <button type="submit">Find Pet</button>
            </div>
        
    </form:form>

    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
