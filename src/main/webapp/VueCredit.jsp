<%@page import="web.CreditModel"%>
<%
CreditModel model = (CreditModel) request.getAttribute("creditModel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Crédit bancaire</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Simulation de crédit</div>
			<div class="panel-body">
				<form action="calculeMensualite.do" method="post">
					<div class="form-group">
						<label class="control-label">Montant: </label> <input
							class="form-control" type="text" name="montant"
							value="<%=model.getMontant()%>" />
					</div>
					<div class="form-group">
						<label class="control-label">Taux: </label> <input
							class="form-control" type="text" name="taux"
							value="<%=model.getTaux()%>" />
					</div>
					<div class="form-group">
						<label class="control-label">Durée: </label> <input
							class="form-control" type="text" name="duree"
							value="<%=model.getDuree()%>" />
					</div>
					<button class="btn btn-danger" >Calculer</button>
				</form>
				<div>
					<label>Mensualité =</label> <label> <%=model.getMensualite()%></label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>