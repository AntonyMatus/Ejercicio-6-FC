package com.example.entities;

public class Student {
    private  String name;
    private String country;
    private  String city;
    private  String phone;
    private  String email;
    private boolean status_transfer;
    private String profile_picture;
    private String cv_document;
    private Status_face_to_face Status_face_to_face;

    public Student() {
    }

    public Student(String name, String country, String city, String phone, String email, boolean status_transfer, String profile_picture, String cv_document, Status_face_to_face status_face_to_face ) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.status_transfer = status_transfer;
        this.profile_picture = profile_picture;
        this.cv_document = cv_document;
        Status_face_to_face = status_face_to_face;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean getStatus_transfer() {
        return status_transfer;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public String getCv_document() {
        return cv_document;
    }

    public Student.Status_face_to_face getStatus_face_to_face() {
        return Status_face_to_face;
    }


    @Override
    public String toString() {

        String transfer;
        if (status_transfer){
            transfer = "Si";
        } else{
            transfer = "No";
        }

        return "Student{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status_transfer=" + transfer +
                ", profile_picture='" + profile_picture + '\'' +
                ", cv_document='" + cv_document + '\'' +
                ", Status_face_to_face=" + Status_face_to_face +
                '}';
    }

    public enum Status_face_to_face {
        PRESENCIAL, REMOTO, MIXTO;
    }
}
