package spring.aop.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "spring.aop.demo")
@EnableAspectJAutoProxy
public class BeanConfig {
}
