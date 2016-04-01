package com.alina.clothe.controller.dto;

import com.alina.clothe.entity.ClotheInfo;
import com.alina.clothe.service.ClotheCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mkvitko on 4/1/16.
 */
@Component
public class DTOConverter {
    @Autowired
    private ClotheCategoryService clotheCategoryService;

    public ClotheInfo convertClotheInfoFrom(ClotheInfoDTO clotheInfoDTO) {
        ClotheInfo clotheInfo = new ClotheInfo();
        clotheInfoDTO.setId(clotheInfo.getId());
        clotheInfo.setImagePath(clotheInfoDTO.getImagePath());
        clotheInfo.setNewPrice(clotheInfoDTO.getNewPrice());
        clotheInfo.setOldPrice(clotheInfoDTO.getOldPrice());
        clotheInfo.setName(clotheInfoDTO.getName());
        clotheInfo.setUrlToVKImage(clotheInfoDTO.getUrlToVKImage());
        clotheInfo.setCategory(clotheCategoryService.find(clotheInfoDTO.getCategory()));
        return clotheInfo;
    }

    public ClotheInfoDTO convertClotheInfoTo(ClotheInfo clotheInfo) {
        ClotheInfoDTO clotheInfoDTO = new ClotheInfoDTO();
        clotheInfoDTO.setId(clotheInfo.getId());
        clotheInfo.setImagePath(clotheInfoDTO.getImagePath());
        clotheInfoDTO.setNewPrice(clotheInfo.getNewPrice());
        clotheInfoDTO.setOldPrice(clotheInfo.getOldPrice());
        clotheInfoDTO.setName(clotheInfoDTO.getName());
        clotheInfoDTO.setUrlToVKImage(clotheInfoDTO.getUrlToVKImage());
        clotheInfoDTO.setCategory(clotheInfo.getCategory().getId());
        return clotheInfoDTO;
    }
}
