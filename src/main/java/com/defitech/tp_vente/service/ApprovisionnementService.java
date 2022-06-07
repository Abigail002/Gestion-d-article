package com.defitech.tp_vente.service;

import com.defitech.tp_vente.model.Approvisionnement;
import com.defitech.tp_vente.model.Vente;
import com.defitech.tp_vente.repository.ApprovisionnementRepository;
import com.defitech.tp_vente.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {
    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;
    public void saveApprovisionnement(Approvisionnement approvisionnement)
    {
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> showAllApprovisionnements()
    {
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement showOneApprovisionnement(int id)
    {
        return approvisionnementRepository.findById(id).get();
    }

    public void deleteApprovisionnement(int id)
    {
        approvisionnementRepository.deleteById(id);
    }

}
