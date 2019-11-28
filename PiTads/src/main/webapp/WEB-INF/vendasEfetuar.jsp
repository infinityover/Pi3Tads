<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style><%@include file="../css/vendas/vendasEfetuar.css"%></style>
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
        <c:choose>
            <c:when test="${not empty Vendas}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Produto</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Desconto</th>
                            <th scope="col">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Vendas}" var="venda">
                            <tr>
                                <th scope="row"><c:out value="${venda.id}"/></th>
                                <td><c:out value="${venda.idProduto}"/></td>
                                <td><c:out value="${venda.valor}"/></td>
                                <td><c:out value="${venda.quantidade}"/></td>
                                <td><c:out value="${venda.desconto}"/></td>
                                <td><c:out value="${venda.valor} * ${venda.quantidade}"/></td>
                                <td>
                                <td><a href="/PiTads/VendasCrud?idVendaProduto=<c:out value='${venda.id}'/>" ><button type="button" class="btn btn-black">Editar</button></a></td>
                                <td><a href="/PiTads/VendasExcluir?idVendaProduto=<c:out value='${venda.id}'/>" ><button type="button" class="btn btn-red">Excluir</button></a></td>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Nenhuma venda cadastrada, deseja cadastrar uma nova?</p>
            </c:otherwise>
        </c:choose>

        <a href="/PiTads/Home"><button type="button" class="btn btn-black">Cancelar</button></a>
        <a href="/PiTads/VendasCrud?id=<c:out value='${VendaId}'/>"><button type="button" class="btn btn-black">Novo</button></a>
    </body>

</html>