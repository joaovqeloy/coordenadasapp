<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<br/>
<div class="container">
<table class="table table-striped table-dark">
	<thead class="thead-dark">
		<tr>
			<th>Andamento</th>
			<th>Latitude</th>
			<th>Longitude</th>
			<th>Descrição</th>
			<th>Raio de Entrega</th>
			<th>Data Inicio</th>
			<th>Data Final</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${plannedstops}" var="plannedstops">
			<tr>
				<td>${plannedstops.andamento}</td>
				<td>${plannedstops.lat}</td>
				<td>${plannedstops.lng}</td>
				<td>${plannedstops.description}</td>
				<td>${plannedstops.deliveryRadius}</td>
				<td>${plannedstops.tempoInicio}</td>
				<td>${plannedstops.tempoFinal}</td>
				
			<tr />
		</c:forEach>
	</tbody>
</table>
<a type="button" class="btn btn-dark" class="nav-item nav-link" href="/planned-stops">Atualizar</a>
</div>
<%@ include file="common/footer.jspf"%>