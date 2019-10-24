/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.VendasProdutoController;
import Model.VendasProduto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo
 */
@WebServlet(name = "VendasCrud", urlPatterns = {"/VendasCrud"})
public class VendasCrud extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id = request.getParameter("idVendaProduto");
            if(id != null){
                VendasProdutoController vendasProdutoController = new VendasProdutoController();
                VendasProduto vendasProduto = vendasProdutoController.buscaVendaProduto(Integer.valueOf(id));

                request.setAttribute("id", vendasProduto.getId());
                request.setAttribute("idProduto", vendasProduto.getIdProduto());
                request.setAttribute("idVenda", vendasProduto.getIdVenda());
                request.setAttribute("quantidade", vendasProduto.getQuantidade());
                request.setAttribute("valor", vendasProduto.getValor());
            }
             RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/vendasCrud.jsp");
        dispatcher.forward(request, response);
    }
}
