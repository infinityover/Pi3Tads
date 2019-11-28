/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.VendasController;
import Controller.VendasProdutoController;
import Model.VendasProduto;
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
@WebServlet(name = "VendasCrud", urlPatterns = {"/VendasCrud"})
public class VendasCrud extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        if (sessao == null) {
            response.sendRedirect("/PiTads");
            return;
        }
        String idVenda = request.getParameter("idVenda");
        String idVendaProduto = request.getParameter("idVendaProduto");
        String tipo = request.getParameter("envio");

        if (tipo != null && tipo.equals("novo")) {
            if (idVendaProduto != null) {
                VendasProdutoController vendasProdutoController = new VendasProdutoController();
                VendasProduto vendasProduto = vendasProdutoController.buscaVendaProduto(Integer.valueOf(idVendaProduto));

                request.setAttribute("id", vendasProduto.getId());
                request.setAttribute("idProduto", vendasProduto.getIdProduto());
                request.setAttribute("idVenda", vendasProduto.getIdVenda());
                request.setAttribute("quantidade", vendasProduto.getQuantidade());
                request.setAttribute("valor", vendasProduto.getValor());
            }
            request.setAttribute("idVenda", idVenda);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/vendasCrud.jsp");
            dispatcher.forward(request, response);
        } else {
            VendasController vendasController = new VendasController();
            vendasController.vendaSalvarProdutoFinalizar(vendasController.buscaVenda(Integer.valueOf(idVenda)));
            response.sendRedirect("/PiTads/VendasListar");

        }
    }
}
