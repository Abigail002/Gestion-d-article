package com.defitech.tp_vente.controller;

import com.defitech.tp_vente.model.Article;
import com.defitech.tp_vente.model.Constante;
import com.defitech.tp_vente.service.ArticleService;
import com.defitech.tp_vente.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ArticleContoller {
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ArticleService articleService;
    @GetMapping("/artshow")
    public String showAllArticle(Model model,Article article)
    {
        model.addAttribute("Liste_Articles",articleService.changerEtatArticle(articleService.showAllArticles()));
        //articleService.countById(articleService.showAllArticles());
        article.setNbArticle(articleService.countById(articleService.showAllArticles()));
        return "NiceAdmin/Article/Liste_Articles";
    }
    @GetMapping("/artform")
    public String showFromArticle(Model model)
    {
        model.addAttribute("Liste_Categories",categorieService.showAllCategories());
        return "NiceAdmin/Article/formArticle";
    }
    @PostMapping("/article/save")
    public String saveArticle(Article article)
    {
        article.setQteStock(0);
        article.setDateCreation(LocalDate.now());
        articleService.saveArticle(article);
        return "redirect:/artshow";
    }
    @GetMapping("/articleEdit{id}")
    public String formEditer(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("Un_article",articleService.showOneArticle(id));
        model.addAttribute("Liste_Categories",categorieService.showAllCategories());
        return "NiceAdmin/Article/formEdit";
    }
    @PostMapping("/article/update")
    public String updateArticle(@ModelAttribute("article")Article article)
    {
        articleService.saveArticle(article);
        return "redirect:/artshow";
    }
    @GetMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id)
    {
        articleService.deleteArticle(id);
        return "redirect:/artshow";
    }
    @GetMapping("/artetatSeuil")
    public String listeSeuil(Model model)
    {
        model.addAttribute("ListeSeuil",articleService.articlesEtatCritique(articleService.showAllArticles()));
        return "NiceAdmin/Article/listeSeuil";
    }
}
