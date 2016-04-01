package com.alina.clothe.controller;

import com.alina.clothe.entity.ClotheCategory;
import com.alina.clothe.entity.ClotheInfo;
import com.alina.clothe.service.ClotheCategoryService;
import com.alina.clothe.service.ClotheInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;

/**
 * Created by mkvitko on 4/1/16.
 */
@Controller
public class CategoryController {
    @Autowired
    private ClotheCategoryService clotheCategoryService;

    @RequestMapping(value = "/newCategory", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("add-category", "clotheCategory", new ClotheCategory());
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("clotheCategory") ClotheCategory clotheCategory,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }
        model.addAttribute("name", clotheCategory.getName());
        model.addAttribute("path", clotheCategory.getPath());
        if (!StringUtils.isEmpty(clotheCategory.getName()) && !StringUtils.isEmpty(clotheCategory.getPath())) {
            if (!clotheCategory.getPath().endsWith(File.separator)) {
                clotheCategory.setPath(clotheCategory.getPath() + File.separator);
            }
            clotheCategoryService.save(clotheCategory);
            return new ModelAndView("redirect:/categories");
        } else {
            return new ModelAndView("add-category");
        }
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView showAllClothe() {
        return new ModelAndView("list-categories", "allCategories", clotheCategoryService.findAll());
    }

    @RequestMapping(value = "/editCategory/{categoryId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("categoryId") String categoryId) {
        return new ModelAndView("edit", "clotheCategory", clotheCategoryService.find(categoryId));
    }

    @RequestMapping(value = "/editedCategory", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("clotheCategory") ClotheCategory clotheCategory,
                             BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }
        if (!StringUtils.isEmpty(clotheCategory.getName()) && !StringUtils.isEmpty(clotheCategory.getPath())) {
            if (!clotheCategory.getPath().endsWith(File.separator)) {
                clotheCategory.setPath(clotheCategory.getPath() + File.separator);
            }
            clotheCategoryService.save(clotheCategory);
            return new ModelAndView("redirect:/categories");
        } else {
            return new ModelAndView("add-category");
        }
    }

    @RequestMapping(value = "/removeCategory/{categoryId}", method = RequestMethod.POST)
    public ModelAndView remove(@PathVariable("categoryId") String categoryId) {
        clotheCategoryService.remove(clotheCategoryService.find(categoryId));
        return new ModelAndView("list-categories", "allCategories", clotheCategoryService.findAll());
    }

}
