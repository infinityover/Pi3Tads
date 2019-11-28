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
                    <a class="navbar-brand" href="/PiTads/Home">Tades</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/PiTads/Deslogar"><span class="glyphicon glyphicon-log-in"></span> Deslogar</a></li>
                </ul>
            </div>
        </nav>
        <form method="POST" action="${pageContext.request.contextPath}/VendasCrud" class="form">
            <input type="hidden" name="idVenda" value=<c:out value="${idVenda}" />>
            <c:choose>
                <c:when test="${not empty vendaItens}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Id Produto</th>
                                <th scope="col">Nome Produto</th>
                                <th scope="col">Valor unit</th>
                                <th scope="col">Quantidade</th>
                                <th scope="col">Desconto</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${vendaItens}" var="itens">
                                <tr>
                                    <th scope="row"><c:out value="${itens.idProduto}"/></th>
                                    <td><c:out value="${itens.nomeProduto}"/></td>
                                    <td><c:out value="${itens.valor}"/></td>
                                    <td><c:out value="${itens.quantidade}"/></td>
                                    <td><c:out value="${itens.desconto}"/></td>
                                    <td><c:out value="${itens.total}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>Nenhum item cadastrado, deseja cadastrar um novo?</p>
                </c:otherwise>
            </c:choose>
            <div>
                <a href="/PiTads/Vendas"><button type="button" class="btn btn-black">Voltar</button></a>
                <a href="/PiTads/VendasCrud"><button type="Submit" name="envio" value="novo" class="btn btn-black">Novo</button></a>
                <a href="/PiTads/VendasFinalizar"><button type="Submit" name="envio" value="finalizar" class="btn btn-black">Finalizar</button></a>
            </div>
        </form>
    </body>

</html>