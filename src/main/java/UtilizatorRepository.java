package main.java;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UtilizatorRepository
{
    public static Utilizator findUser(String username, String parola)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.findUser);
            statement.setString(1, username);
            statement.setString(2, parola);
            Utilizator utilizator;
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                utilizator = new Utilizator(rs.getInt("id_Utilizator"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getDate("data_nasterii"),
                        rs.getString("email"), rs.getString("nr_telefon"),
                        rs.getString("username"), rs.getString("parola"));
                rs.close();
                return utilizator;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Utilizator findUserById(int id_utilizator)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.findUserById);
            statement.setInt(1, id_utilizator);
            Utilizator utilizator;
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                utilizator = new Utilizator(rs.getInt("id_Utilizator"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getDate("data_nasterii"),
                        rs.getString("email"), rs.getString("nr_telefon"),
                        rs.getString("username"), rs.getString("parola"));
                rs.close();
                return utilizator;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Utilizator addUser(Utilizator utilizator)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.addUser);
            statement.setInt(1, utilizator.getId_Utilizator());
            statement.setString(2, utilizator.getNume());
            statement.setString(3, utilizator.getPrenume());
            statement.setDate(4, utilizator.getData_nasterii());
            statement.setString(5, utilizator.getEmail());
            statement.setString(6, utilizator.getNr_telefon());
            statement.setString(7, utilizator.getUsername());
            statement.setString(8, utilizator.getParola());
            statement.executeUpdate();

            return utilizator;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Utilizator updateUser(Utilizator utilizator)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.updateUser);

            statement.setString(1, utilizator.getNume());
            statement.setString(2, utilizator.getPrenume());
            statement.setDate(3, utilizator.getData_nasterii());
            statement.setString(4, utilizator.getEmail());
            statement.setString(5, utilizator.getNr_telefon());
            statement.setString(6, utilizator.getUsername());
            statement.setString(7, utilizator.getParola());
            statement.setInt(8, utilizator.getId_Utilizator());
            statement.executeUpdate();

            return utilizator;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int generateId()
    {
        int id = 0;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.showUsers);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id+1;
    }

    public static int checkUsername(String username)
    {
        char[] literePermise = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I',
                'j','J','k','K','l','L','m','M','n','N','o','O','p','P','q','Q','r','R','s','S','t','T',
                'u','U','v','V','w','W','x','X','y','Y','z','Z'};
        char[] cifrePermise = {'0','1','2','3','4','5','6','7','8','9'};
        int nrLitere=0, nrCifre=0, secvIndex=0;
        char[] secv = username.toCharArray();

        for(int z=0; z<literePermise.length+cifrePermise.length && secvIndex<secv.length; z++)
        {
            int gasit = 0;
            for(int i=0; i<literePermise.length; i++)
            {
                if(secv[secvIndex] == literePermise[i])
                {
                    nrLitere++;
                    secvIndex++;
                    gasit = 1;
                    break;
                }
            }
            if(gasit==0)
            {
                for(int j=0; j<cifrePermise.length; j++)
                {
                    if(secv[secvIndex] == cifrePermise[j])
                    {
                        nrCifre++;
                        secvIndex++;
                        gasit = 1;
                        break;
                    }
                }
            }
            if(gasit==0)
                return 0;
        }
        if(nrLitere<4 || nrCifre<2)
            return 0;
        return 1;
    }

    public static int checkParola(String parola)
    {
        char[] literePermise = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I',
                'j','J','k','K','l','L','m','M','n','N','o','O','p','P','q','Q','r','R','s','S','t','T',
                'u','U','v','V','w','W','x','X','y','Y','z','Z'};
        char[] cifrePermise = {'0','1','2','3','4','5','6','7','8','9'};
        int nrLitere=0, nrCifre=0, secvIndex=0;
        char[] secv = parola.toCharArray();

        for(int z=0; z<literePermise.length+cifrePermise.length && secvIndex<secv.length; z++)
        {
            int gasit = 0;
            for(int i=0; i<literePermise.length; i++)
            {
                if(secv[secvIndex] == literePermise[i])
                {
                    nrLitere++;
                    secvIndex++;
                    gasit = 1;
                    break;
                }
            }
            if(gasit==0)
            {
                for(int j=0; j<cifrePermise.length; j++)
                {
                    if(secv[secvIndex] == cifrePermise[j])
                    {
                        nrCifre++;
                        secvIndex++;
                        gasit = 1;
                        break;
                    }
                }
            }
            if(gasit==0)
                return 0;
        }
        if(nrLitere<4 || nrCifre<2)
            return 0;
        return 1;
    }

    public static int checkNume(String nume)
    {
        char[] literePermise = {'a','A','ă','Ă','â','Â','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I',
                'î','Î','j','J','k','K','l','L','m','M','n','N','o','O','p','P','q','Q','r','R','s','S','ș','Ș',
                't','T','ț','Ț','u','U','v','V','w','W','x','X','y','Y','z','Z'};
        int nrLitere=0, secvIndex=0;
        char[] secv = nume.toCharArray();

        for(int z=0; z<literePermise.length && secvIndex<secv.length; z++)
        {
            int gasit = 0;
            for(int i=0; i<literePermise.length; i++)
            {
                if(secv[secvIndex] == literePermise[i])
                {
                    nrLitere++;
                    secvIndex++;
                    gasit = 1;
                    break;
                }
            }
            if(gasit==0)
                return 0;
        }
        if(nrLitere<2)
            return 0;
        return 1;
    }

    public static int checkPrenume(String prenume)
    {
        char[] literePermise = {'a','A','ă','Ă','â','Â','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I',
                'î','Î','j','J','k','K','l','L','m','M','n','N','o','O','p','P','q','Q','r','R','s','S','ș','Ș',
                't','T','ț','Ț','u','U','v','V','w','W','x','X','y','Y','z','Z'};
        int nrLitere=0, secvIndex=0;
        char[] secv = prenume.toCharArray();

        for(int z=0; z<literePermise.length && secvIndex<secv.length; z++)
        {
            int gasit = 0;
            for(int i=0; i<literePermise.length; i++)
            {
                if(secv[secvIndex] == literePermise[i])
                {
                    nrLitere++;
                    secvIndex++;
                    gasit = 1;
                    break;
                }
            }
            if(gasit==0)
                return 0;
        }
        if(nrLitere<2)
            return 0;
        return 1;
    }

    public static Date parseDataNasterii(String data_nasterii)
    {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setLenient(false);
        try {
            return new java.sql.Date(format.parse(data_nasterii).getTime());
        } catch (ParseException pe) {
            return null;
        }
    }

    public static int checkEmail(String email)
    {
        if(email.endsWith("@gmail.com"))
            return 1;
        if(email.endsWith("@yahoo.com"))
            return 1;
        if(email.endsWith("@outlook.com"))
            return 1;
        return 0;
    }

    public static int checkNrtelefon(String nr_telefon)
    {
        if(nr_telefon.length() == 10)
        {
            if(nr_telefon.startsWith("071"))
                return 1;
            if(nr_telefon.startsWith("072"))
                return 1;
            if(nr_telefon.startsWith("073"))
                return 1;
            if(nr_telefon.startsWith("074"))
                return 1;
        }
        return 0;
    }
}