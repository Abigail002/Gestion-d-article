package com.defitech.tp_vente.controller;

import com.defitech.tp_vente.model.Approvisionnement;
import com.defitech.tp_vente.model.Categorie;
import com.defitech.tp_vente.model.Vente;
import com.defitech.tp_vente.service.ArticleService;
import com.defitech.tp_vente.service.CategorieService;
import com.defitech.tp_vente.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class VenteController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private VenteService venteService;
    @GetMapping("/venteShow")
    public String showAllVentes(Model model)
    {
        model.addAttribute("Liste_Ventes",venteService.showAllVentes());
        return "NiceAdmin/Vente/Liste_Ventes";
    }
    @GetMapping("/venteform")
    public String showFromVente(Model model)
    {
        model.addAttribute("Liste_Articles",articleService.showAllArticles());
        return "NiceAdmin/Vente/formvente";
    }

    @PostMapping("/vente/save")
    public String saveVente(Vente vente)
    {
        vente.setQteVente(vente.getQteVente());
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        articleService.stockApresVente(vente.getQteVente(), vente.getArticle_id());
        return "redirect:/venteShow";
    }
    @GetMapping("/venteEdit{id}")
    public String formEditer(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("Une_vente", venteService.showOneVente(id));
        model.addAttribute("Liste_Articles",articleService.showAllArticles());
        return "NiceAdmin/Vente/formEdit";
    }
    @PostMapping("/venteupdate")
    public String updateVente(@ModelAttribute("vente") Vente vente)
    {
        venteService.saveVente(vente);
        return "redirect:/venteShow";
    }
    @GetMapping("/ventedelete{id}")
    public String deleteVente(@PathVariable("id") int id)
    {
        venteService.deleteVente(id);
        return "redirect:/venteShow";
    }

}
