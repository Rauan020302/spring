package ru.andersen.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andersen.library.entity.Book;
import ru.andersen.library.entity.Image;
import ru.andersen.library.entity.User;
import ru.andersen.library.exceptions.ObjectsNotFoundException;
import ru.andersen.library.model.BookModel;
import ru.andersen.library.repository.BookRepository;
import ru.andersen.library.service.BookService;
import ru.andersen.library.service.ImageService;
import ru.andersen.library.service.UserService;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ObjectsNotFoundException("not found Book by id - " + id));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book saveBook(BookModel bookModel) {
        Image image = imageService.getImageById(bookModel.getImageId());
        User user = userService.getUserById(bookModel.getUserId());
        try {
            if (image == null || user == null) throw new ObjectsNotFoundException();

            Book book = Book.builder()
                    .title(bookModel.getTitle())
                    .author(bookModel.getAuthor())
                    .description(bookModel.getDescription())
                    .genre(bookModel.getGenre())
                    .image(image)
                    .user(user).build();
            return bookRepository.save(book);
        }catch (ObjectsNotFoundException e){
            throw new ObjectsNotFoundException("Image or User not found ");
        }
    }

    @Override
    public Book updateBook(BookModel bookModel, Long id) {
        Image image = imageService.getImageById(bookModel.getImageId());
        User user = userService.getUserById(bookModel.getUserId());
        try {
            if (image == null || user == null) throw new ObjectsNotFoundException();

            Book book = getBookById(id);
            book.setAuthor(bookModel.getAuthor());
            book.setDescription(bookModel.getDescription());
            book.setGenre(bookModel.getGenre());
            book.setTitle(bookModel.getTitle());
            book.setImage(image);
            book.setUser(user);
            return bookRepository.save(book);
        }catch (ObjectsNotFoundException e){
            throw new ObjectsNotFoundException("not found Book by id - " + id);
        }
    }

    @Override
    public Book deleteBookById(Long id) {
        Book book = getBookById(id);
        if (book != null) {
            bookRepository.delete(book);
            return book;
        }
        return null;
    }
}
