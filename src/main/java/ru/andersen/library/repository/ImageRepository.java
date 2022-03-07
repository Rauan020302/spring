package ru.andersen.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andersen.library.entity.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
