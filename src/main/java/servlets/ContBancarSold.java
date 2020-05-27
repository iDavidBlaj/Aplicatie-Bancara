package main.java.servlets;

import main.java.ContBancar;
import main.java.ContBancarRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ContBancarSold")
public class ContBancarSold extends HttpServlet
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
        {
            req.getRequestDispatcher("/MeniuContBancar.jsp").forward(req, resp);
        }
        else
        {
            if(req.getParameter("decizie").equals("deposit"))
                ContBancarRepository.deposit(contbancar, Double.parseDouble(req.getParameter("suma")));
            else if(req.getParameter("decizie").equals("withdraw")
                    && contbancar.getSold() >= Double.parseDouble(req.getParameter("suma")))
                ContBancarRepository.withdraw(contbancar, Double.parseDouble(req.getParameter("suma")));
            req.getRequestDispatcher("/MeniuContBancar.jsp").forward(req, resp);
        }
    }
}
