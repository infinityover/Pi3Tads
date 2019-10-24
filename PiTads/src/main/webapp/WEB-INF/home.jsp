<%-- 
    Document   : home
    Created on : Oct 19, 2019, 2:36:55 PM
    Author     : paulo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
    </script>
    <!-- <link rel="stylesheet" href="./assets/index.css"> -->
    <style><%@include file="../css/home.css"%></style>
    <title>Tades</title>

</head>

<body>
    <div class="body">
        <!-- <a href="./financeiro.html">
            <div class="card">
                <div class="card-body">
                    Financeiro
                </div>
            </div>
        </a> -->
        <a href="/PiTads/produtos">
            <div class="card">
                <div class="card-body">
                    Produtos
                </div>
            </div>
        </a>

        <a href="/PiTads/Filiais">
            <div class="card">
                <div class="card-body">
                    Filiais
                </div>
            </div>
        </a>
        <a href="/PiTads/Vendas">
            <div class="card">
                <div class="card-body">
                    Vendas
                </div>

            </div>
        </a>

        <!-- <a href="./usuarios.html">
            <div class="card">
                <div class="card-body">
                    Usuarios
                </div>
            </div>
        </a> -->
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