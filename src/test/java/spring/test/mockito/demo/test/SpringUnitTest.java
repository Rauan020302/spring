package spring.test.mockito.demo.test;

import org.springframework.boot.test.context.SpringBootTest;
import spring.test.mockito.demo.DemoApplication;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes =
        {DemoApplication.class})
public class SpringUnitTest {
}
