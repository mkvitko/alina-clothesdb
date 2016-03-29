package com.alina.clothe.controller;

import com.alina.clothe.service.ClotheInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mkvitko on 3/29/16.
 */
@Controller
public class AuthenticationController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) throws IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(password)
                && "alina".equals(name) && "mark".equals(password)) {
            return  new ModelAndView("redirect:" + "/listClothe");
        } else {
            request.setAttribute("errorMessage", "Bad credentials");
            return new ModelAndView("index");
        }
    }
}
