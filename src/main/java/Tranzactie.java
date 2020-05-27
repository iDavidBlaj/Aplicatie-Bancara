package main.java;

import java.sql.Timestamp;

public class Tranzactie
{
    private int id_tranzactie;
    private int id_debitor;
    private int id_creditor;
    private double suma;
    private Timestamp data_tranzactie;

    public Tranzactie(int id_tranzactie, int id_debitor, int id_creditor, double suma, Timestamp data_tranzactie) {
        this.id_tranzactie = id_tranzactie;
        this.id_debitor = id_debitor;
        this.id_creditor = id_creditor;
        this.suma = suma;
        this.data_tranzactie = data_tranzactie;
    }

    public int getId_tranzactie() {
        return id_tranzactie;
    }

    public void setId_tranzactie(int id_tranzactie) {
        this.id_tranzactie = id_tranzactie;
    }

    public int getId_debitor() {
        return id_debitor;
    }

    public void setId_debitor(int id_debitor) {
        this.id_debitor = id_debitor;
    }

    public int getId_creditor() {
        return id_creditor;
    }

    public void setId_creditor(int id_creditor) {
        this.id_creditor = id_creditor;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public Timestamp getData_tranzactie() {
        return data_tranzactie;
    }

    public void setData_tranzactie(Timestamp data_tranzactie) {
        this.data_tranzactie = data_tranzactie;
    }

    @Override
    public String toString() {
        return "Tranzactie{" +
                "id_tranzactie=" + id_tranzactie +
                ", id_debitor=" + id_debitor +
                ", id_creditor=" + id_creditor +
                ", suma=" + suma +
                ", data_tranzactie=" + data_tranzactie +
                '}';
    }
}
