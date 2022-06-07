package com.defitech.tp_vente.service;

import com.defitech.tp_vente.model.Article;
import com.defitech.tp_vente.model.Constante;
import com.defitech.tp_vente.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public void saveArticle(Article article)
    {
        articleRepository.save(article);
    }

    public List<Article> showAllArticles()
    {
        return articleRepository.findAll();
    }

    public Article showOneArticle(int id)
    {
        return articleRepository.findById(id).get();
    }

    public void deleteArticle(int id)
    {
        articleRepository.deleteById(id);
    }
    public void updateStockArticle(int qte, int id)
    {
        articleRepository.updateStockArticle(qte,id);
    }
    public List changerEtatArticle(List<Article> liste)
    {
        for(Article a:liste)
        {
            if(a.getQteSeuil()>a.getQteStock())
            {
                a.setEtat(Constante.ETAT_CRITIQUE);
            }
            else
            {
                a.setEtat(Constante.ETAT_NORMAL);
            }
        }
        return liste;
    }
    public List articlesEtatCritique(List<Article> liste)
    {
        List<Article> listSeuil = new ArrayList<>();
        for(Article a:liste)
        {
            if(a.getQteSeuil()>a.getQteStock())
            {
                listSeuil.add(a);
            }
        }
        return listSeuil;
    }
    public void stockApresVente(int qte, int id){articleRepository.stockApresVente(qte, id);}
    public long countById(List <Article> list)
    {
        long nbre=0;
        Article article = new Article();
        article.setNbArticle(0);
        for(Article a:list)
        {
            if(a.getId()!=0)
            {
                nbre +=1;
            }
        }
        return nbre;
    }
}
