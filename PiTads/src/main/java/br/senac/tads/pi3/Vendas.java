/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.FiliaisController;
import Controller.ProdutoController;
import Model.Filial;
import Model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo
 */
@WebServlet(name = "Vendas", urlPatterns = {"/Vendas"})
public class Vendas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        if (sessao == null) {
            response.sendRedirect("/PiTads");
            return;
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/vendas.jsp");
        dispatcher.forward(request, response);
    }
}
