package main.java.servlets;

import main.java.ContBancar;
import main.java.ContBancarRepository;
import main.java.ValutaRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ContBancarCreare")
public class ContBancarCreare extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        if(session.getAttribute("id_utilizator") == null)
        {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        String afisare = "Alege o valuta: ";
        afisare = afisare + ValutaRepository.showValute();
        req.setAttribute("afisare",afisare);
        req.getRequestDispatcher("/ContBancarCreare.jsp").forward(req, resp);
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
        ContBancar contbancar = new ContBancar(ContBancarRepository.generateId(),ContBancarRepository.generateIban(),
                                               0.0, Integer.parseInt(req.getParameter("id_valuta")),
                                                (Integer)session.getAttribute("id_utilizator"));
        contbancar = ContBancarRepository.addContBancar(contbancar);
        if(contbancar == null)
            req.getRequestDispatcher("/ContBancarCreare.jsp").forward(req, resp);
        else req.getRequestDispatcher("/MeniuContBancar.jsp").forward(req, resp);
    }
}
