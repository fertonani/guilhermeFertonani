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
		<form action="ExtratoJSP.do" action="post">
			<h3>Extrato</h3>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="agencia">Agência</label> <input type="text"
						class="form-control" name="agencia" id="agencia" required
						maxlength="15">
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label for="conta">Conta</label> <input type="text"
						class="form-control" name="conta" id="conta" required
						maxlength="60">
				</div>
			</div>

			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="extrato">Visualizar extrato</button>
				</div>
			</div>
			
		</form>
	</div>
<c:import url="rodape.jsp" />