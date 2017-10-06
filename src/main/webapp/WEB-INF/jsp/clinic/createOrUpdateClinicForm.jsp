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
        <c:when test="${clinic['new']}"><c:set var="method" value="post"/></c:when>
        <c:otherwise><c:set var="method" value="put"/></c:otherwise>
    </c:choose>

    <h2>
         Clinic Information
    </h2>
    <form:form modelAttribute="clinic" method="${method}" class="form-horizontal" id="edit-clinic-form">
    
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
        		<petclinic:inputField label="Address" name="address"/>
        		<petclinic:inputField label="VAT" name="VAT"/>
		    </div>
		  
		</div>
       
        <div class="form-actions">
            <c:choose>
                <c:when test="${clinic['new']}">
                    <button type="submit">Insert info</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Info</button>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
    
    <jsp:include page="../fragments/footer.jsp"/>
    
</div>
</body>

</html>
