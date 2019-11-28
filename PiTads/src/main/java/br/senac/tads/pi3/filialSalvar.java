/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.FiliaisController;
import Model.Filial;
import java.io.IOException;
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
@WebServlet(name = "filialSalvar", urlPatterns = {"/filialSalvar"})
public class filialSalvar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        if (sessao == null) {
            response.sendRedirect("/PiTads");
            return;
        }
        String id = request.getParameter("id");
        if (id != null) {
            FiliaisController filiaisController = new FiliaisController();
            Filial filial = filiaisController.buscaFilial(id);
            if (filial != null) {
                filial = new Filial(request.getParameter("id"), request.getParameter("apelido"), request.getParameter("estado"), request.getParameter("cidade"));
                filiaisController.filialEditar(filial);
            } else {
                filial = new Filial(request.getParameter("id"), request.getParameter("apelido"), request.getParameter("estado"), request.getParameter("cidade"));
                filiaisController.filialSalvar(filial);
            }
        }
        response.sendRedirect("/PiTads/Filiais");
    }
}
