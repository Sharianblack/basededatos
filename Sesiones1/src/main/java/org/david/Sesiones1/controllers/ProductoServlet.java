// Paquete donde se encuentra esta clase (organización del proyecto)
package org.david.Sesiones1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.david.Sesiones1.models.Productos;
import org.david.Sesiones1.services.LoginService;
import org.david.Sesiones1.services.LoginServiceSessionImplement;
import org.david.Sesiones1.services.ProductoService;
import org.david.Sesiones1.services.ProductosServiceImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> usernameOptional = auth.getUserName(req);

        ProductoService service = new ProductosServiceImplement();
        List<Productos> productos = service.listar();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>Lista de Productos</title>");
        out.println("<link rel=\"stylesheet\" href=\"WEB-INF/estilos.css\">");
        out.println("</head>");
        out.println("<body>");

        // Cabecera con mensaje contextual
        out.println("<header>");
        if (usernameOptional.isPresent()) {
            out.println("<h1>Bienvenido, " + usernameOptional.get() + "</h1>");
        } else {
            out.println("<h1>Lista de Productos Disponibles</h1>");
            out.println("<div class=\"info\">Inicie sesión para ver precios completos</div>");
        }
        out.println("</header>");

        // Tabla de productos
        out.println("<table class=\"tabla-productos\">");
        out.println("<thead><tr>");
        out.println("<th>ID</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Categoría</th>");
        out.println("<th>Precio</th>");
        out.println("</tr></thead>");
        out.println("<tbody>");

        productos.forEach(p -> {
            out.println("<tr>");
            out.println("<td>" + p.getId() + "</td>");
            out.println("<td>" + p.getNombre() + "</td>");
            out.println("<td>" + p.getTipo() + "</td>");

            // Celda de precio condicional
            out.println("<td class=\"precio\">");
            if (usernameOptional.isPresent()) {
                out.println(String.format("$%.2f", p.getPrecio()));
            } else {
                out.println("<a href=\"login.html\" title=\"Inicie sesión para ver precio\">*</a>");
            }
            out.println("</td>");

            out.println("</tr>");
        });

        out.println("</tbody></table>");

        // Pie de página con enlace al inicio (sin duplicar login/logout)
        out.println("<footer>");
        out.println("<a href=\"index.html\" class=\"btn-inicio\">Volver al Inicio</a>");
        out.println("</footer>");

        out.println("</body>");
        out.println("</html>");
    }
}