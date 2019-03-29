package com.example.wahid.project1.Model;

public class Police_Helpline {

    private String thana,number;

    public Police_Helpline() {
    }

    public Police_Helpline(String thana, String number) {
        this.thana = thana;
        this.number = number;
    }

    public String getThana() {
        return thana;
    }

    public String getNumber() {
        return number;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
