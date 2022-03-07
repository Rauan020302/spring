package ru.andersen.library.entity;


import lombok.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "library")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Library extends BaseEntity{



    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
