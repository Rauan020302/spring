package ru.andersen.library.service;

import ru.andersen.library.entity.Book;
import ru.andersen.library.model.BookModel;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    Book saveBook(BookModel bookModel);
    Book updateBook(BookModel bookModel,Long id);
    Book deleteBookById(Long id);
}
