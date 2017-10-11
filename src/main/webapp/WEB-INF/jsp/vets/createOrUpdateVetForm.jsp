<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <c:choose>
        <c:when test="${vet['new']}"><c:set var="method" value="post"/></c:when>
        <c:otherwise><c:set var="method" value="put"/></c:otherwise>
    </c:choose>

    <h2>
        <c:if test="${vet['new']}">New </c:if> Vet
    </h2>
    <form:form modelAttribute="vet" method="${method}" class="form-horizontal" id="edit-vet-form">
    
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
		        <petclinic:inputField label="First Name" name="firstName"/>
        		<petclinic:inputField label="Last Name" name="lastName"/>
		    </div>
		    <div style="float:right; width:50%;">
		        <petclinic:selectField name="specialties" label="Specialty" names="${specialties}" size="3"/>
		    	<petclinic:checkboxField label="House Calls" name="houseCalls"></petclinic:checkboxField>
		    	<petclinic:inputField label="Telephone" name="telephone"/>
		    </div>
		</div>
       
        <div class="form-actions">
            <c:choose>
                <c:when test="${vet['new']}">
                    <button type="submit">Add Vet</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Vet</button>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
    
    <jsp:include page="../fragments/footer.jsp"/>
    
</div>
</body>

</html>
