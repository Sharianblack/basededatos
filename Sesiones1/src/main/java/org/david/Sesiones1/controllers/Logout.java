package org.david.Sesiones1.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.david.Sesiones1.services.LoginService;
import org.david.Sesiones1.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class Logout  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //creamos el objeto de tipo session
        LoginService auth = new LoginServiceSessionImplement();
        Optional<String>userNameOptional = auth.getUserName(req);
        if(userNameOptional.isPresent()){
            HttpSession session = req.getSession();
            //cerramnos ls session
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath()+ "/login.html");
    }
}
