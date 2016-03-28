package com.alina.clothe.service;

import com.alina.clothe.entity.ClotheInfo;

/**
 * Created by mkvitko on 3/22/16.
 */
public interface ClotheInfoService extends CRUDService<ClotheInfo, String> {
    ClotheInfo findByName(String name);
}
