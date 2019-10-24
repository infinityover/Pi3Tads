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
    <!-- <link rel="stylesheet" href="./assets/index.css"> -->
    <style><%@include file="../css/vendas/vendasEfetuar.css"%></style>
    <title>Tades</title>

</head>

<body>
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
            <p>Nenhum produto cadastrado</p>
        </c:otherwise>
    </c:choose>


    <button type="button" class="btn btn-black">Cancelar</button>
    
    <a href="/PiTads/Home"><button type="button" class="btn btn-black">Finalizar</button></a>
    <a href="/PiTads/VendasCrud?id=<c:out value='${VendaId}'/>"><button type="button" class="btn btn-black">Novo</button></a>
</body>

</html>