package com.example.th1_d1_ex2;

public class Job {
    private String name;
    private String salary;
    private String dateCreated;
    private boolean activated;
    private int image;

    public Job(){
        this.name = "";
        this.salary = "0.0";
        this.dateCreated = "";
        this.activated = false;
        this.image = 0;
    }

    public Job(String name, String salary, String dateCreated, boolean activated, int image) {
        this.name = name;
        this.salary = salary;
        this.dateCreated = dateCreated;
        this.activated = activated;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
