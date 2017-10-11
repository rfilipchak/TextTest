package com.playtika.fourthLesson.HomeWork_4;

import java.io.IOException;
import java.util.Arrays;
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
        Person Dave = new Person("Dave", 34, "Kiev");
        Person Dave1 = new Person("Dave", 32, "Kiev");
        Person Dave2 = new Person("Dave1", 32, "Malin");
        Person Dave3 = new Person("Dave3", 31, "Malin");
        Person Dave4 = new Person("Dave3", 35, "Malin");
        Person Dave5 = new Person("Dave", 32, "Kiev");
        Person Dave6 = new Person("Dave1", 32, "Kiev");
        Person Dave7 = new Person("Dave3", 17, "Malin");
        Person Dave8 = new Person("Ivan", 10, "Oslo");

        List<Person> personsList = Arrays.asList(Dave, Dave1, Dave2, Dave3, Dave4, Dave5, Dave6, Dave7, Dave8);

        ActionWithPersonList action = new ActionWithPersonList(personsList);
        System.out.println(action.cityMaPersonAmount());
        System.out.println(action.amountDaveNamedPersons());
        System.out.println(action.cityMaxPersonAmount());
        System.out.println(action.maxAgePerson().getAge());
        System.out.println(action.personsAvarageAge());
    }
}
