package com.harryzhu.api.photos_clone.repository;

import com.harryzhu.api.photos_clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}
