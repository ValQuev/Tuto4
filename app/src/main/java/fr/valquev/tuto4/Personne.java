package fr.valquev.tuto4;

public class Personne {

    private String nomPrenom;
    private int age;

    public Personne(String nomPrenom, int age) {
        this.nomPrenom = nomPrenom;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }
}
