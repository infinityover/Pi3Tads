/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.ProdutoController;
import Model.Produto;
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
@WebServlet(name = "ProdutoCrud", urlPatterns = {"/ProdutoCrud"})
public class ProdutoCrud extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id = request.getParameter("id");
            if(id != null){
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.buscaProduto(id);

                request.setAttribute("id", produto.getId());
                request.setAttribute("nome", produto.getNome());
                request.setAttribute("valor", produto.getValor());
            }
             RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/produtoCrud.jsp");
        dispatcher.forward(request, response);
    }
}
