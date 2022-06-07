package com.defitech.tp_vente.repository;

import com.defitech.tp_vente.model.Categorie;
import com.defitech.tp_vente.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {
}
