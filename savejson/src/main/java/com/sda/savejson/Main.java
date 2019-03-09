package com.sda.savejson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.json.Address;
import com.sda.json.Person;
import com.sda.json.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void writePersonList () throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Person person2 = new Person("Barnaba", "Walizka", 122);
        Person person3 = new Person("Tomasz", "Walizka", 66);
        Person person4 = new Person("Krzysziek", "Petarda", 80);

        // lista osob - zapisac do jsona i do pliku

//        List<Person> personList = new LinkedList<>();
//        personList.add(person1);
//        personList.add(person2);
//        personList.add(person3);
//        personList.add(person4);

        List<Person> personList = Arrays.asList(person2, person3, person4);

        String personListString = mapper.writeValueAsString(personList);

        try {
            Files.write(Paths.get("personList.json"), personListString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writePerson () throws JsonProcessingException {

        //tworze jasona z obiektu

        Person person1 = new Person("Ryszard", "Kowalski", 30);


        ObjectMapper mapper = new ObjectMapper();

        String personStr = mapper.writeValueAsString(person1);
        System.out.println("personStr = " + personStr);

        //zapisac to do pliku

        try {
            Files.write(Paths.get("person.json"), personStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeStudentList() throws JsonProcessingException {

        // lista studentow zapisac do jsona i pliku

//        List<Student> studentList = new LinkedList<>();
//        studentList.add(student1);
//        studentList.add(student2);
//        studentList.add(student3);
//        studentList.add(student4);
        ObjectMapper mapper = new ObjectMapper();


        Address address1 = new Address("Bydgoszcz", "Krzywa");

        Student student1 = new Student("Bob", "Oklahoma", address1);
        Student student2 = new Student("Richard", "Smith", address1);
        Student student3 = new Student("Tom", "Uruk", address1);
        Student student4 = new Student("Bamboo", "Tenderoo", address1);

        List <Student> studentList = Arrays.asList(student1, student2, student3, student4);

        String studentListString = mapper.writeValueAsString(studentList);

        try {
            Files.write(Paths.get("studentList.json"), studentListString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws JsonProcessingException {

        writePerson();
        writePersonList();
        writeStudentList();

    }



}
