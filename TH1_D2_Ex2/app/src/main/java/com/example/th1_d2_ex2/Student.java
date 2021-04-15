package com.example.th1_d2_ex2;

public class Student {
    private String Name;
    private String Id;
    private String Gender;
    private String BoD;
    private int image;

    public Student() {
        Name = "";
        Id = "";
        Gender = "";
        BoD = "";
        this.image = 0;
    }

    public Student(String name, String id, String gender, String boD, int image) {
        Name = name;
        Id = id;
        Gender = gender;
        BoD = boD;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getBoD() {
        return BoD;
    }

    public void setBoD(String boD) {
        BoD = boD;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
