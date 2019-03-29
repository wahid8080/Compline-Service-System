package com.example.wahid.project1.Model;

public class Hospital_HelpLine {

    private String name,phone;

    public Hospital_HelpLine() {
    }

    public Hospital_HelpLine(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
