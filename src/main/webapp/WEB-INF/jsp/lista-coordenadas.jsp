<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<br/>
<div class="container">
	<table class="table table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th>Veiculo Id</th>
				<th>Data</th>
				<th>Latitude</th>
				<th>Longitude</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${coordenadas}" var="coordenadas">
				<tr>
					<td>${coordenadas.veiculoId}</td>
					<td>${coordenadas.diaHoraAtual}</td>
					<td>${coordenadas.lat}</td>
					<td>${coordenadas.lng}</td>
					
				<tr />
			</c:forEach>
		</tbody>
	</table>
	<br />
	<a type="button" class="btn btn-dark" class="nav-item nav-link" href="/ReceiveCoordinate">Adicionar Coordenada</a>
</div>
<%@ include file="common/footer.jspf" %>