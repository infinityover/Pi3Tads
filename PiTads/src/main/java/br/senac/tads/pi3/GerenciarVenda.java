/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.VendasController;
import Controller.VendasProdutoController;
import Model.Vendas;
import Model.VendasProduto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulobelfi
 */
@WebServlet(name = "GerenciarVenda", urlPatterns = {"/GerenciarVenda"})
public class GerenciarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        VendasProdutoController vendasProdutoController = new VendasProdutoController();
        ArrayList<VendasProduto> vendaItens =  vendasProdutoController.listaVendasProduto(Integer.valueOf(id));
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/vendasListarItens.jsp");
        dispatcher.forward(request, response);
        
    }

}
