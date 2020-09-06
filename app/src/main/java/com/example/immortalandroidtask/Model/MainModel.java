package com.example.immortalandroidtask.Model;

public class MainModel {

    Integer lanLogo;
    String langName;
    String langName2;

    public MainModel(Integer langLogo, String langName, String langName2) {
        this.langName = langName;
        this.lanLogo = langLogo;
        this.langName2 = langName2;
    }

    public String getLangName2() {
        return langName2;
    }

    public Integer getLanLogo() {
        return lanLogo;
    }

    public String getLangName() {
        return langName;
    }
}
