<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2>Visits</h2>
    
    <datatables:table id="visits" data="${visits}" cdn="true" row="visit" theme="bootstrap2" 
                      cssClass="table table-striped" paginate="false" info="false" export="pdf">
        <datatables:column title="Visit Date" cssStyle="width: 150px;">
        <joda:format value="${visit.date}" pattern="yyyy-MM-dd" />
        </datatables:column>  
        <datatables:column title="Description"  cssStyle="width: 200px;" property ="description"/>
        <datatables:column title="Veterinarian" cssStyle="width: 150px;" property="vet.firstName"/>
    </datatables:table>
    
    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
