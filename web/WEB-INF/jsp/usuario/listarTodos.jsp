<%-- 
    Document   : listarAdministradores
    Created on : 28/05/2018, 09:28:43
    Author     : david
--%>

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
                        <th>ID</th>            
                        <th>Nome</th>
                        <th>Login</th>                  
                        <th colspan="2">Alterar/Excluir </th>
                    </tr>
                    <c:forEach items="${listaUsuarios}" var="usuario">
                        <tr>
                            <td>${usuario.id}</td>     
                            <td>${usuario.nome}</td>
                            <td>${usuario.login}</td>                 
                            <td>
                                <a href="formExibirUsuario?id=${usuario.id}"> Alterar </a> 
                            </td>
                            <td>
                                <a href="formExcluirUsuario?id=${usuario.id}"> Excluir </a> 
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