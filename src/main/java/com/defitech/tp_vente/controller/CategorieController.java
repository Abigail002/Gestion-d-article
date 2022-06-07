package com.defitech.tp_vente.controller;

import com.defitech.tp_vente.model.Article;
import com.defitech.tp_vente.model.Categorie;
import com.defitech.tp_vente.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/categoriesShow")
    public String showAllcategories(Model model)
    {
        model.addAttribute("Liste_Categories",categorieService.showAllCategories());
        return "NiceAdmin/Categorie/Liste_Categories";
    }
    @GetMapping("/categorieform")
    public String showFromCategorie()
    {
        return "NiceAdmin/Categorie/formCategorie";
    }
    @PostMapping("/categorie/save")
    public String saveCategorie(Categorie categorie)
    {
        categorieService.saveCategorie(categorie);
        return "redirect:/categoriesShow";
    }
    @GetMapping("/categorieEdit{id}")
    public String formEditer(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("Une_categorie",categorieService.showOneCategory(id));
        return "NiceAdmin/Categorie/formEdit";
    }
    @PostMapping("/categorie/update")
    public String updateArticle(@ModelAttribute("categorie") Categorie categorie)
    {
        categorieService.saveCategorie(categorie);
        return "redirect:/categoriesShow";
    }
    @GetMapping("/categoriedelete{id}")
    public String deleteArticle(@PathVariable("id") int id)
    {
        categorieService.deleteCategory(id);
        return "redirect:/categoriesShow";
    }
}
