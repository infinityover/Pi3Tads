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
        <c:when test="${not empty Produtos}">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Produto</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Quantidade</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${Produtos}" var="produto">
                    <tr>
                    <th scope="row"><c:out value="${produto.id}"/></th>
                    <td><c:out value="${produto.nome}"/></td>
                    <td><c:out value="${produto.valor}"/></td>
                    <td>203</td>
                <td>
                    <td><a href="/PiTads/ProdutoCrud?id=<c:out value='${produto.id}'/>" ><button type="button" class="btn btn-black">Editar</button></a></td>
                    <td><a href="/PiTads/ProdutoExcluir?id=<c:out value='${produto.id}'/>" ><button type="button" class="btn btn-red">Excluir</button></a></td>
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

    <a href="/PiTads/Home"><button type="button" class="btn btn-black">Voltar</button></a>
    <a href="/PiTads/ProdutoCrud"><button type="button" class="btn btn-black">Novo</button></a>
</body>

</html>