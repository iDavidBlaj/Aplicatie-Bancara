package main.java;

public class ContBancar {
    private int id_contbancar;
    private String iban;
    private double sold;
    private int id_valuta;
    private int id_utilizator;

    public ContBancar(int id_contbancar, String iban, double sold, int id_valuta, int id_utilizator) {
        this.id_contbancar = id_contbancar;
        this.iban = iban;
        this.sold = sold;
        this.id_valuta = id_valuta;
        this.id_utilizator = id_utilizator;
    }

    public int getId_contbancar() {
        return id_contbancar;
    }

    public void setId_contbancar(int id_contbancar) {
        this.id_contbancar = id_contbancar;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public int getId_valuta() {
        return id_valuta;
    }

    public void setId_valuta(int id_valuta) {
        this.id_valuta = id_valuta;
    }

    public int getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(int id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    @Override
    public String toString() {
        return "ContBancar{" +
                "id_contbancar=" + id_contbancar +
                ", iban='" + iban + '\'' +
                ", sold=" + sold +
                ", id_valuta=" + id_valuta +
                ", id_utilizator=" + id_utilizator +
                '}';
    }
}