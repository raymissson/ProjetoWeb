<%-- 
    Document   : enviarMensagem
    Created on : 28/05/2018, 11:18:51
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <!-- Cabeçalho -->
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="col-sm-6">
                    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                        <a href="<c:url value='/'/>" class="navbar-brand" >
                            <img src="<c:url value='/resources/img/logo.png'/>" width="200" height="150" alt="">
                        </a>
                        <form class="form-inline">
                            <input class="form-control mr-sm-3" type="search" placeholder="Qual o produto?" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
                        </form>
                    </nav>
                </div>
                <div class="col-sm-6">
                    <nav class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-center">
                        <div class="dropdown mr-sm-4">
                            <button class="btn btn-outline-warning dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Ei você aí? entre ou cadastre-se
                            </button>
                            <div class="dropdown-menu">
                                <form method="post" action="<c:url value='/efetuaLogin'/>" class="px-4 py-3">
                                    <div class="form-group">
                                        <label for="exampleDropdownFormEmail1">Email </label>
                                        <input name="login" type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleDropdownFormPassword1">Senha</label>
                                        <input name="senha" type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="dropdownCheck">
                                        <label class="form-check-label" for="dropdownCheck">
                                            Lembrar-me
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-outline-success">Entrar</button>
                                </form>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<c:url value='/formAdicionarCliente'/>">Novo aqui? Cadastra-se</a>
                                <a class="dropdown-item" href="#">Esqueceu a senha?</a>
                            </div>
                        </div>
                        </br></br>
                        <div>
                            <a href="<c:url value='/carregarCarrinho'/>"> <button type="button" class="btn btn-outline-primary">Carrinho</button> </a>
                        </div>                       
                        </br></br>
                    </nav>
                </div>
            </nav>
        </header>
        </br>
        <!--Menu-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Categorias
                        </a>
                        <div name="categoria_cod_categoria" class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <c:forEach items="${listaCategoria}" var="categoria">
                                <a href="<c:url value='/listaProdutoCategoria?id='/>${categoria.id}" value="${categoria.id}" class="dropdown-item"><option>${categoria.nome}</option></a>
                            </c:forEach>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a href="<c:url value='/formAdicionarMensagem'/>" class="nav-link" >Contato</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/formEnviarCurriculo'/>">Trabalhe Conosco</a>
                    </li>
                </ul>
            </div>
        </nav>
        </br>
        <!--Mensagem-->
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <form action="<c:url value='/adicionarMensagem'/>" method="post">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Nome</label>
                            <input name="nome" id="txtNome" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite seu nome">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Email</label>
                            <input name="email" id="txtEmail" type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Motivo do contato</label>
                            <select  name="motivo" class="form-control" id="exampleFormControlSelect1">
                                <option value="Pergunta">Pergunta</option>
                                <option value="Critica">Crítica</option>
                                <option value="Sugestao">Sugestão</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Mensagem</label>
                            <textarea  name="conteudo" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Enviar</button>							
                    </form>								
                </div>
            </div>
        </div>
        </br></br>
        <footer>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-center">
                <h1  class="rodape"> Criado por @umalgoritmo e @david - Copyright © 2018</h1>
            </nav>
        </footer>
        </br></br>
        </body>
        <!--rodapé-->
        
        <!-- jQuery (necessario para os plugins Javascript do Bootstrap) -->
        <script src="<c:url value='/resources/js/jquery.js'/>"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/resources/js/funcoes.js'/>"></script>  
    </body>
</html>
