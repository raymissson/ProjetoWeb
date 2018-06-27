<%-- 
    Document   : comprarProduto-falha
    Created on : 19/06/2018, 14:52:33
    Author     : Aluno
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                            <img src="img/logo.png" width="200" height="150" alt="">
                        </a>
                    </nav>
                </div>
            </nav>
        </header>
        <br/>
        <h1> A Compra não foi feita com sucesso! </h1>

        <footer>
            <h1 class="rodape"> Criado por @umalgoritmo e @david - Copyright © 2018-2018.</h1>
        </footer>
        <!-- jQuery (necessario para os plugins Javascript do Bootstrap) -->
        <script src="<c:url value='/resources/js/jquery.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/resources/js/funcoes.js'/>"></script>  
    </body>
</html>