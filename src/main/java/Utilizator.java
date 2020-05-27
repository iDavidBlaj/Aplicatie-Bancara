package main.java;

import java.sql.Date;

public class Utilizator
{
    private int id_Utilizator;
    private String nume;
    private String prenume;
    private Date data_nasterii;
    private String email;
    private String nr_telefon;
    private String username;
    private String parola;


    public Utilizator(int id_Utilizator, String nume, String prenume, Date data_nasterii, String email, String nr_telefon, String username, String parola) {
        this.id_Utilizator = id_Utilizator;
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
        this.email = email;
        this.nr_telefon = nr_telefon;
        this.username = username;
        this.parola = parola;
    }

    public int getId_Utilizator() {
        return id_Utilizator;
    }

    public void setId_Utilizator(int id_Utilizator) {
        this.id_Utilizator = id_Utilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_telefon() {
        return nr_telefon;
    }

    public void setNr_telefon(String nr_telefon) {
        this.nr_telefon = nr_telefon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id_Utilizator=" + id_Utilizator +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", data_nasterii='" + data_nasterii + '\'' +
                ", email='" + email + '\'' +
                ", nr_telefon='" + nr_telefon + '\'' +
                ", username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
