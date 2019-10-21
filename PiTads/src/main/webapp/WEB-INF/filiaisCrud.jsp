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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
        <style><%@include file="../css/filial.css"%></style>
        <title>Tades</title>
    </head>

    <body>

        <form method="post" action="${pageContext.request.contextPath}/filialSalvar">
            <div class="form-group">
                <label>Código do filial:</label>
                <input type="text" placeholder="Código do filial" name="id" value=<c:out value="${id}" /> <c:if test="${not empty id}"><c:out value="readonly='readonly'"/></c:if>>
                <br>
                <label>Apelido da filial:</label>
                <input type="text" placeholder="Apelido da filial" name="apelido" value=<c:out value="${apelido}" />>
                <br>
                <label>Estado:</label>

                <select id="estado" name="estado" name="estado" value=<c:out value="${estado}" />>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amapá</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Ceará</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Espírito Santo</option>
                    <option value="GO">Goiás</option>
                    <option value="MA">Maranhão</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Pará</option>
                    <option value="PB">Paraíba</option>
                    <option value="PR">Paraná</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piauí</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rondônia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">São Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </select>
                <br>
                <label>Cidade:</label>

                <input type="text" placeholder="Cidade" name="cidade" value=<c:out value="${cidade}" />>

            </div>
        </div>
        <button type="submit" class="btn btn-black">Enviar</button>
    </form>
</body>

</html>