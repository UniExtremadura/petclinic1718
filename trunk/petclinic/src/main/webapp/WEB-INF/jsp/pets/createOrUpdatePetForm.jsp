<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>
<body>

<script>
    $(function () {
        $("#birthDate").datepicker({ dateFormat: 'yy/mm/dd'});
    });
</script>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>    

    <h2>
        <c:if test="${pet['new']}">New </c:if>
        Pet
    </h2>

    <form:form modelAttribute="pet" method="post"
               class="form-horizontal">
        <div class="control-group" id="owner">
            <label class="control-label">Owner </label>

            <c:out value="${pet.owner.firstName} ${pet.owner.lastName}"/>
        </div>
        
        <style type="text/css">
			input {
   				width: 100px;
			}
			select{
				width: 100px;
			}
		</style>
		<div style="width:100%; overflow: hidden;">
		    <div style="float:left; width:50%;">
		        <petclinic:inputField label="Name" name="name"/>
        		<petclinic:inputField label="Birth Date" name="birthDate"/>
        		<petclinic:inputField label="Weight (kg.)" name="weight"/>
        		
        		<div class="control-group">
		            <label class="control-label">Comments </label>
		
		            <div class="controls">
		                <form:textarea rows="4"  path="comments"  style="width:60%;"/>
		                <span class="help-inline"><form:errors path="comments"/></span>
		            </div>
		        </div>
        		<petclinic:inputField label="Allergies" name="allergies"/>
		    </div>
		    <div style="float:right; width:50%;">
		        <petclinic:selectField label="Character" name="character" size="1" names="${characters}"/>
		        <petclinic:selectField name="type" label="Type" names="${types}" size="5"/>		        	        
		        <petclinic:selectField name="breed" label="Breed" names="${breeds}" size="1"/>		        
		    </div>
		</div>
        
        <div class="form-actions">
            <c:choose>
                <c:when test="${pet['new']}">
                    <button type="submit">Add Pet</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Pet</button>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
    <c:if test="${!pet['new']}">
    </c:if>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>

</html>
