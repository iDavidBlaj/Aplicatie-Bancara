package main.java.servlets;

import main.java.Utilizator;
import main.java.UtilizatorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UtilizatorAcces")
public class UtilizatorAcces extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession sess = req.getSession();
        sess.setAttribute("id_utilizator",null);
        sess.setAttribute("nume",null);
        sess.setAttribute("prenume",null);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        String parola = req.getParameter("parola");

        Utilizator utilizator = UtilizatorRepository.findUser(username, parola);

        if (utilizator == null)
        {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        else
        {
            HttpSession sess = req.getSession();
            sess.setAttribute("id_utilizator",utilizator.getId_Utilizator());
            sess.setAttribute("nume",utilizator.getNume());
            sess.setAttribute("prenume",utilizator.getPrenume());
            req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
        }
    }
}