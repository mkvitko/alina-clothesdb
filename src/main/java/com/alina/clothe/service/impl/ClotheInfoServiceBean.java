package com.alina.clothe.service.impl;

import com.alina.clothe.dao.ClotheInfoRepository;
import com.alina.clothe.entity.ClotheInfo;
import com.alina.clothe.service.ClotheInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mkvitko on 3/22/16.
 */
@Service
public class ClotheInfoServiceBean implements ClotheInfoService {

    @Autowired
    private ClotheInfoRepository clotheInfoRepository;

    @Override
    public void save(ClotheInfo object) {
        clotheInfoRepository.save(object);
    }

    @Override
    public List<ClotheInfo> findAll() {
        return clotheInfoRepository.findAll();
    }

    @Override
    public ClotheInfo find(String id) {
        return clotheInfoRepository.findOne(id);
    }
}
