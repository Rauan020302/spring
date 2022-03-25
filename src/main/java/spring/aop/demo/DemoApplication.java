package spring.aop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCart cart = context.getBean(ShoppingCart.class);
        cart.checkout("OK");

        System.out.println(cart.quantity());
    }

}
