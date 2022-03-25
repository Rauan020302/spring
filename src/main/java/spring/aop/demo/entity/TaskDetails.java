package spring.aop.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class TaskDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TITLE")
    private String title;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="START_DATE")
    private Date startDate;

    @Column(name="END_DATE")
    private Date endDate;


}
