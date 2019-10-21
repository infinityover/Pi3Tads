/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.ProdutoController;
import Model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "produtoSalvar", urlPatterns = {"/produtoSalvar"})
public class produtoSalvar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id = request.getParameter("id");
            if(id != null){
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.buscaProduto(id);
                    if(produto != null){
                        produto = new Produto(request.getParameter("id"),request.getParameter("nome"),Float.valueOf(request.getParameter("valor")));
                        produtoController.produtoEditar(produto);
                    }else{
                        produto = new Produto(request.getParameter("id"),request.getParameter("nome"),Float.valueOf(request.getParameter("valor")));
                        produtoController.produtoSalvar(produto);
                    }
            }
            response.sendRedirect("/PiTads/produtos");
    }
}
