<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style><%@include file="../css/produtos.css"%></style>
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
        <form method="post" action="${pageContext.request.contextPath}/vendasProdutoSalvar"class="form">
            <div class="corpo">
                <input type="hidden" name="idVenda"value=<c:out value="${idVenda}" />>
                <input type="hidden" name="vendaProduto"value=<c:out value="${idVendaProduto}" />>
                <label>Código do produto:</label>
                <input type="text" name="idProduto" placeholder="Código do produto" value=<c:out value="${idProduto}" /> <c:if test="${not empty idProduto}"><c:out value="readonly='readonly'"/></c:if>>
                    <label>Valor:</label>
                    <input type="text" name="valor" placeholder="Valor" value=<c:out value="${valor}" />>
                <label>Quantidade:</label>
                <input type="text" name="quantidade" placeholder="Quantidade" value=<c:out value="${quantidade}" />>
                <label>Desconto:</label>
                <input type="text" name="desconto" placeholder="Desconto" value=<c:out value="${desconto}" />>
                <a href="${pageContext.request.contextPath}/GerenciarVenda?id="<c:out value="${idVenda}" />><button type="Button" class="btn btn-red">Cancelar</button></a>
                <button type="submit" class="btn btn-black">Salvar</button>
            </div>
        </form>
    </body>

</html>