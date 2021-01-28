<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<form:form method="post" modelAttribute="coordenadas">
		<form:hidden path="idCord" />
		<fieldset class="form-group">
			<form:label path="lat">Latitude</form:label>
			<form:input path="lat" type="text" class="form-control"
				required="required" />
			<form:errors path="lat" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="lng">Longitude</form:label>
			<form:input path="lng" type="text" class="form-control"
				required="required" />
			<form:errors path="lng" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="veiculoId">Id Veiculo</form:label>
			<form:input path="veiculoId" type="text"  class="form-control"
				required="required" />
			<form:errors path="veiculoId" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="diaHoraAtual">Data</form:label>
			<form:input path="diaHoraAtual" type="text"  class="form-control"
				required="required" />
			<form:errors path="diaHoraAtual" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-sucess">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
