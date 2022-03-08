package ru.andersen.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andersen.library.entity.Book;
import ru.andersen.library.model.BookModel;
import ru.andersen.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
    @PostMapping
    public Book save(@RequestBody BookModel bookModel) {
        return bookService.saveBook(bookModel);
    }
    @DeleteMapping("/{id}")
    public Book deleteBookById(@PathVariable Long id) {
        return bookService.deleteBookById(id);
    }
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody BookModel bookModel, @PathVariable Long id) {
        return bookService.updateBook(bookModel,id);
    }
}
