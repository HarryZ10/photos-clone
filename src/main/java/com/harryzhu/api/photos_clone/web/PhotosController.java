package com.harryzhu.api.photos_clone.web;

import com.harryzhu.api.photos_clone.model.Photo;
import com.harryzhu.api.photos_clone.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotosController {
    private final PhotoService _photoService;

    public PhotosController(PhotoService photoService) {
        this._photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/photos")
    public Iterable<Photo> photos() {
        return this._photoService.getAllPhotos();
    }

    @GetMapping("/photos/{id}")
    public Photo photos(@PathVariable Integer id) {
        Photo photo = this._photoService.getPhoto(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable Integer id) {
        this._photoService.deletePhoto(id);
    }

    @PostMapping("/photos")
    public Photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        String contentType = file.getContentType();
        return this._photoService.savePhoto(fileName, contentType, bytes);
    }

}
