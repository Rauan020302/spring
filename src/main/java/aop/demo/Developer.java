package aop.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Component
public class Developer {
    private String name = "Rauan";
    private String specialty = "JavaDeveloper";
    private Integer experience = 3;

    public void throwSomeMysticException(){
        System.out.println("We have some strange and mystic exception here:");
        throw new ClassCastException();
    }

}
