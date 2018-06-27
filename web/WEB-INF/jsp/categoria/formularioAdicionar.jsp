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
                    <form action="<c:url value='/adicionarCategoria'/>" method="post">                      
                        <div class="form-group">
                            <label for="exampleInputName">Nome </label>
                            <input name="nome" type="text" class="form-control" id="exampleInputNome" aria-describedby="nomeHelp" placeholder="código da categoria do produto">
                            <small id="nomeHelp" class="form-text text-muted"></small>
                        </div>                    
                        <div class="form-group">
                            <label for="exampleInputData">Descrição </label>
                            <input name="descricao" type="text" class="form-control" id="exampleInputLogin" aria-describedby="loginHelp" placeholder="nome da cetegoria do produto">
                            <small id="loginHelp" class="form-text text-muted"></small>
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
