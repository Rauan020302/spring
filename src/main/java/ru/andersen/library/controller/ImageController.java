package ru.andersen.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.andersen.library.entity.Image;
import ru.andersen.library.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping
    public Image createImage(@RequestParam(name = "file")MultipartFile multipartFile){
        return imageService.createImage(multipartFile);
    }

    @GetMapping
    public List<Image> getAllImage() {
        return imageService.getAllImage();
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id){
        return imageService.getImageById(id);
    }
}
