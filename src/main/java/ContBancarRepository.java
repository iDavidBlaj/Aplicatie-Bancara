package main.java;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ContBancarRepository
{
    public static ContBancar findContBancar(String iban)
    {
        ContBancar contbancar;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.findContBancar);
            statement.setString(1, iban);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                contbancar = new ContBancar(rs.getInt("id_contbancar"), rs.getString("iban"),
                        rs.getDouble("sold"), rs.getInt("id_valuta"),
                        rs.getInt("id_utilizator"));
                rs.close();
                return contbancar;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String showConturi(int id_utilizator)
    {
        String afisare = "";
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.showConturi);
            statement.setInt(1, id_utilizator);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                String iban = rs.getString("iban");
                afisare = afisare + "IBAN: " + iban + "<br>"
                                  + "SOLD: " + rs.getDouble("sold") + "<br>"
                                  + "VALUTA: " + getValuta(rs.getInt("id_valuta"))
                        + "<br><form method=\"post\" action=\"/ContBancarSold\">"
                        + "<input type=\"hidden\" name=\"iban\" value =\"" + iban + "\">"
                        + "<input type=\"text\" name=\"suma\">"
                        + "<select name=\"decizie\">"
                        + "<option value=\"deposit\">Adauga</option>"
                        + "<option value=\"withdraw\">Retrage</option>"
                        + "<input type=\"submit\" value=\"Actioneaza\">"
                        + "</select></form>";
            }
            return afisare;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String showConturiSimplu(int id_utilizator)
    {
        String afisare = "";
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.showConturi);
            statement.setInt(1, id_utilizator);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                String iban = rs.getString("iban");
                afisare = afisare + "IBAN: " + iban + "<br>"
                        + "SOLD: " + rs.getDouble("sold") + "<br>"
                        + "VALUTA: " + getValuta(rs.getInt("id_valuta") ) + "<br><br>";
            }
            return afisare;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getValuta(int id_valuta)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.getValuta);
            statement.setInt(1, id_valuta);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                return rs.getString("semn");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ContBancar addContBancar(ContBancar contbancar)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.addContBancar);
            statement.setInt(1, contbancar.getId_contbancar());
            statement.setString(2, contbancar.getIban());
            statement.setDouble(3, contbancar.getSold());
            statement.setInt(4, contbancar.getId_valuta());
            statement.setInt(5, contbancar.getId_utilizator());
            statement.executeUpdate();

            return contbancar;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ContBancar deposit(ContBancar contbancar, double sold)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.updateSold);
            statement.setDouble(1, contbancar.getSold() + sold);
            statement.setString(2, contbancar.getIban());
            statement.executeUpdate();
            return contbancar;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ContBancar withdraw(ContBancar contbancar, double sold)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.updateSold);
            statement.setDouble(1, contbancar.getSold() - sold);
            statement.setString(2, contbancar.getIban());
            statement.executeUpdate();
            return contbancar;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String generateIban()
    {
        Random random = new Random();
        String iban = "RO";
        for(int i=1; i<=2; i++){
            int cifra = random.nextInt(10);
            iban = iban + Integer.toString(cifra);
        }
        iban = iban + "BANK";
        for(int i=1; i<=16; i++){
            int cifra = random.nextInt(10);
            iban = iban + Integer.toString(cifra);
        }
        return iban;
    }

    public static int generateId()
    {
        int id = 0;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.showAllConturi);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id+1;
    }
}
