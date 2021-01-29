package fr.maelle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Controller
@RequestMapping(path = "/", name = "accueil")
public class AccueilController {

    @Autowired
    private SessionLocaleResolver slr;

    @GetMapping
    public ModelAndView index(String lg) {

        if (lg != null && !lg.isBlank()) {

            Locale locale = new Locale(lg);
            slr.setDefaultLocale(locale);
        }

        ModelAndView mav = new ModelAndView("index");

        mav.getModelMap().addAttribute("lg",lg);

        return mav;
    }
}
