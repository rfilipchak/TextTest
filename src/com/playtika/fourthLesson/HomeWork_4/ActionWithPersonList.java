package com.playtika.fourthLesson.HomeWork_4;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class ActionWithPersonList {
    private List<Person> personArrayList;

    public ActionWithPersonList(List<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    //- посчитать средний возраст
    public double personsAvarageAge() {
        return personArrayList.stream()
                .mapToDouble(person -> person.getAge())
                .average()
                .orElse(0);
    }

    //- найти самого старшего человека
    public Person maxAgePerson() {
        return personArrayList.stream()
                .max((person1, person2) -> person1.getAge() >= person2.getAge() ? 1 : -1)//(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new IllegalStateException());
    }

    //- посчитать количество людей с именем Dave
    public long amountDaveNamedPersons() {
        return personArrayList.stream()
                .filter(person -> person.getName()
                        .equals("Dave"))
                .count();
    }

    //- разбить всех людей по возрасту (Map возраста на список людей)
    public Map<String, Integer> getSortedMaxAgePerson() {
        return personArrayList.stream()
                .collect(toMap(Person::getName,
                        Person::getAge,
                        Integer::max));
    }
    //- найти город, в котором больше всего людей

    public String cityMaxPersonAmount() {
        return personArrayList.stream().map(Person::getCity)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .max((city1, city2) -> city1.getValue() > city2.getValue() ? 1 : -1)//(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();

    }

    //    - посчитать средний возраст взрослых в каждом городе (взрослые с 18 лет считаются)
    public Map<String, Double> cityMaPersonAmount() {
        return personArrayList.stream().filter(p -> p.getAge() >= 18)
                .collect(groupingBy(Person::getCity,
                        averagingInt(Person::getAge)));

    }


}
