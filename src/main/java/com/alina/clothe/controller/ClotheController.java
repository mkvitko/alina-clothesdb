package com.alina.clothe.controller;

import com.alina.clothe.controller.dto.ClotheInfoDTO;
import com.alina.clothe.controller.dto.DTOConverter;
import com.alina.clothe.entity.ClotheCategory;
import com.alina.clothe.entity.ClotheInfo;
import com.alina.clothe.service.ClotheCategoryService;
import com.alina.clothe.service.ClotheInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mkvitko on 3/22/16.
 */
@Controller
public class ClotheController {

    @Autowired
    private ClotheInfoService clotheInfoService;

    @Autowired
    private ClotheCategoryService clotheCategoryService;

    @Autowired
    private DTOConverter dtoConverter;

    @RequestMapping(value = "/newClothe", method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("add", "clotheInfo", new ClotheInfoDTO());
        modelAndView.addObject("categories", clotheCategoryService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/addClothe", method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("clotheInfo") ClotheInfoDTO clotheInfoDTO,
                               @RequestParam("imageFile") MultipartFile file, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }
        ClotheInfo clotheInfo = dtoConverter.convertClotheInfoFrom(clotheInfoDTO);
        model.addAttribute("name", clotheInfo.getName());
        model.addAttribute("oldPrice", clotheInfo.getOldPrice());
        model.addAttribute("newPrice", clotheInfo.getNewPrice());
        model.addAttribute("urlToVKImage", clotheInfo.getUrlToVKImage());
        if (!file.isEmpty()) {
            clotheInfo.setImagePath(clotheInfo.getCategory().getPath() + file.getOriginalFilename());
            clotheInfoService.save(clotheInfo);
            return new ModelAndView("redirect:/listClothe");
        } else {
            return new ModelAndView("add");
        }
    }

    @RequestMapping(value = "/listClothe", method = RequestMethod.GET)
    public ModelAndView showAllClothe() {
        return new ModelAndView("list", "allClothe", clotheInfoService.findAll());
    }

    @RequestMapping(value = "/edit/{clotheId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("clotheId") String clotheInfoId) {
        ClotheInfo clotheInfo = clotheInfoService.find(clotheInfoId);
        ModelAndView modelAndView = new ModelAndView("edit", "clotheInfo", dtoConverter.convertClotheInfoTo(clotheInfo));
        modelAndView.addObject("categories", clotheCategoryService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/editClothe", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("clotheInfo") ClotheInfoDTO clotheInfoDTO,
                             @RequestParam("imageFile") MultipartFile file, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }
        ClotheInfo clotheInfo = dtoConverter.convertClotheInfoFrom(clotheInfoDTO);
        if (!file.isEmpty()) {
            clotheInfo.setImagePath(clotheInfo.getCategory().getPath() + file.getOriginalFilename());
        } else {
            clotheInfo.setImagePath(clotheInfoService.find(clotheInfo.getId()).getImagePath());
        }
        clotheInfoService.save(clotheInfo);
        return new ModelAndView("redirect:/listClothe");
    }

    @RequestMapping(value = "/remove/{clothe}", method = RequestMethod.POST)
    public ModelAndView remove(@PathVariable("clothe") String clotheInfoId) {
        clotheInfoService.remove(clotheInfoService.find(clotheInfoId));
        return new ModelAndView("list", "allClothe", clotheInfoService.findAll());
    }



}
