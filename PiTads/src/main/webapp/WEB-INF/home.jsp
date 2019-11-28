<%-- 
    Document   : home
    Created on : Oct 19, 2019, 2:36:55 PM
    Author     : paulo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <!-- <link rel="stylesheet" href="./assets/index.css"> -->
        <style><%@include file="../css/home.css"%></style>
        <title>Tades</title>

    </head>

    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/Home">Tades</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/Deslogar"><span class="glyphicon glyphicon-log-in"></span> Deslogar</a></li>
                </ul>
            </div>
        </nav>
        <div class="body">
            <!-- <a href="./financeiro.html">
                <div class="card">
                    <div class="card-body">
                        Financeiro
                    </div>
                </div>
            </a> -->
            <a class="link" href="${pageContext.request.contextPath}/produtos">
                <div class="card">
                    <div class="card-body">
                        Produtos
                    </div>
                </div>
            </a>

            <a class="link" href="${pageContext.request.contextPath}/Filiais">
                <div class="card">
                    <div class="card-body">
                        Filiais
                    </div>
                </div>
            </a>
            <a class="link" href="${pageContext.request.contextPath}/Vendas">
                <div class="card">
                    <div class="card-body">
                        Vendas
                    </div>

                </div>
            </a>

            <a class="link" href="${pageContext.request.contextPath}/Usuarios">
                <div class="card">
                    <div class="card-body">
                        Usuarios
                    </div>
                </div>
            </a>
            <!-- <a href="./estoque.html">
                <div class="card">
                    <div class="card-body">
                        Estoque
                    </div>
                </div>
            </a> -->
        </div>
    </body>

</html>