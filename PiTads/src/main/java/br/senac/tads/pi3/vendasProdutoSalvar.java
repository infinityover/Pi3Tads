/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.ProdutoController;
import Controller.VendasProdutoController;
import DAO.VendasProdutoDao;
import Model.Produto;
import Model.VendasProduto;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author paulo
 */
@WebServlet(name = "vendasProdutoSalvar", urlPatterns = {"/vendasProdutoSalvar"})
public class vendasProdutoSalvar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        if (sessao == null) {
            response.sendRedirect("/PiTads");
            return;
        }

        String id = request.getParameter("idVenda");
        if (!id.isEmpty() && id != null) {

            int idVendaProduto;
            String vendaProduto = request.getParameter("vendaProduto");
            if (vendaProduto.isEmpty()) {
                idVendaProduto = 0;
            } else {
                idVendaProduto = Integer.valueOf(vendaProduto);
            }
            VendasProdutoController vendasProdutoController = new VendasProdutoController();
            VendasProduto vendasProduto = vendasProdutoController.buscaVendaProduto(Integer.valueOf(idVendaProduto));
            VendasProdutoDao vendasProdutodao = new VendasProdutoDao();
            if (vendasProduto != null) {
                vendasProduto = new VendasProduto(Integer.valueOf(id), Integer.valueOf(request.getParameter("idVenda")), request.getParameter("idProduto"), Float.valueOf(request.getParameter("valor")), Integer.valueOf(request.getParameter("quantidade")), Float.valueOf(request.getParameter("desconto")));
                vendasProdutodao.editar(vendasProduto);
            } else {
                vendasProduto = new VendasProduto(Integer.valueOf(id), Integer.valueOf(request.getParameter("idVenda")), request.getParameter("idProduto"), Float.valueOf(request.getParameter("valor")), Integer.valueOf(request.getParameter("quantidade")), Float.valueOf(request.getParameter("desconto")));
                vendasProdutodao.salvar(vendasProduto);
            }
        }
        response.sendRedirect("/PiTads/GerenciarVenda?id=" + request.getParameter("idVenda"));
    }
}
