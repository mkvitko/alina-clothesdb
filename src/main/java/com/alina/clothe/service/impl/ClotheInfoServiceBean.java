package com.alina.clothe.service.impl;

import com.alina.clothe.dao.ClotheInfoRepository;
import com.alina.clothe.entity.ClotheInfo;
import com.alina.clothe.service.ClotheInfoService;
import com.alina.clothe.service.PhotoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by mkvitko on 3/22/16.
 */
@Service
public class ClotheInfoServiceBean implements ClotheInfoService {

    private static final String SORT_PROPERTY = "addedDate";
    @Autowired
    private ClotheInfoRepository clotheInfoRepository;

    @Autowired
    private PhotoService photoService;

    @Override
    public void save(ClotheInfo object) {
        if (object.getId() != null) {
            clotheInfoRepository.delete(object);
        }
        object.setAddedDate(new Date());
        ObjectId imageId = photoService.save(object.getImagePath(), object.getAddedDate());
        object.setImageId(imageId);
        clotheInfoRepository.save(object);
    }

    @Override
    public List<ClotheInfo> findAll() {
        return clotheInfoRepository.findAll(new Sort(Sort.Direction.DESC, SORT_PROPERTY));
    }

    @Override
    public ClotheInfo find(String id) {
        return clotheInfoRepository.findOne(id);
    }

    @Override
    public ClotheInfo findByName(String name) {
        return clotheInfoRepository.findByName(name);
    }

    @Override
    public void remove(ClotheInfo object) {
        photoService.remove(object.getImageId());
        clotheInfoRepository.delete(object);
    }
}
