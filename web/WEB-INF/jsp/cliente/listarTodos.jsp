<%-- 
    Document   : formularioListar
    Created on : 03/06/2018, 18:29:11
    Author     : Raymison
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="col-sm-3">
                    <nav class="navbar navbar-dark bg-dark">
                        <a class="navbar-brand" href="index.html">
                            <img src="<c:url value='/resources/img/logo.png'/>" width="200" height="150" alt="">
                        </a>
                    </nav>
                </div>
            </nav>
        </header>
        <div class="row">
            <div class="col-sm-12">
                <table class="table"> 
                    <tr>
                        <th>codigo</th>            
                        <th>cpf</th>
                        <th>nome</th>
                        <th>email</th>  
                        <th>telefone</th>  
                        <th>login</th>
                        <th colspan="2">Alterar/Excluir </th>
                    </tr>
                    <c:forEach items="${listaClientes}" var="cliente">
                        <tr>
                            <td>${cliente.id}</td>     
                            <td>${cliente.cpf}</td>
                            <td>${cliente.nome}</td> 
                            <td>${cliente.email}</td>
                            <td>${cliente.telefone}</td>
                            <td>${cliente.login}</td>
                            <td>
                                <a href="editarCliente?id=${cliente.id}"> Alterar </a> 
                            </td>
                            <td>
                                <a href="excluirCliente?id=${cliente.id}"> Excluir </a> 
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
