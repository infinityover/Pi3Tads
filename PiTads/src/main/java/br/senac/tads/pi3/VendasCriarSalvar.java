/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.VendasController;
import Model.Vendas;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulobelfi
 */
@WebServlet(name = "VendasCriarSalvar", urlPatterns = {"/VendasCriarSalvar"})
public class VendasCriarSalvar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        String contextPath = request.getContextPath();
        if (sessao == null) {
            response.sendRedirect(contextPath);
            return;
        }
        VendasController vendasController = new VendasController();
        int idVenda = vendasController.vendaSalvar(new Vendas(0, request.getParameter("filial"), new Timestamp(System.currentTimeMillis()), 0f, false));

        response.sendRedirect(contextPath + "/GerenciarVenda?id=" + String.valueOf(idVenda));

    }

}
