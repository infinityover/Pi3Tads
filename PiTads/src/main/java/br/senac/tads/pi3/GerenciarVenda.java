/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.VendasProdutoController;
import Model.VendasProdutoUserView;
import java.io.IOException;
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
@WebServlet(name = "GerenciarVenda", urlPatterns = {"/GerenciarVenda"})
public class GerenciarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        if (sessao == null) {
            response.sendRedirect("/PiTads");
            return;
        }
        String id = request.getParameter("id");
        VendasProdutoController vendasProdutoController = new VendasProdutoController();
        ArrayList<VendasProdutoUserView> vendaItens = vendasProdutoController.listaVendasProdutoComNome(Integer.valueOf(id));

        request.setAttribute("idVenda", id);
        request.setAttribute("vendaItens", vendaItens);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/vendasListarItens.jsp");
        dispatcher.forward(request, response);

    }

}
