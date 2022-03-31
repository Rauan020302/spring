package spring.cache.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepository {
    private static final Logger logger = LoggerFactory.getLogger(PersonRepository.class);
    private List<Person> people = new ArrayList<>();

    public void init(List<Person> peopleList) {
        this.people.addAll(peopleList);
    }

    private Person findByName(String name) {
        Person person = people.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        return person;
    }

    @Cacheable(cacheNames = "person")
    public Person findCacheByName(String name) {
        logger.info("find person..." + name);
        final Person person = findByName(name);
        return person;
    }

    @CachePut(cacheNames = "person")
    public Person findByNameAndPut(String name) {
        logger.info("findByName and put person ... " + name);
        final Person person = findByName(name);
        logger.info("put in cache person " + person);
        return person;
    }

    public boolean delete(String name) {
        final Person person = findByName(name);
        return people.remove(person);
    }

    public boolean add(Person person) {
        return people.add(person);
    }
}
