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
        <c:choose>
            <c:when test="${not empty Vendas}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Filial</th>
                            <th scope="col">Data da venda</th>
                            <th scope="col">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Vendas}" var="venda">
                            <tr>
                                <th scope="row"><c:out value="${venda.id}"/></th>
                                <td><c:out value="${venda.idFilial}"/></td>
                                <td><c:out value="${venda.dataOp}"/></td>
                                <td><c:out value="${venda.valor}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Nenhuma venda cadastrada, deseja cadastrar uma nova?</p>
            </c:otherwise>
        </c:choose>

        <a href="${pageContext.request.contextPath}/Vendas"><button type="button" class="btn btn-black">Voltar</button></a>
        <a href="${pageContext.request.contextPath}/VendasEfetuar"><button type="button" class="btn btn-black">Novo</button></a>
    </body>

</html>