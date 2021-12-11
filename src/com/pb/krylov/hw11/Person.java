package com.pb.krylov.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private List<String> phones;
    private String city;
    //@JsonDeserialize(using = LocalDateDeserializer.class)
    //@JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;
    private LocalDateTime dateTimeEdit;
    public Person() {
    }
    public Person(String name, List<String> phones, String city, LocalDate dateOfBirth, LocalDateTime dateTimeEdit) {
        this.name = name;
        this.phones = phones;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.dateTimeEdit = dateTimeEdit;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTimeEdit() {
        return dateTimeEdit;
    }

    public Person(String name, List<String> phones, String city, LocalDate dateOfBirth) {
        this.name = name;
        this.phones = phones;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        dateTimeEdit= LocalDateTime.now ();
    }



    public List<String> getPhones() {
        return phones;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
        dateTimeEdit= LocalDateTime.now ();
    }
    public void addPhone(String phone) {
        this.phones.add(phone);
        dateTimeEdit= LocalDateTime.now ();
    }
    public void removePhone(int ri) {
        this.phones.remove(ri);
        dateTimeEdit= LocalDateTime.now ();
    }
    public void editPhone(int index,String phone) {
        this.phones.set(index,phone);
        dateTimeEdit= LocalDateTime.now ();
    }

    public void setCity(String city) {
        this.city = city;
        dateTimeEdit= LocalDateTime.now ();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        dateTimeEdit= LocalDateTime.now ();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phones + '\'' +
                ", city='" +city+
                ", dateOfBirth=" + dateOfBirth +
                ", dateEdit=" + dateTimeEdit +

                '}';
    }

    @Override
    public int compareTo(Person o) {
        return getName().compareTo(o.getName());
    }

    static class PersonTimeComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {
            return a.getDateTimeEdit().compareTo(b.getDateTimeEdit());
        }
    }
}
