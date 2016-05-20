/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v.servlet;

import c.servicios.UsuarioServicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m.pojos.Usuario;

/**
 *
 * @author Ar Montalvo
 */
@WebServlet(name = "loginservlet", urlPatterns = {"/loginservlet"})
public class LoginServlet extends HttpServlet {

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

        String nombre = request.getParameter("f_nombre"); //parametro necesario en la pagina login.jsp
        String pasword = request.getParameter("f_contra"); //parametro necesario en la pagina login.jsp
        String error, msg;

        Usuario usuario = UsuarioServicio.isUser(nombre, pasword);
        if (usuario == null) {
            if (nombre.isEmpty() || pasword.isEmpty()) {
                error = "ha dejado un campo vacio";
                request.setAttribute("msg", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                error = "usuario o contraseña incorrectos";
                request.setAttribute("msg", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.getSession().setAttribute(nombre, usuario);
            request.getSession().setMaxInactiveInterval(99999);
            response.sendRedirect("../sist/busqueda.jsp");
        }
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

        /*String nombre = request.getParameter("f_nombre"); //parametro necesario en la pagina login.jsp
        String pasword = request.getParameter("f_contra"); //parametro necesario en la pagina login.jsp
        String error, msg;

        Usuario usuario = UsuarioServicio.isUser(nombre, pasword);
        if (usuario == null) {
            if (nombre.isEmpty() || pasword.isEmpty()) {
                error = "ha dejado un campo vacio";
            } else {
                error = "usuario o contraseña incorrectos";
                request.setAttribute("msg", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.getSession().setAttribute(nombre, usuario);
            request.getSession().setMaxInactiveInterval(9999999);
            response.sendRedirect("../web/sist/productores.jsp");
        }
        //processRequest(request, response);*/
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
