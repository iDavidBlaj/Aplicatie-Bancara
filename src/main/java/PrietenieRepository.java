package main.java;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class PrietenieRepository
{
    public static String showPrieteni(int id_utilizator)
    {
        String afisare = "";
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.showPrieteni);
            statement.setInt(1, id_utilizator);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                afisare = afisare + "IBAN: " + rs.getString("iban") + "<br>"
                        + "VALUTA: " + rs.getString("semn") + "<br>"
                        + "DETINATOR: " + rs.getString("nume") + " "
                        + rs.getString("prenume") + " " + "<br><br>";
            }
            return afisare;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Prietenie addPrietenie(Prietenie prietenie)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.addPrietenie);
            statement.setInt(1, prietenie.getId_utilizator());
            statement.setInt(2, prietenie.getId_contbancar());
            statement.executeUpdate();
            return prietenie;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int stergePrietenie(int id_utilizator, int id_contbancar)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.stergePrietenie);
            statement.setInt(1, id_utilizator);
            statement.setInt(2, id_contbancar);
            statement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
