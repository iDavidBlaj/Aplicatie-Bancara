package main.java.servlets;

import main.java.ContBancar;
import main.java.ContBancarRepository;
import main.java.Prietenie;
import main.java.PrietenieRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/PrietenieCreare")
public class PrietenieCreare extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        if(session.getAttribute("id_utilizator") == null)
        {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        ContBancar contbancar = ContBancarRepository.findContBancar(req.getParameter("iban"));
        if(contbancar == null)
            req.getRequestDispatcher("/PrietenieCreare.jsp").forward(req, resp);
        else {
            Prietenie prietenie = new Prietenie((Integer) session.getAttribute("id_utilizator"), contbancar.getId_contbancar());
            prietenie = PrietenieRepository.addPrietenie(prietenie);
            if (prietenie == null)
                req.getRequestDispatcher("/PrietenieCreare.jsp").forward(req, resp);
            else
                req.getRequestDispatcher("/MeniuPrietenie.jsp").forward(req, resp);
        }
    }
}
