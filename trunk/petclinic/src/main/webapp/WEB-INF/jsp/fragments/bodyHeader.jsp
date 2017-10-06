<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:url value="/resources/images/banner-graphic.png" var="banner"/>
<img src="${banner}" style="width: 731px;"/>

<div class="navbar" style="width: 701px;">
    <div class="navbar-inner">
        <ul class="nav">
            <li style="width: 90px;"><a href="<spring:url value="/" htmlEscape="true" />"><i class="icon-home"></i>
                Home</a></li>
            <li style="width: 130px;"><a href="<spring:url value="/owners/find.html" htmlEscape="true" />"><i
                    class="icon-search"></i> Find owners</a></li>
            <li style="width: 120px;"><a href="<spring:url value="/pets/find.html" htmlEscape="true" />"><i
                    class="icon-search"></i> Find pets</a></li>
            <li style="width: 135px;"><a href="<spring:url value="/vets.html" htmlEscape="true" />"><i
                    class="icon-th-list"></i> Veterinarians</a></li>
            <li style="width: 90px;"><a href="<spring:url value="/oups.html" htmlEscape="true" />"
                                        title="trigger a RuntimeException to see how it is handled"><i
                    class="icon-warning-sign"></i> Error</a></li>
            <li style="width: 80px;"><a href="#" title="not available yet. Work in progress!!"><i
                    class=" icon-question-sign"></i> Help</a></li>
        </ul>
    </div>
</div>
	