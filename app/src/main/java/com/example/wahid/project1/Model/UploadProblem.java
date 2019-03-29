package com.example.wahid.project1.Model;

public class UploadProblem {

    private  String problemType,problemDiscreption,problemLocation,image;

    public UploadProblem() {

    }

    public UploadProblem(String problemType, String problemDiscreption, String problemLocation, String image) {
        this.problemType = problemType;
        this.problemDiscreption = problemDiscreption;
        this.problemLocation = problemLocation;
        this.image = image;
    }

    public String getProblemType() {
        return problemType;
    }

    public String getProblemDiscreption() {
        return problemDiscreption;
    }

    public String getProblemLocation() {
        return problemLocation;
    }

    public String getImage() {
        return image;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public void setProblemDiscreption(String problemDiscreption) {
        this.problemDiscreption = problemDiscreption;
    }

    public void setProblemLocation(String problemLocation) {
        this.problemLocation = problemLocation;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
