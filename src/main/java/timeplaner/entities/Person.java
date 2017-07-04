package timeplaner.entities;


import timeplaner.entities.maindocuments.AbstractMainDocument;

public class Person extends AbstractMainDocument {

    String name;
    String surName;
    String birthDate;
    Gender gender;

    public String getPersonNames(){
        return name + surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    enum Gender{
        MALE("Male"),
        FEMALE("Female"),
        ;

        String gender;

        Gender(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return gender;
        }
    }

}
