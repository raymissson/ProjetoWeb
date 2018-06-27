<%-- 
    Document   : listarAdministradores
    Created on : 28/05/2018, 09:28:43
    Author     : david
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!doctype html>
<html>
	<head> 
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>All Arts</title>

            <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>"
        <link rel="stylesheet" href="<c:url value='/resources/css/estilos.css'/>" 
	
	</head>	
	<body>
            <div class="row">
            <div class="col-sm-12">
            <table class="table"> 
            <tr>          
                <th>Nome</th>
                <th>Descricao</th>
                <th>Imagem</th>  
                <th>Preco</th>
                <th>Categoria</th>  
                <th colspan="2">Alterar/Excluir </th>
            </tr>
                <c:forEach items="${listaProdutos}" var="produto">
            <tr>
                <td>${produto.nome}</td>     
                <td>${produto.descricao}</td> 
                <td><img src="data:image/jpg;base64,${produto.imagem}" class="imagem" alt="Responsive image"></td>
                <td>${produto.preco}</td>
                <td>${produto.categoria}</td>
                <td>
                    <a href="formEditarProduto?id=${produto.id}"> Alterar </a> 
                </td>
                <td>
                    <a href="formExcluirProduto?id=${produto.id}"> Excluir </a> 
                </td>
            </tr>
                </c:forEach>
            </table>               
		<!-- jQuery (necessario para os plugins Javascript do Bootstrap) -->
        <script src="<c:url value='/resources/js/jquery.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/resources/js/funcoes.js'/>"></script>  
	</body>
</html>