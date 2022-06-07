package com.defitech.tp_vente.controller;

import com.defitech.tp_vente.model.Approvisionnement;
import com.defitech.tp_vente.model.Article;
import com.defitech.tp_vente.service.ApprovisionnementService;
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
public class ApprovsionnementController {
    @Autowired
        private ArticleService articleService;
    @Autowired
    private ApprovisionnementService approvisionnementService;
    @GetMapping("/approShow")
    public String showAllApprovisionnement(Model model)
    {
        model.addAttribute("Liste_Approvisionnements",approvisionnementService.showAllApprovisionnements());
        return "NiceAdmin/Approvisionnement/Liste_Approvisionnements";
    }
    @GetMapping("/approvisionnementform")
    public String showFromArticle(Model model)
    {
        model.addAttribute("Liste_Articles",articleService.showAllArticles());
        return "NiceAdmin/Approvisionnement/formApprovisionnement";
    }
    @PostMapping("/approvisionnementSave")
    public String saveApprovisionnement(Approvisionnement approvisionnement)
    {
        approvisionnement.setQteAppro(approvisionnement.getQteAppro());
        approvisionnement.setDateAppro(LocalDate.now());
        approvisionnementService.saveApprovisionnement(approvisionnement);
        articleService.updateStockArticle(approvisionnement.getQteAppro(), approvisionnement.getArticle_id());
        return "redirect:/approShow";
    }
    @GetMapping("/approvisionnementedit{id}")
    public String formEditer(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("Un_approvisionnement",approvisionnementService.showOneApprovisionnement(id));
        model.addAttribute("Liste_Articles",articleService.showAllArticles());
        return "NiceAdmin/Approvisionnement/formEdit";
    }
    @PostMapping("/approvisionnementUpdate")
    public String updateApprovisionnement(@ModelAttribute("approvisionnement")Approvisionnement approvisionnement)
    {
        approvisionnementService.saveApprovisionnement(approvisionnement);
        return "redirect:/approShow";
    }
    @GetMapping("/approvisionnementDelete{id}")
    public String deleteApprovisionnement(@PathVariable("id") int id)
    {
        approvisionnementService.deleteApprovisionnement(id);
        return "redirect:/approShow";
    }
}

