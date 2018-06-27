<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <div class="col-sm-4">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <a class="navbar-brand" href="index.html">
                        <img src="<c:url value='/resources/img/logo.png'/>" width="300" height="200" alt="">
                    </a>
            </div>
            <div class="col-sm-8">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    manter usuario
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="<c:url value='formAdicionarUsuario'/>">Cadastrar</a>
                                    <a class="dropdown-item" href="<c:url value='formListarUsuario'/>">Exibir </a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    manter categoria
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="<c:url value='formAdicionarCategoria'/>">Cadastrar</a>
                                    <a class="dropdown-item" href="<c:url value='formListarCategoria'/>">Exibir </a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    manter produto
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="<c:url value='formAdicionarProduto'/>">Cadastrar</a>
                                    <a class="dropdown-item" href="<c:url value='listaProduto'/>">Exibir</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='listarMensagens'/>">Exibir mensagens</a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link" href="<c:url value='listarCurriculos'/>">Exibir currículos</a>
                            </li>
                            <li class="nav-item">                                                                 
                                <a class="nav-link" href="<c:url value='efetuarLogout'/>" >Logout</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
                               
        </nav>
    </header>
        <h3>Funcionalidades restritas aos administradores apenas!!</h3>
        <br> Bem-Vindo(a), ${usuarioLogado.login}!
    <script src="<c:url value='/resources/js/jquery.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/js/funcoes.js'/>"></script>  
</body>
</html>
