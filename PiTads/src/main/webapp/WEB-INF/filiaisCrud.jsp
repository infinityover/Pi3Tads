<%-- 
    Document   : filiaisCrud
    Created on : Oct 21, 2019, 1:07:19 AM
    Author     : paulo
--%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style><%@include file="../css/filial.css"%></style>
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
        <form method="post" action="${pageContext.request.contextPath}/filialSalvar" class="form">
            <div class="corpo">
                <label>Código do filial:</label>
                <input type="text" placeholder="Código do filial" name="id" value=<c:out value="${id}" /> <c:if test="${not empty id}"><c:out value="readonly='readonly'"/></c:if>>
                    <label>Apelido da filial:</label>
                    <input type="text" placeholder="Apelido da filial" name="apelido" value=<c:out value="${apelido}" />>
                <label>Estado:</label>
                <select id="estado" name="estado" name="estado">
                    <option value="AC" <c:if test="${estado == 'AC'}"><c:out value="selected"/></c:if>>Acre</option>
                    <option value="AL" <c:if test="${estado == 'AL'}"><c:out value="selected"/></c:if>>Alagoas</option>
                    <option value="AP" <c:if test="${estado == 'AP'}"><c:out value="selected"/></c:if>>Amapá</option>
                    <option value="AM" <c:if test="${estado == 'AM'}"><c:out value="selected"/></c:if>>Amazonas</option>
                    <option value="BA" <c:if test="${estado == 'BA'}"><c:out value="selected"/></c:if>>Bahia</option>
                    <option value="CE" <c:if test="${estado == 'CE'}"><c:out value="selected"/></c:if>>Ceará</option>
                    <option value="DF" <c:if test="${estado == 'DF'}"><c:out value="selected"/></c:if>>Distrito Federal</option>
                    <option value="ES" <c:if test="${estado == 'ES'}"><c:out value="selected"/></c:if>>Espírito Santo</option>
                    <option value="GO" <c:if test="${estado == 'GO'}"><c:out value="selected"/></c:if>>Goiás</option>
                    <option value="MA" <c:if test="${estado == 'MA'}"><c:out value="selected"/></c:if>>Maranhão</option>
                    <option value="MT" <c:if test="${estado == 'MT'}"><c:out value="selected"/></c:if>>Mato Grosso</option>
                    <option value="MS" <c:if test="${estado == 'MS'}"><c:out value="selected"/></c:if>>Mato Grosso do Sul</option>
                    <option value="MG" <c:if test="${estado == 'MG'}"><c:out value="selected"/></c:if>>Minas Gerais</option>
                    <option value="PA" <c:if test="${estado == 'PA'}"><c:out value="selected"/></c:if>>Pará</option>
                    <option value="PB" <c:if test="${estado == 'PB'}"><c:out value="selected"/></c:if>>Paraíba</option>
                    <option value="PR" <c:if test="${estado == 'PR'}"><c:out value="selected"/></c:if>>Paraná</option>
                    <option value="PE" <c:if test="${estado == 'PE'}"><c:out value="selected"/></c:if>>Pernambuco</option>
                    <option value="PI" <c:if test="${estado == 'PI'}"><c:out value="selected"/></c:if>>Piauí</option>
                    <option value="RJ" <c:if test="${estado == 'RJ'}"><c:out value="selected"/></c:if>>Rio de Janeiro</option>
                    <option value="RN" <c:if test="${estado == 'RN'}"><c:out value="selected"/></c:if>>Rio Grande do Norte</option>
                    <option value="RS" <c:if test="${estado == 'RS'}"><c:out value="selected"/></c:if>>Rio Grande do Sul</option>
                    <option value="RO" <c:if test="${estado == 'RO'}"><c:out value="selected"/></c:if>>Rondônia</option>
                    <option value="RR" <c:if test="${estado == 'RR'}"><c:out value="selected"/></c:if>>Roraima</option>
                    <option value="SC" <c:if test="${estado == 'SC'}"><c:out value="selected"/></c:if>>Santa Catarina</option>
                    <option value="SP" <c:if test="${estado == 'SP'}"><c:out value="selected"/></c:if>>São Paulo</option>
                    <option value="SE" <c:if test="${estado == 'SE'}"><c:out value="selected"/></c:if>>Sergipe</option>
                    <option value="TO" <c:if test="${estado == 'TO'}"><c:out value="selected"/></c:if>>Tocantins</option>
                    </select>
                    <label>Cidade:</label>
                    <input type="text" placeholder="Cidade" name="cidade" value=<c:out value="${cidade}" />>

                <a href="${pageContext.request.contextPath}/Filiais"><button type="Button" class="btn btn-red">Cancelar</button></a>
                <button type="submit" class="btn btn-black">Enviar</button>
            </div>
        </form>
    </body>

</html>