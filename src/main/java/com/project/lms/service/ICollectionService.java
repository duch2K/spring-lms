package com.project.lms.service;

import com.project.lms.entity.Collection;

import java.util.List;

public interface ICollectionService {
    List<Collection> getAll();
    Collection getById(Long id);
    Collection save(Collection collection);
    void delete(Long id);
}
