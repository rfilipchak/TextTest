package com.playtika.fourthLesson.HomeWork_4;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class ActionWithPersonList {
    private List<Person> personArrayList;

    public ActionWithPersonList(List<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public double personsAvarageAge() {
        return personArrayList.stream()
                .mapToDouble(person -> person.getAge())
                .average()
                .orElse(0);
    }

    public double personsMoreThanEightingAvarageAge() {
        return personArrayList.stream().filter(person -> person.getAge() >= 18)
                .mapToDouble(person -> person.getAge())
                .average()
                .orElse(0);
    }
    public Person maxAgePerson(){
        return personArrayList.stream()
                .max((person1, person2) -> person1.getAge() >= person2.getAge()? 1:-1)//(Comparator.comparing(Person::getAge))
                .orElseThrow(() ->new IllegalStateException());
    }

    public Map<String, Integer> getSortedMaxAgePerson(){
        return personArrayList.stream()
                .collect(toMap(Person::getName,
                        Person::getAge,
                        Integer::max));
    }

    //- посчитать количество людей с именем Dave
    public long amountDaveNamedPersons() {
        return personArrayList.stream().filter(person -> person.getName().equals("Dave"))
                .count();
    }
    //- найти город, в котором больше всего людей

    public String cityMaxPersonAmount() {

        return personArrayList.stream().map(Person::getCity)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().max((city1,city2) -> city1.getValue() > city2.getValue() ? 1:-1 )//(Comparator.comparing(Map.Entry::getValue))
                .get().getKey();
    }


}
