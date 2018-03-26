<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/principal.css" rel="stylesheet" type="text/css" />
	<title>Tela de login</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div id="main" class="container">
		<div class="row" align=center>
			 <div id="mensagem" class="container">
				<c:if test="${not empty mensagem}">
					<div class="col-md-12">
						<div class="alert alert-danger alert-dismissable" style="margin-top: 10px; color: red; width: 350px; height: 50px;">
							<a href="Login.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
							<strong>${mensagem}</strong>
						</div>
					</div>
				</c:if>
				<div class="formulario">
					<div class="form-group col-md-12">
						<h2 class="page-header">Login</h2>
						<form action="fazer_Login" method="post" style="margin-left: 20px; margin-right: 20px">
							<div class="row col-md-12">
								<div class="form-group">
									<div class="input-group col-md-12">
										<div class="input-group-addon">
											<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
										</div>
										<input type="text" name="username" id="username" class="form-control" maxlength="60" placeholder="Login" required />
									</div>
								</div>
								<div class="form-group">
									<div class="input-group col-md-12">
										<div class="input-group-addon">
											<span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span>
										</div>
										<input type="password" name="password" id="password" class="form-control" placeholder="Senha" required />
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-success" name="acao" value="fazer_Login">
										<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>Entrar
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>