package com.defitech.tp_vente.service;

import com.defitech.tp_vente.model.Categorie;
import com.defitech.tp_vente.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    public void saveCategorie(Categorie categorie)
    {
        categorieRepository.save(categorie);
    }

    public List<Categorie> showAllCategories()
    {
        return categorieRepository.findAll();
    }

    public Categorie showOneCategory(int id)
    {
        return categorieRepository.findById(id).get();
    }

    public void deleteCategory(int id)
    {
        categorieRepository.deleteById(id);
    }
}