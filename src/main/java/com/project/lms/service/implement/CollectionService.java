package com.project.lms.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.lms.entity.Collection;
import com.project.lms.repository.CollectionRepository;
import com.project.lms.service.ICollectionService;

import java.util.List;

@Service
public class CollectionService implements ICollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public List<Collection> getAll() {
        return collectionRepository.getCollectionsBy();
    }

    @Override
    public Collection getById(Long id) {
        return collectionRepository.getCollectionById(id);
    }

    @Override
    public Collection save(Collection collection) {
        return collectionRepository.saveAndFlush(collection);
    }

    @Override
    public void delete(Long id) {
        collectionRepository.deleteById(id);
    }
}
