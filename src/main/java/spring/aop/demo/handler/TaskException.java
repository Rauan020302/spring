package spring.aop.demo.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskException extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public TaskException(String message) {
        super();
        this.message = message;
    }
}
