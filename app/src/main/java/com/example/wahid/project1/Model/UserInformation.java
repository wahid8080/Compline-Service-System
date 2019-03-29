package com.example.wahid.project1.Model;

public class UserInformation {

    private String email,nid,phone,username,imageToString,dateOfBirth;
    public UserInformation() {}

    public UserInformation(String email, String nid, String phone, String username, String imageToString, String dateOfBirth) {
        this.email = email;
        this.nid = nid;
        this.phone = phone;
        this.username = username;
        this.imageToString = imageToString;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getNid() {
        return nid;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getImageToString() {
        return imageToString;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImageToString(String imageToString) {
        this.imageToString = imageToString;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
