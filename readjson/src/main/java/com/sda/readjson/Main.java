package com.sda.readjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.json.Person;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {


    public static void readPerson(){

        ObjectMapper mapper = new ObjectMapper();

        try {
            Person person5 = mapper.readValue(new File("person.json"), Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPersonList(){

        ObjectMapper mapper = new ObjectMapper();

        try {
            Person[] personArray = mapper.readValue(new File("personList.json"), Person[].class);
            System.out.println("personArray = " + Arrays.toString(personArray));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        readPerson();
        readPersonList();
    }

}


