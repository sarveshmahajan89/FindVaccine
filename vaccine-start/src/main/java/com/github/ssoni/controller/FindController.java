package com.github.ssoni.controller;

import com.github.ssoni.model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FindController {

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String showAddPage(ModelMap model) {
        model.addAttribute("userData", new UserData());
        return "find";
    }
}
