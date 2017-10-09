<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>

	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />

		<h2>Owner Information</h2>

		<table class="table table-striped" style="width: 836px;">
			<tr>
				<th>Name</th>
				<td><b><c:out value="${owner.firstName} ${owner.lastName}" /></b></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><c:out value="${owner.address}" /></td>
			</tr>
			<tr>
				<th>City</th>
				<td><c:out value="${owner.city}" /></td>
			</tr>
			<tr>
				<th>Telephone</th>
				<td><c:out value="${owner.telephone}" /></td>
			</tr>
			<tr>
				<th>Pay Preference</th>
				<td><c:out value="${owner.payPreference}" /></td>
			</tr>
			<tr>
				<td><spring:url value="{ownerId}/edit.html" var="editUrl">
						<spring:param name="ownerId" value="${owner.id}" />
					</spring:url> <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit
						Owner</a></td>
				<td><spring:url value="{ownerId}/pets/new.html" var="addUrl">
						<spring:param name="ownerId" value="${owner.id}" />
					</spring:url> <a href="${fn:escapeXml(addUrl)}" class="btn btn-success">Add
						New Pet</a></td>
			</tr>
		</table>

		<h2>Pets and Visits</h2>

		<c:forEach var="pet" items="${owner.pets}">
			<table class="table" style="width: 836px;">
				<tr>
					<td valign="top" style="width: 336px;">
						<dl class="dl-horizontal">
							<dt>Name</dt>
							<dd>
								<c:out value="${pet.name}" />
							</dd>
							<dt>Birth Date</dt>
							<dd>
								<joda:format value="${pet.birthDate}" pattern="yyyy-MM-dd" />
							</dd>
							<dt>Type</dt>
							<dd>
								<c:out value="${pet.type.name}" />
							</dd>
							<dt>Weight</dt>
							<dd>
								<c:out value="${pet.weight}" />
							</dd>
							<dt>Comments</dt>
							<dd>
								<c:out value="${pet.comments}" />
							</dd>
							<dt>Character</dt>
							<dd>
								<c:out value="${pet.character}" />
							</dd>
						</dl>
					</td>
					<td valign="top" style="width: 500px;">
						<table class="table-condensed">
							<tr>
								<td colspan="4"><datatables:table id="visits_${pet.name}"
										sort="false" data="${pet.visits}" cdn="true" row="visit"
										theme="bootstrap2" cssClass="table table-condensed"
										paginate="false" filter="false" info="false" export="pdf">
										<datatables:column title="Visit Date" property="date">
											<joda:format value="${visit.date}" pattern="yyyy-MM-dd" />
										</datatables:column>
										<datatables:column title="Description" property="description" />
										<datatables:column title="Veterinarian"
											property="vet.firstName" />
										<datatables:column title="Edit" display="HTML">
											<spring:url
												value="/owners/{ownerId}/pets/{petId}/visit/{visitId}/edit"
												var="visitUrl">
												<spring:param name="ownerId" value="${owner.id}" />
												<spring:param name="petId" value="${pet.id}" />
												<spring:param name="visitId" value="${visit.id}" />
											</spring:url>
											<a href="${fn:escapeXml(visitUrl)}">Edit</a>
										</datatables:column>

									</datatables:table></td>
							</tr>
							<tr>
								<td><spring:url value="/owners/{ownerId}/pets/{petId}/edit"
										var="petUrl">
										<spring:param name="ownerId" value="${owner.id}" />
										<spring:param name="petId" value="${pet.id}" />
									</spring:url> <a href="${fn:escapeXml(petUrl)}">Edit Pet</a></td>
								<td><spring:url
										value="/owners/{ownerId}/pets/{petId}/delete" var="petUrl">
										<spring:param name="ownerId" value="${owner.id}" />
										<spring:param name="petId" value="${pet.id}" />
									</spring:url> <a href="${fn:escapeXml(petUrl)}">Delete Pet</a></td>
								<td><spring:url
										value="/owners/{ownerId}/pets/{petId}/visits/new"
										var="visitUrl">
										<spring:param name="ownerId" value="${owner.id}" />
										<spring:param name="petId" value="${pet.id}" />
									</spring:url> <a href="${fn:escapeXml(visitUrl)}">Add Visit</a></td>
								<td><spring:url
										value="/owners/{ownerId}/pets/{petId}/visits/filter"
										var="visitUrl">
										<spring:param name="ownerId" value="${owner.id}" />
										<spring:param name="petId" value="${pet.id}" />
									</spring:url> <a href="${fn:escapeXml(visitUrl)}">Filter</a></td>
							</tr>
						</table>

					</td>

				</tr>
			</table>
		</c:forEach>

		<jsp:include page="../fragments/footer.jsp" />

	</div>

</body>

</html>
