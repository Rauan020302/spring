package aop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(AspectConfig.class);
        Developer developer = context.getBean(Developer.class);

        System.out.println(developer);
        developer.throwSomeMysticException();
    }

}
