package com.alina.clothe.controller;

import com.alina.clothe.entity.ClotheInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by mkvitko on 3/22/16.
 */
@Controller
public class ClotheProcessor {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("add", "clotheInfo", new ClotheInfo());
    }

    @RequestMapping(value = "/addClothe", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("clotheInfo")ClotheInfo clotheInfo,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", clotheInfo.getName());
        model.addAttribute("oldPrice", clotheInfo.getOldPrice());
        model.addAttribute("newPrice", clotheInfo.getNewPrice());
        model.addAttribute("id", clotheInfo.getId());
        return "index";
    }

}
