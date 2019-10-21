<!DOCTYPE html>
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
            <style><%@include file="../css/filial.css"%></style>

        <title>Tades</title>

    </head>

    <body>


        <c:choose>
            <c:when test="${not empty Filiais}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Nome da filial</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Cidade</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Filiais}" var="filial">
                            <tr>
                                <th scope="row"><c:out value="${filial.id}"/></th>
                                <td><c:out value="${filial.apelido}"/></td>
                                <td><c:out value="${filial.estado}"/></td>
                                <td><c:out value="${filial.cidade}"/></td>
                                <td>
                                <td><a href="/PiTads/FiliaisCrud?id=<c:out value='${filial.id}'/>" ><button type="button" class="btn btn-black">Editar</button></a></td>
                                <td><a href="/PiTads/FiliaisCrud?id=<c:out value='${filial.id}'/>" ><button type="button" class="btn btn-red">Excluir</button></a></td>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Nenhuma filial cadastrada</p>
            </c:otherwise>
        </c:choose>
    <a href="/PiTads/Home"><button type="button" class="btn btn-black">Voltar</button></a>
    <a href="/PiTads/FiliaisCrud"><button type="button" class="btn btn-black">Novo</button></a>
    </body>

</html>