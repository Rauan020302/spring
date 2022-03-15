package b2.tech.springboot.demo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //NotNull + NotEmpty = NotBlank
    @Column(name = "name")
    @NotBlank(message = "Name should not be null")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "location")
    @NotBlank(message = "location should not be null")
    private String location;

    @Column(name = "email")
    @Email(message = "Please enter the valid email address")
    private String email;

    @Column(name = "department")
    @NotBlank(message = "Department should not be null")
    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;




}
