package com.company.test;

import com.company.engine.annotations.ConsoleInput;
import com.company.engine.annotations.MaxCount;
import com.company.engine.annotations.StartMethod;

import java.util.ArrayList;
import java.util.List;

public class PersonRecorder {

    private static List<Person> personList = new ArrayList<>();

    @MaxCount(count = 2)
    private Integer maxPersonCount;


    //firstname;lastname
    @StartMethod
    public void createPerson(@ConsoleInput(displayMessage = "Enter first name and last name:") String input) {

        String[] array = input.split(";");
        String firstName = array[0];
        String lastName = array[1];

        Person person = new Person(firstName, lastName);
        if (personList.size() == maxPersonCount) {
            System.out.println("Enough users!!");
            return;
        }

        System.out.println("Added new person!");
        System.out.println(person);
        personList.add(person);
        System.out.println();
        System.out.println();

        System.out.println("All persons in the system:");
        for (int i = 0; i < personList.size(); i++) {
            System.out.printf("%s. %s\n", (i + 1), personList.get(i));
        }

        System.out.println("-----End iteration-------");
        System.out.println();
    }

}
