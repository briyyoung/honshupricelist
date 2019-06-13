package com.example.brianyoung.testing;

public class Person {
    private String name;
    private String birthday;
    private String sex;
    private String imgUrl;

    public Person(String name, String birthday,  String sex, String imgUrl ) {
        this.birthday = birthday;
        this.name = name;
        this.sex = sex;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
