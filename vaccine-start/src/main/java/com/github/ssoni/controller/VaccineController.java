package com.github.ssoni.controller;

import com.github.ssoni.model.UserData;
import com.github.ssoni.repository.CommonDataRepo;
import com.github.ssoni.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("footer")
public class VaccineController {

    @Autowired
    VaccineService service;

    @Autowired
    CommonDataRepo commonDataRepo;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/addDetail", method = RequestMethod.GET)
    public String showAddPage(ModelMap model) {
        model.addAttribute("userData", new UserData());
        this.updateCounter();
        return "addDetail";
    }


    private void updateCounter() {
        try {
            WelcomeController.totalAdded++;
            commonDataRepo.updateCommonData(WelcomeController.totalVisits,WelcomeController.totalAdded);
        }catch (Exception e){

        }
    }

    @RequestMapping(value = "/thanks", method = RequestMethod.GET)
    public String showThanksPage(ModelMap model) {
        return "thanks";
    }


    @RequestMapping(value = "/addDetail", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid UserData userData, BindingResult result) {

        if (result.hasErrors()) {
            return "addDetail";
        }

        service.saveDetails(userData);

        return "redirect:/thanks";
    }
}
