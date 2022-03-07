package ru.andersen.library.service;

import org.springframework.web.multipart.MultipartFile;
import ru.andersen.library.entity.Image;

import java.util.List;

public interface ImageService {
    Image createImage(MultipartFile multipartFile);
    List<Image> getAllImage();
    Image getImageById(Long id);
    Image deleteImageById(Long id);
}
