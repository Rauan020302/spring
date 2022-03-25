package spring.aop.demo.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Task {
    private Long id;

    private String title;

    private String description;

    private Date startDate;

    private Date endDate;


}
