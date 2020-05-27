package main.java;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValutaRepository
{
    public static String showValute()
    {
        String afisare = "<form method=\"post\" action=\"/ContBancarCreare\">"
                + "<select name=\"id_valuta\">";
        int id_valuta;
        String semn;
        try {
            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(DatabaseData.showValute);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                id_valuta = rs.getInt("id_valuta");
                semn = rs.getString("semn");
                afisare = afisare + "<option value=\"" + id_valuta + "\">" + semn + "</option>";
            }
            afisare = afisare + "<br><input type=\"submit\" value=\"Deschide cont\">"
                    + "</select></form>";
            return afisare;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
