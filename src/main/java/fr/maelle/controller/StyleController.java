package fr.maelle.controller;

import fr.maelle.bean.Style;
import fr.maelle.service.GestionStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/styles")
public class StyleController {

    @Autowired
    private GestionStyle gestionStyle;

    @GetMapping
    public ModelAndView index() {

        List<Style> styles = gestionStyle.findAll();
        Style style = new Style();

        ModelAndView mav = new ModelAndView("style/index", "styles", styles);

        //Formulaire de création du style
        mav.getModelMap().addAttribute("style", style);

        return mav;
    }

    @PostMapping(value = "/addStyle", name = "addStyle")
    public ModelAndView addStyle(@Valid @ModelAttribute("style") Style style) {

        try {
            gestionStyle.add(style);
        } catch (Exception e) {
            System.out.println("ERREUR lors de la suppression du style : " + style.getLibelle());
        }
        return index();
    }

    @PostMapping(value = "/editStyle")
    public ModelAndView put(Style style) {

        if (gestionStyle.findById(style.getId()).isPresent()) {

            gestionStyle.update(style);

        } else {

            System.out.println("ERREUR lors de la maj du style : " + style.getId());
        }

        return index();
    }

    @GetMapping(path = "/delete")
    public ModelAndView delete(int id) {

        if (gestionStyle.findById(id).isPresent()) {

            try {

                gestionStyle.delete(id);

            } catch (Exception e) {
                System.out.println("ERREUR lors de la suppression du style : " + id);
            }

        } else {

            System.out.println("ERREUR ID n'existe pas : " + id);
        }

        return index();
    }
}