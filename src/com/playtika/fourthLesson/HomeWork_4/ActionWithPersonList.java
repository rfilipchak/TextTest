package com.playtika.fourthLesson.HomeWork_4;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ActionWithPersonList {
    private List<Person> personArrayList;

    public ActionWithPersonList(List<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public double personsAvarageAge() {
        return personArrayList.stream()
                .mapToDouble(person -> person.getAge())
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't  count average for empty list"));
    }

    public Person maxAgePerson() {
        return personArrayList.stream()
                .max((person1, person2) -> person1.getAge() >= person2.getAge() ? 1 : -1)//(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new NoSuchElementException("Can't  count max for empty list"));
    }

    public long amountOfDaveNamedPersons() {
        return personArrayList.stream()
                .filter(person -> person.getName()
                        .equals("Dave"))
                .count();
    }

    public Map<Integer, Long> countedAgeOfPerson() {
        return personArrayList.stream()
                .collect(Collectors.groupingBy(Person::getAge,counting()));
    }

    public String cityMaxPersonAmount() {
        return personArrayList.stream().map(Person::getCity)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .max((city1, city2) -> city1.getValue() > city2.getValue() ? 1 : -1)//(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();
    }

    public Map<String, Double> averagePersonsAgePerCity() {
        return personArrayList.stream().filter(p -> p.getAge() >= 18)
                .collect(groupingBy(Person::getCity,
                        averagingInt(Person::getAge)));
    }

}
