package main.java.servlets;

import main.java.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet
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
        req.setAttribute("afisarePersonale", ContBancarRepository.showConturiSimplu((Integer)session.getAttribute("id_utilizator")));
        req.setAttribute("afisareCunoscuti", PrietenieRepository.showPrieteni((Integer)session.getAttribute("id_utilizator")));
        req.getRequestDispatcher("/Transfer.jsp").forward(req, resp);
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
        ContBancar debitor = ContBancarRepository.findContBancar(req.getParameter("ibanDebitor"));
        ContBancar creditor = ContBancarRepository.findContBancar(req.getParameter("ibanCreditor"));
        if(debitor == null || creditor == null)
            req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
        else if(debitor.getId_utilizator() != (Integer)session.getAttribute("id_utilizator")
                || debitor.getId_valuta() != creditor.getId_valuta()
                || debitor.getSold() < Double.parseDouble(req.getParameter("suma")))
            req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
        else
        {
            Tranzactie tranzactie = new Tranzactie(TranzactieRepository.generateId(),debitor.getId_contbancar(),
                    creditor.getId_contbancar(),Double.parseDouble(req.getParameter("suma")),
                    new Timestamp(System.currentTimeMillis()));
            tranzactie = TranzactieRepository.addTranzactie(tranzactie);
            if(tranzactie == null)
                req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
            else
            {
                ContBancarRepository.withdraw(debitor,Double.parseDouble(req.getParameter("suma")));
                ContBancarRepository.deposit(creditor,Double.parseDouble(req.getParameter("suma")));
                req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
            }
        }
    }
}
