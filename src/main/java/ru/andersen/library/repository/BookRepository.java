package ru.andersen.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andersen.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
