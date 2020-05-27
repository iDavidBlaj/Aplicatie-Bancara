package main.java.servlets;

import main.java.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/Statistici")
public class Statistici extends HttpServlet
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
        String afisare;
        if(Integer.parseInt(req.getParameter("anSetat"))==0)
        {
            afisare = "Selecteaza anul: ";
            afisare = afisare + TranzactieRepository.afisareAni((Integer)session.getAttribute("id_utilizator"));
            req.setAttribute("afisare",afisare);
            req.getRequestDispatcher("/Statistici.jsp").forward(req, resp);
        }
        else if(Integer.parseInt(req.getParameter("lunaSetat"))==0)
        {
            afisare = "Selecteaza anul: ";
            afisare = afisare + TranzactieRepository.afisareAni((Integer)session.getAttribute("id_utilizator"));
            afisare = afisare + "Selecteaza luna: ";
            afisare = afisare + TranzactieRepository.afisareLuniAn((Integer)session.getAttribute("id_utilizator"),
                    Integer.parseInt(req.getParameter("an")));
            req.setAttribute("afisare",afisare);
            req.getRequestDispatcher("/Statistici.jsp").forward(req, resp);
        }
        else
        {
            afisare = "Selecteaza anul: ";
            afisare = afisare + TranzactieRepository.afisareAni((Integer)session.getAttribute("id_utilizator"));
            afisare = afisare + "Selecteaza luna: ";
            afisare = afisare + TranzactieRepository.afisareLuniAn((Integer)session.getAttribute("id_utilizator"),
                    Integer.parseInt(req.getParameter("an")));
            Double cheltuieli;
            if(req.getParameter("luna").equals("totAnul"))
            {
                afisare = afisare + "Bani cheltuiti in anul " + req.getParameter("an") + ": ";
                cheltuieli = TranzactieRepository.cheltuieliAn((Integer)session.getAttribute("id_utilizator"),
                        Integer.parseInt(req.getParameter("an")));
            }
            else {
                afisare = afisare + "Bani cheltuiti in anul " + req.getParameter("an") + " luna " +
                        req.getParameter("luna") + ": ";
                cheltuieli = TranzactieRepository.cheltuieliAnLuna((Integer) session.getAttribute("id_utilizator"),
                        Integer.parseInt(req.getParameter("an")), Integer.parseInt(req.getParameter("luna")));
            }
            if(cheltuieli != null)
            {
                afisare = afisare + Double.toString(cheltuieli);
                req.setAttribute("afisare",afisare);
                req.getRequestDispatcher("/Statistici.jsp").forward(req, resp);
            }
            else req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
        }
    }
}
