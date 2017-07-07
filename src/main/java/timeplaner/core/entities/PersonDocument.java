package timeplaner.core.entities;


import timeplaner.core.entities.maindocuments.AbstractMainDocument;

import java.util.Arrays;
import java.util.List;

public class PersonDocument extends AbstractMainDocument {

//    private String name;
    private String surName;
    private String birthDate;
    private Gender gender;

    public PersonDocument(String name, String description) {
        super(name, description);
    }

    public String getPersonNames(){
        return name + surName;
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

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

    public enum Gender{
        MALE("Male"),
        FEMALE("Female"),
        ;

        String gender;

        Gender(String gender) {
            this.gender = gender;
        }

        public String getString() {
            return gender;
        }

        public static Gender getGender(String sex){
            List<Gender> genders = Arrays.asList(values());
            for (Gender gender : genders) {
                if(gender.getString().equals(sex)){
                    return gender;
                }
            }
            return null;
        }

        public static String[] getAllGenders(){
                return new String[]{MALE.gender, FEMALE.gender};
        }
    }

}
