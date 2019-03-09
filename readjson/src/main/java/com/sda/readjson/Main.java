package com.sda.readjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();


        //odczytaj obiekt i zmapuj

        try {
            Person person5 = mapper.readValue(new File("person.json"), Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //jak przeczytac liste?

        try {
            Person[] personArray = mapper.readValue(new File("personList.json"), Person[].class);
            System.out.println("personArray = " + Arrays.toString(personArray));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


