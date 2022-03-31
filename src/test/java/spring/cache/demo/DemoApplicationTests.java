package spring.cache.demo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void before() {
        personRepository.init(Arrays.asList(
                new Person("Rauan",20),
                new Person("Emir",12),
                new Person("Turan",35),
                new Person("Alex",56)
        ));
    }
    private Person findCacheByName(String name){
        logger.info("begin find " + name);
        final Person person = personRepository.findCacheByName(name);
        logger.info("find result = " + person.toString());
        return person;
    }

    @Test
    public void findByName() {
        //t65findCacheByName("Rauan");
        findCacheByName("Rauan");
    }

}
