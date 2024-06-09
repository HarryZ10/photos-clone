package com.harryzhu.api.photos_clone.web;

import com.harryzhu.api.photos_clone.model.Photo;
import com.harryzhu.api.photos_clone.service.PhotoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    private final PhotoService _photoService;
    public DownloadController(PhotoService photoService) {
        this._photoService = photoService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable("id") Integer id) {
        Photo photo = this._photoService.getPhoto(id);

        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));

        ContentDisposition build = ContentDisposition
                .builder("inline")
                .filename(photo.getFileName())
                .build();

        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
