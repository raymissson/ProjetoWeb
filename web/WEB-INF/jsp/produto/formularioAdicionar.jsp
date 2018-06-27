<%-- 
    Document   : formularioAdicionar
    Created on : 03/06/2018, 20:58:33
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
                    <form action="<c:url value='/adicionarProduto'/>" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="exampleInputName">Nome</label>
                            <input name="nome" type="text" class="form-control" id="exampleInputNome" aria-describedby="nomeHelp" placeholder="">
                            <small id="nomeHelp" class="form-text text-muted"></small>
                        </div> 
                        <div class="form-group">
                            <label for="exampleInputDescicao">Descrição</label>
                            <input name="descricao" type="text" class="form-control" id="exampleInputNome" aria-describedby="nomeHelp" placeholder="">
                            <small id="nomeHelp" class="form-text text-muted"></small>
                        </div>                    
                        <div class="form-group">
                            <label for="exampleInputPhoto">Imagem</label>
                            <input name="photo" type="file" class="form-control" id="exampleInputNome" aria-describedby="caminhoHelp" placeholder="">
                            <small id="nomeHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPreco">Preço</label>
                            <input name="preco_venda" type="text" class="form-control" id="exampleInputNome" aria-describedby="nomeHelp" placeholder="">
                            <small id="nomeHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Categoria</label>
                            <select name="categoria_cod_categoria" class="form-control" id="exampleFormControlSelect1"> 
                                <c:forEach items="${listaCategoria}" var="categoria">
                                <option value="${categoria.id}">${categoria.nome}</option>
                                </c:forEach>
                            </select>
                                
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
