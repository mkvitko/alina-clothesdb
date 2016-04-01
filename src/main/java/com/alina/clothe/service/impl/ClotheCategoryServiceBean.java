package com.alina.clothe.service.impl;

import com.alina.clothe.dao.ClotheCategoryRepository;
import com.alina.clothe.entity.ClotheCategory;
import com.alina.clothe.service.ClotheCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mkvitko on 4/1/16.
 */
@Service
public class ClotheCategoryServiceBean implements ClotheCategoryService {
    @Autowired
    private ClotheCategoryRepository clotheCategoryRepository;

    private static final String SORT_PROPERTY = "name";

    @Override
    public void save(ClotheCategory object) {
        clotheCategoryRepository.save(object);
    }

    @Override
    public List<ClotheCategory> findAll() {
        return clotheCategoryRepository.findAll(new Sort(Sort.Direction.ASC, SORT_PROPERTY));
    }

    @Override
    public ClotheCategory find(String id) {
        return clotheCategoryRepository.findOne(id);
    }

    @Override
    public void remove(ClotheCategory object) {
        clotheCategoryRepository.delete(object);
    }
}
