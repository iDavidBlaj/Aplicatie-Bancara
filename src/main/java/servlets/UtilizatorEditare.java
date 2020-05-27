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


@WebServlet("/UtilizatorEditare")

public class UtilizatorEditare extends HttpServlet
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
        Utilizator utilizator = UtilizatorRepository.findUserById((Integer)session.getAttribute("id_utilizator"));
        if(utilizator==null)
            req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
        else {
            String afisare = "<form method=\"post\" action=\"/UtilizatorEditare\">"
                    + "username: " + "<input type=\"text\" name=\"username\">" + utilizator.getUsername()
                    + " MIN 4 litere si MIN 2 cifre ALFABET ENGLEZ" + "<br>"
                    + "parola: " + "<input type=\"text\" name=\"parola\">" + utilizator.getParola()
                    + " MIN 4 litere si MIN 2 cifre ALFABET ENGLEZ" + "<br>"
                    + "nume: " + "<input type=\"text\" name=\"nume\">" + utilizator.getNume()
                    + " MIN 2 litere FARA cifre ALFABET ROMÂN" + "<br>"
                    + "prenume: " + "<input type=\"text\" name=\"prenume\">" + utilizator.getPrenume()
                    + " MIN 2 litere FARA cifre ALFABET ROMÂN" + "<br>"
                    + "data nasterii: " + "<input type=\"text\" name=\"data_nasterii\">" + utilizator.getData_nasterii()
                    + " FORMAT: ZI-LUNA-AN" + "<br>"
                    + "email: " + "<input type=\"text\" name=\"email\">" + utilizator.getEmail()
                    + " @gmail.com, @yahoo.com, @outlook.com" + "<br>"
                    + "nr telefon: " + "<input type=\"text\" name=\"nr_telefon\">" + utilizator.getNr_telefon()
                    + " FORMAT ROMÂN" + "<br>"
                    + "<input type=\"submit\" value=\"Editeaza\"></form>";
            req.setAttribute("afisare",afisare);
            req.getRequestDispatcher("/UtilizatorEditare.jsp").forward(req, resp);
        }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        HttpSession session = req.getSession();
        if(session.getAttribute("id_utilizator") == null)
        {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        String username = req.getParameter("username");
        String parola = req.getParameter("parola");
        String nume = req.getParameter("nume");
        String prenume = req.getParameter("prenume");
        String data_nasterii = req.getParameter("data_nasterii");
        String email = req.getParameter("email");
        String nr_telefon = req.getParameter("nr_telefon");

        Utilizator utilizator = UtilizatorRepository.findUserById((Integer)session.getAttribute("id_utilizator"));
        if(utilizator==null)
            req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
        else {
            if (UtilizatorRepository.checkUsername(username) == 0) {
                username = utilizator.getUsername();
            }
            if (UtilizatorRepository.checkParola(parola) == 0) {
                parola = utilizator.getParola();
            }
            if (UtilizatorRepository.checkNume(nume) == 0) {
                nume = utilizator.getNume();
            }
            if (UtilizatorRepository.checkPrenume(prenume) == 0) {
                prenume = utilizator.getPrenume();
            }
            if (UtilizatorRepository.parseDataNasterii(data_nasterii) == null) {
                data_nasterii = "inapoi";
            }
            if (UtilizatorRepository.checkEmail(email) == 0) {
                email = utilizator.getEmail();
            }
            if (UtilizatorRepository.checkNrtelefon(nr_telefon) == 0) {
                nr_telefon = utilizator.getNr_telefon();
            }
            if(data_nasterii.equals("inapoi"))
            {
                utilizator = UtilizatorRepository.updateUser(new Utilizator((Integer)session.getAttribute("id_utilizator"),
                        nume, prenume, utilizator.getData_nasterii(), email, nr_telefon, username, parola));
            }
            else {
                utilizator = UtilizatorRepository.updateUser(new Utilizator((Integer)session.getAttribute("id_utilizator"),
                        nume, prenume, UtilizatorRepository.parseDataNasterii(req.getParameter("data_nasterii")),
                        email, nr_telefon, username, parola));
            }

            req.getRequestDispatcher("/MeniuUtilizator.jsp").forward(req, resp);
        }
    }
}
