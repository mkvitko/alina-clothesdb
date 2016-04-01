package com.alina.clothe.dao;


import com.alina.clothe.entity.ClotheInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author mkvitko
 */
@Repository
public interface ClotheInfoRepository extends MongoRepository<ClotheInfo, String> {
    ClotheInfo findByName(String name);
}
