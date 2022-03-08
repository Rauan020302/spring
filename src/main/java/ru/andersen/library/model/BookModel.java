package ru.andersen.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookModel {

    private String title;

    private String author;

    private String genre;

    private String description;

    private Long imageId;

    private Long UserId;
}
