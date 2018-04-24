/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.servlet;

import br.com.livraria.entity.Cliente;
import br.com.livraria.entity.Livro;
import br.com.livraria.entity.PedidoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author internet
 */
@WebServlet(name = "Licitar", urlPatterns = {"/Licitar"})
public class Licitar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Licitar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Licitar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            
             EntityManagerFactory emf = 
                    (EntityManagerFactory)getServletContext().getAttribute("emf");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                
                Query query = em.createQuery("SELECT pc from PedidoCliente pc");
                List<PedidoCliente> lstPedidoCliente = (List<PedidoCliente>) query.getResultList();
                request.setAttribute("PedidoCliente", lstPedidoCliente);
                RequestDispatcher dispatcher = request.getRequestDispatcher("listarCliente.jsp");
                
              for(PedidoCliente pedido :lstPedidoCliente){ //buca no banco
                            out.println("nome: " +pedido.getCliente().getNome());
                            out.println("nome do livro:" + pedido.getLivro().getTitulo());
                            
                        }
                
                
              
        }
                
                //dispatcher.forward(request, response);
                
               // mostre seus usuarios aqui. Como????
                       
                        
                        
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
