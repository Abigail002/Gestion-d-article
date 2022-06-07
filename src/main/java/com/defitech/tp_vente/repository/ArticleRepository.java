package com.defitech.tp_vente.repository;

import com.defitech.tp_vente.model.Article;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>{
    @Modifying
    @Transactional
    @Query("Update Article a set a.qteStock=a.qteStock+:qte where a.id=:idArticle")
    void updateStockArticle(@Param("qte") int qte, @Param("idArticle") int idArticle);

    @Modifying
    @Transactional
    @Query("Update Article a set a.qteStock=a.qteStock-:qte where a.id=:idArticle")
    void stockApresVente(@Param("qte") int qte, @Param("idArticle") int idArticle);

    /*@Query("Count Article a ")
    int qteArticles(List <Article> list);*/
    //List <Article> findByEtat(String etat);
}
