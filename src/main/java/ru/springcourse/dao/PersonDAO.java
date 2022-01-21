package ru.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(1,"Alex"));
        people.add(new Person(2,"Bob"));
        people.add(new Person(3,"Tom"));
        people.add(new Person(4,"Sam"));
    }
    public List<Person> index() {
        return people;
    }

    public Person show (int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
