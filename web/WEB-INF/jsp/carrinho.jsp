<%-- 
    Document   : carrinho
    Created on : 16/06/2018, 16:55:48
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
    <body onload="listarProdutos()">
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
        <div class="areaMenu">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div id="itensCarrinho"></div>
                        <form>
                            <div class="row">
                                <div class="col">
                                    <button type="button" class="btn btn-primary" onclick="limparCarrinho()">Limpar carrinho</button>
                                    <a href="<c:url value='/efetuarCompra'/> "> <button  type="button" class="btn btn-outline-primary">Efetuar Compra</button> </a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <h1 class="rodape"> Criado por @umalgoritmo e @david - Copyright © 2018-2018.</h1>
        </footer>
        <!-- jQuery (necessario para os plugins Javascript do Bootstrap) -->
        <script src="<c:url value='/resources/js/jquery.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/resources/js/funcoes.js'/>"></script>  
    </body>
</html>