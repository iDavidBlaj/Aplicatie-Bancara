package main.java;

public class Valuta {
    private int id_valuta;
    private String semn;

    public Valuta(int id_valuta, String semn) {
        this.id_valuta = id_valuta;
        this.semn = semn;
    }

    public int getId_valuta() {
        return id_valuta;
    }

    public void setId_valuta(int id_valuta) {
        this.id_valuta = id_valuta;
    }

    public String getSemn() {
        return semn;
    }

    public void setSemn(String semn) {
        this.semn = semn;
    }

    @Override
    public String toString() {
        return "Valuta{" +
                "id_valuta=" + id_valuta +
                ", semn='" + semn + '\'' +
                '}';
    }
}
