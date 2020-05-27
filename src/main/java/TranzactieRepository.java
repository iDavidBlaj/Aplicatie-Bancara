package main.java;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TranzactieRepository
{
    public static String afisareAni(int id_utilizator)
    {
        String afisare = "<form method=\"post\" action=\"/Statistici\">"
                + "<input type=\"hidden\" name=\"anSetat\" value=\"1\">"
                + "<input type=\"hidden\" name=\"lunaSetat\" value=\"0\">"
                + "<select name=\"an\">";
        String an;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.extrageAni);
            statement.setInt(1, id_utilizator);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                an = rs.getString("AN");
                afisare = afisare + "<option value=\"" + an + "\">" + an + "</option>";
            }
            afisare = afisare + "<input type=\"submit\" value=\"Seteaza an\">"
                    + "</select></form>";
            return afisare;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String afisareLuniAn(int id_utilizator, int an)
    {
        String afisare = "<form method=\"post\" action=\"/Statistici\">"
                + "<input type=\"hidden\" name=\"anSetat\" value=\"1\">"
                + "<input type=\"hidden\" name=\"lunaSetat\" value=\"1\">"
                + "<input type=\"hidden\" name=\"an\" value=\"" + an + "\">"
                + "<select name=\"luna\">";
        String luna;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.extrageLuniAn);
            statement.setInt(1, id_utilizator);
            statement.setInt(2, an);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                luna = rs.getString("LUNA");
                afisare = afisare + "<option value=\"" + luna + "\">" + luna + "</option>";
            }
            afisare = afisare + "<option value=\"totAnul\">Tot anul</option>"
                    + "<input type=\"submit\" value=\"Seteaza luna\">"
                    + "</select></form>";
            return afisare;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double cheltuieliAn(int id_utilizator, int an)
    {
        double cheltuieli = 0.0;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.cheltuieliAn);
            statement.setInt(1, id_utilizator);
            statement.setInt(2, an);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                cheltuieli = cheltuieli + rs.getDouble("SUMA");
            }
            return cheltuieli;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double cheltuieliAnLuna(int id_utilizator, int an, int luna)
    {
        double cheltuieli = 0.0;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.cheltuieliAnLuna);
            statement.setInt(1, id_utilizator);
            statement.setInt(2, an);
            statement.setInt(3, luna);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                cheltuieli = cheltuieli + rs.getDouble("SUMA");
            }
            return cheltuieli;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Tranzactie addTranzactie(Tranzactie tranzactie)
    {
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.addTranzactie);
            statement.setInt(1, tranzactie.getId_tranzactie());
            statement.setInt(2, tranzactie.getId_debitor());
            statement.setInt(3, tranzactie.getId_creditor());
            statement.setDouble(4, tranzactie.getSuma());
            statement.setTimestamp(5, tranzactie.getData_tranzactie());
            statement.executeUpdate();
            return tranzactie;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int generateId()
    {
        int id = 0;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.showAllTranzactii);
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
