<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<br/>
<div class="container">
	<table class="table table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th>Andamento</th>
				<th>Descrição</th>
			<tr/>
			<tbody>
			<c:forEach items="${routeplan}" var="routeplan">
				<tr>
					<td>${routeplan.andamento}</td>
					<td>${routeplan.descRoutePlan}</td>
				<tr/>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="common/footer.jspf"%>