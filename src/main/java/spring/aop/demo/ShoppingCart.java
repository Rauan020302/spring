package spring.aop.demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(String status) {
        //Logging
        //Authentication & Authorization
        //Sanitize the Data
        System.out.println(
                "Checkout Method from Shopping cart called " + status);
    }
    public int quantity() {
        return 2;
    }
}
