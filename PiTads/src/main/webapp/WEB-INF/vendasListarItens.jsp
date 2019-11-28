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
                        <th scope="col">Id Produto</th>
                        <th scope="col">Nome Produto</th>
                        <th scope="col">Valor unit</th>
                        <th scope="col">Quantidade</th>
                        <th scope="col">Desconto</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${vendaItens}" var="itens">
                    <tr>
                    <th scope="row"><c:out value="${itens.produto}"/></th>
                    <td><c:out value="${venda.nome}"/></td>
                    <td><c:out value="${venda.valor}"/></td>
                    <td><c:out value="${venda.quantidade}"/></td>
                    <td><c:out value="${venda.desconto}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>Nenhum item cadastrado, deseja cadastrar um novo?</p>
        </c:otherwise>
    </c:choose>

    <a href="/PiTads/Vendas"><button type="button" class="btn btn-black">Voltar</button></a>
    <a href="/PiTads/VendasEfetuar"><button type="button" class="btn btn-black">Novo</button></a>
    <a href="/PiTads/VendasFinalizar"><button type="button" class="btn btn-black">Finalizar</button></a>
</body>

</html>