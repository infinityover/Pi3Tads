<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
        <style><%@include file="../css/produtos.css"%></style>

        <title>Tades</title>

    </head>

    <body>
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

    <a href="/PiTads/vendasEfetuar"><button type="button" class="btn btn-black">Voltar</button></a>
    <a href="/PiTads/vendasEfetuar"><button type="button" class="btn btn-black">Novo</button></a>
</body>

</html>