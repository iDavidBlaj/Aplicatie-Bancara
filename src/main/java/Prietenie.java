package main.java;

public class Prietenie {
    private int id_utilizator;
    private int id_contbancar;

    public Prietenie(int id_utilizator, int id_contbancar) {
        this.id_utilizator = id_utilizator;
        this.id_contbancar = id_contbancar;
    }

    public int getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(int id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    public int getId_contbancar() {
        return id_contbancar;
    }

    public void setId_contbancar(int id_contbancar) {
        this.id_contbancar = id_contbancar;
    }

    @Override
    public String toString() {
        return "Prietenie{" +
                "id_utilizator=" + id_utilizator +
                ", id_contbancar=" + id_contbancar +
                '}';
    }
}
