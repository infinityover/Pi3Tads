<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        
        <form method="get" action="${pageContext.request.contextPath}/VendasRelatorioFilial">
            <label>Filial:</label>
            <select id="filial" name="filial" name="filial">
                <c:forEach items="${Filiais}" var="filial">
                <option value=<c:out value="${filial.id}"/>><c:out value="${filial.apelido}"/></option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-black" style="right: 10px;position: fixed;">Filtar</button>
        </form>
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
                        <c:set var="total" value="${0}"/>
                        <c:forEach items="${Vendas}" var="venda">
                        <c:set var="total" value="${total + venda.valor}" />
                            <tr>
                                <th scope="row"><c:out value="${venda.id}"/></th>
                                <td><c:out value="${venda.idFilial}"/></td>
                                <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${venda.dataOp}" /></td>
                                <td><fmt:formatNumber value="${venda.valor}" type="currency"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                                <th scope="row">Total</th>
                                <td></td>
                                <td></td>
                                <td><fmt:formatNumber value="${total}" type="currency"/></td>
                            </tr>
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