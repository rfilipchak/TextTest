package com.playtika.fourthLesson.HomeWork_4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) throws IOException {
        // Работа  с файлами
//        String fileFirst = "D:\\JavaCourses\\FilesForTests\\text1.txt";
//        String fileSecond = "D:\\JavaCourses\\FilesForTests\\text2.txt";
//        String fileCopySecond = "D:\\JavaCourses\\FilesForTests\\fileCopySecond.txt";
//        String directory = "D:\\JavaCourses\\FilesForTests\\";
//
//        new FileAndTextReader(directory).filesFromDirectoryData();
//        System.out.println(new FileAndTextReader(directory).agreateadGetWordsFrequenciesForDirectoriesFiles());

        // Стримы  Persons
        List<Person> personsList = Arrays.asList(
                new Person("Dave", 34, "Kiev"),
                new Person("Dave", 32, "Kiev"),
                new Person("Dave1", 32, "Malin"),
                new Person("Dave3", 31, "Malin"),
                new Person("Dave3", 35, "Malin"),
                new Person("Dave", 32, "Kiev"),
                new Person("Dave1", 32, "Kiev"),
                new Person("Dave3", 17, "Malin"),
                new Person("Ivan", 10, "Oslo"),
                new Person("Sem", 37, "Oslo")
        );


        ActionWithPersonList action = new ActionWithPersonList(personsList);
        ActionWithPersonList forEmptyList = new ActionWithPersonList(Collections.EMPTY_LIST);

        System.out.println(action.averagePersonsAgePerCity());
        System.out.println(action.amountOfDaveNamedPersons());
        System.out.println(action.cityMaxPersonAmount());
        System.out.println(action.maxAgePerson().getAge());
        System.out.println(action.personsAvarageAge());

//        System.out.println(forEmptyList.personsAvarageAge());
//        System.out.println(forEmptyList.maxAgePerson());
//        System.out.println(forEmptyList.amountDaveNamedPersons());
//        System.out.println(forEmptyList.cityMaxPersonAmount());
//        System.out.println(forEmptyList.getSortedMaxAgePerson());
//        System.out.println(forEmptyList.averagePersonsAgePerCity());
    }
}
