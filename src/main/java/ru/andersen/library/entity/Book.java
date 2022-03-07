package ru.andersen.library.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Book extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "image")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
