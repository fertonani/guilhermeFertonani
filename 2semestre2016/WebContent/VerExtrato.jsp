<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Extrato - Caixa eletronico</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="menu.jsp" />
	<div id="main" class="container">
		<div id="list" class="row">
			<div class="table-responsive col-md-12">
				<table class="table table-striped" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th>Numero de doc</th>
							<th>Data de registro</th>
							<th>Tipo</th>
							<th>Valor</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="extrato" items="${listaExtrato }">
							<tr>
								<td>${extrato.numDoc }</td>
								<td>${extrato.data }</td>
								<td>${extrato.tipo }</td>
								<td>${extrato.valor }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>
		</div>
	</div>

	<c:import url="rodape.jsp" />