package com.example.jour2.model;

public class Student {
    private String nom;
    private int age;
    private String rank;

    public Student(String nom, int age, String rank) {
        this.nom = nom;
        this.age = age;
        this.rank = rank;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
