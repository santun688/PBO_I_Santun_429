package com.praktikum.users;

public abstract class User {
    private final String nama, nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public abstract boolean login(String input1, String input2);

    public void displayInfo(){}

    public abstract void displayAppMenu();
}
