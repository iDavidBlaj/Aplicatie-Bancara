package main.java;

public interface DatabaseData
{
    // UTILIZATOR
    String findUser = "SELECT * FROM aplicatie_bancara.utilizator WHERE username= ? and parola = ?";
    String findUserById = "SELECT * FROM aplicatie_bancara.utilizator WHERE id_utilizator = ?";
    String addUser = "INSERT INTO aplicatie_bancara.utilizator(id_utilizator,nume,prenume,data_nasterii,email,nr_telefon,username,parola) VALUES(?,?,?,?,?,?,?,?)";
    String updateUser = "UPDATE aplicatie_bancara.utilizator SET nume=?,prenume=?,data_nasterii=?,email=?,nr_telefon=?, username=?,parola=? WHERE id_Utilizator=?";
    String showUsers = "SELECT * FROM aplicatie_bancara.utilizator";

    // CONTBANCAR
    String showConturi = "SELECT * FROM aplicatie_bancara.contbancar WHERE id_utilizator = ?";
    String showAllConturi = "SELECT * FROM aplicatie_bancara.contbancar";
    String addContBancar = "INSERT INTO aplicatie_bancara.contbancar(id_contbancar,iban,sold,id_valuta,id_utilizator) VALUES(?,?,?,?,?)";
    String getValuta = "SELECT semn from aplicatie_bancara.valuta WHERE id_valuta = ?";
    String updateSold = "UPDATE aplicatie_bancara.contbancar SET sold = ? WHERE iban = ?";
    String findContBancar = "SELECT * FROM aplicatie_bancara.contbancar WHERE iban = ?";

    // PRIETENIE
    String showPrieteni = "SELECT cb.iban,v.semn,u.nume,u.prenume\n"+
                          "FROM aplicatie_bancara.prietenie p JOIN aplicatie_bancara.contbancar cb USING(id_contbancar)\n"+
                          "JOIN aplicatie_bancara.utilizator u ON cb.id_utilizator = u.id_utilizator\n"+
                          "JOIN aplicatie_bancara.valuta v ON cb.id_valuta = v.id_valuta\n"+
                          "WHERE p.id_utilizator = ?";
    String addPrietenie = "INSERT INTO aplicatie_bancara.prietenie(id_utilizator,id_contbancar) VALUES(?,?)";
    String stergePrietenie = "DELETE FROM aplicatie_bancara.prietenie\n" +
            "WHERE id_utilizator = ? AND id_contbancar = ?";

    // TRANZACTIE
    String addTranzactie = "INSERT INTO aplicatie_bancara.tranzactie(id_tranzactie,id_debitor,id_creditor,suma,data_tranzactie) VALUES(?,?,?,?,?)";
    String showAllTranzactii = "SELECT * FROM aplicatie_bancara.tranzactie";
    String extrageLuniAn = "SELECT DISTINCT EXTRACT(MONTH from t.data_tranzactie) as LUNA\n" +
            "FROM aplicatie_bancara.tranzactie t JOIN aplicatie_bancara.contbancar cb ON t.id_debitor = cb.id_contbancar\n" +
            "JOIN aplicatie_bancara.utilizator u ON cb.id_utilizator = u.id_utilizator\n" +
            "WHERE (u.id_utilizator = ?) AND (EXTRACT(YEAR from t.data_tranzactie) = ?)\n" +
            "ORDER BY LUNA DESC";
    String extrageAni = "SELECT DISTINCT EXTRACT(YEAR from t.data_tranzactie) as AN\n" +
            "FROM aplicatie_bancara.tranzactie t JOIN aplicatie_bancara.contbancar cb ON t.id_debitor = cb.id_contbancar\n" +
            "JOIN aplicatie_bancara.utilizator u ON cb.id_utilizator = u.id_utilizator\n" +
            "WHERE (u.id_utilizator = ?)\n" +
            "ORDER BY AN DESC";
    String cheltuieliAn = "SELECT t.suma as SUMA\n" +
            "FROM aplicatie_bancara.tranzactie t JOIN aplicatie_bancara.contbancar cb ON t.id_debitor = cb.id_contbancar\n" +
            "JOIN aplicatie_bancara.utilizator u ON cb.id_utilizator = u.id_utilizator\n" +
            "WHERE (u.id_utilizator = ?) AND (EXTRACT(YEAR from t.data_tranzactie) = ?)";
    String cheltuieliAnLuna = "SELECT t.suma as SUMA\n" +
            "FROM aplicatie_bancara.tranzactie t JOIN aplicatie_bancara.contbancar cb ON t.id_debitor = cb.id_contbancar\n" +
            "JOIN aplicatie_bancara.utilizator u ON cb.id_utilizator = u.id_utilizator\n" +
            "WHERE (u.id_utilizator = ?) AND (EXTRACT(YEAR from t.data_tranzactie) = ?)\n" +
            "AND (EXTRACT(MONTH from t.data_tranzactie) = ?)";

    // VALUTA
    String showValute = "SELECT * from aplicatie_bancara.valuta";
}
