package main.java.servlets;

import main.java.Utilizator;
import main.java.UtilizatorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UtilizatorCreare")
public class UtilizatorCreare extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        String parola = req.getParameter("parola");
        String nume = req.getParameter("nume");
        String prenume = req.getParameter("prenume");
        String data_nasterii = req.getParameter("data_nasterii");
        String email = req.getParameter("email");
        String nr_telefon = req.getParameter("nr_telefon");

        if(UtilizatorRepository.checkUsername(username) == 0)
        {
            req.getRequestDispatcher("/UtilizatorCreare.jsp").forward(req, resp);
            return;
        }
        if(UtilizatorRepository.checkParola(parola) == 0)
        {
            req.getRequestDispatcher("/UtilizatorCreare.jsp").forward(req, resp);
            return;
        }
        if(UtilizatorRepository.checkNume(nume) == 0)
        {
            req.getRequestDispatcher("/UtilizatorCreare.jsp").forward(req, resp);
            return;
        }
        if(UtilizatorRepository.checkPrenume(prenume) == 0)
        {
            req.getRequestDispatcher("/UtilizatorCreare.jsp").forward(req, resp);
            return;
        }
        if(UtilizatorRepository.parseDataNasterii(data_nasterii) == null)
        {
            req.getRequestDispatcher("/UtilizatorCreare.jsp").forward(req, resp);
            return;
        }
        if(UtilizatorRepository.checkEmail(email) == 0)
        {
            req.getRequestDispatcher("/UtilizatorCreare.jsp").forward(req, resp);
            return;
        }
        if(UtilizatorRepository.checkNrtelefon(nr_telefon) == 0)
        {
            req.getRequestDispatcher("/UtilizatorCreare.jsp").forward(req, resp);
            return;
        }

        Utilizator utilizator = UtilizatorRepository.addUser(new Utilizator(UtilizatorRepository.generateId(),
                nume, prenume, UtilizatorRepository.parseDataNasterii(data_nasterii), email, nr_telefon, username, parola));
        if(utilizator == null)
            req.getRequestDispatcher("/UtilizatorCreare.jsp").forward(req, resp);
        else req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
