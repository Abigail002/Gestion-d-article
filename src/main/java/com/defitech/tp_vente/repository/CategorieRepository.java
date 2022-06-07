package com.defitech.tp_vente.repository;

import com.defitech.tp_vente.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}
