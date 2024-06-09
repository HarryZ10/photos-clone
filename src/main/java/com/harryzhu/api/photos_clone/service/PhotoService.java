package com.harryzhu.api.photos_clone.service;
import com.harryzhu.api.photos_clone.model.Photo;
import com.harryzhu.api.photos_clone.repository.PhotoRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    private final PhotoRepository _photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this._photoRepository = photoRepository;
    }

    public Iterable<Photo> getAllPhotos() {
        return this._photoRepository.findAll();
    }

    public Photo getPhoto(Integer id) {
        return this._photoRepository.findById(id).orElse(null);
    }

    public void deletePhoto(Integer id) {
        this._photoRepository.deleteById(id);
    }

    public Photo savePhoto(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setData(data);
        photo.setContentType(contentType);
        this._photoRepository.save(photo);
        return photo;
    }
}
