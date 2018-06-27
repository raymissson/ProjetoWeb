<%-- 
    Document   : adicionarCliente
    Created on : 26/05/2018, 16:32:52
    Author     : Raymison
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Cadastro</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>"
        <link rel="stylesheet" href="<c:url value='/resources/css/estilos.css'/>" 
    </head>
    <body>
        <header>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <form action="<c:url value='/adicionarCliente'/>" method="post">
                        <div class="form-group">
                            <label for="exampleInputCpf">Cpf</label>
                            <input name="cpf" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="cpfHelp" placeholder="seu cpf">
                            <small id="cpfHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputName">Nome</label>
                            <input name="nome" type="text" class="form-control" id="exampleInputNome" aria-describedby="nomeHelp" placeholder="seu nome">
                            <small id="nomeHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email</label>
                            <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="exemplo@email.com">
                            <small id="emailHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Telefone</label>
                            <input name="telefone" type="text" class="form-control" id="exampleInputTelefone" aria-describedby="telefoneHelp" placeholder="Ex.: (xx) xxxx-xxxxx">
                            <small id="telefoneHelp" class="form-text text-muted"></small>
                        </div>
<!--                        <div class="form-group">
                            <label for="exampleInputData">Data de Nascimento</label>
                            <input name="dataNascimento" type="date" class="form-control" id="exampleInputTelefone" aria-describedby="dataHelp" placeholder="Ex.: dd/mm/yyy">
                            <small id="dataHelp" class="form-text text-muted"></small>
                        </div>-->
                        <div class="form-group">
                            <label for="exampleInputData">Nome de usuario @ (login)</label>
                            <input name="login" type="text" class="form-control" id="exampleInputLogin" aria-describedby="loginHelp" placeholder="apelido">
                            <small id="loginHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Senha</label>
                            <input name="senha" type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha">
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Concordo com os termos</label>
                        </div>
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="<c:url value='/resources/js/jquery.js'/>"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/resources/js/funcoes.js'/>"></script>  
    </body>
</html>
