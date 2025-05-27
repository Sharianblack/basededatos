package org.david.Sesiones1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.david.Sesiones1.services.LoginService;
import org.david.Sesiones1.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

// Definición del Servlet que manejará las rutas /login y /login.html
@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    // Credenciales fijas para autenticación (en producción usar base de datos)
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    // Método para manejar solicitudes GET (cuando se accede a la página)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //implementamos el objeto de tipo sesion
        LoginService auth = new LoginServiceSessionImplement();
        //creamos una variable optional para obtener el nombre de usuario
        Optional <String>usernameOptional= auth.getUserName(req);

        // Si existe la cookie (usuario ya autenticado)
        if (usernameOptional.isPresent()) {
            // Configurar tipo de contenido de la respuesta, se mostara un documento que diga que ya iniciaste sesion
            resp.setContentType("text/html;charset=UTF-8");

            // Usar try-with-resources para manejo automático del PrintWriter
            try (PrintWriter out = resp.getWriter()) {
                // Generar HTML de respuesta dinámicamente
                out.print("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"utf-8\">");  // Especificar encoding
                out.println("<title>hola usuario "+ usernameOptional.get() +"</title>");  // Título de la pestaña
                out.println("</head>");
                out.println("<body>");
                // Mostrar mensaje personalizado con el nombre de usuario
                out.println("<h1>Hola "+ usernameOptional.get()+" ya iniciaste sesión anteriormente!</h1>");
                // Enlace para volver al inicio
                out.println("<p><a href='index.html'>Volver al inicio</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            // Si no hay cookie, mostrar el formulario de login (JSP), es manejo de cabeceros
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    // Método para manejar solicitudes POST (envío del formulario de login)
    @Override
    //el metodo dopost va a procesar los parametros
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Obtener parámetros del formulario
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Validar credenciales
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // Si son válidas, crear cookie de autenticación

            //creamos la sesion
            HttpSession session = req.getSession();
            //seteo los valores de la sesion
            session.setAttribute("username", username);

            // Redirigir a la página de login (mostrará mensaje de bienvenida)
            resp.sendRedirect("login.html");
        } else {
            // Si credenciales son inválidas, enviar error HTTP 401 (No autorizado)
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no tiene acceso");
        }
    }
}