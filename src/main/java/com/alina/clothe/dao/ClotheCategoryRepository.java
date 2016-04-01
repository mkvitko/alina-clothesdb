package com.alina.clothe.dao;

import com.alina.clothe.entity.ClotheCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mkvitko on 4/1/16.
 */
@Repository
public interface ClotheCategoryRepository extends MongoRepository<ClotheCategory, String>{
}
