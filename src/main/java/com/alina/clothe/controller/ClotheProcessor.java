package com.alina.clothe.controller;

import com.alina.clothe.entity.ClotheInfo;
import com.alina.clothe.service.ClotheInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;

/**
 * Created by mkvitko on 3/22/16.
 */
@Controller
public class ClotheProcessor {

    @Autowired
    private ClotheInfoService clotheInfoService;

    @Value("${images.dir}")
    private String imagesDir;

    @RequestMapping(value = "/newClothe", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("add", "clotheInfo", new ClotheInfo());
    }

    @RequestMapping(value = "/addClothe", method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("clotheInfo") ClotheInfo clotheInfo,
                               @RequestParam("imageFile") MultipartFile file, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }
        model.addAttribute("name", clotheInfo.getName());
        model.addAttribute("oldPrice", clotheInfo.getOldPrice());
        model.addAttribute("newPrice", clotheInfo.getNewPrice());
        model.addAttribute("urlToVKImage", clotheInfo.getUrlToVKImage());
        if (!file.isEmpty()) {
            clotheInfo.setImagePath(imagesDir + file.getOriginalFilename());
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

}
