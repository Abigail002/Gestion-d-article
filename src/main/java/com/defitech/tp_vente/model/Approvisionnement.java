package com.defitech.tp_vente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Approvisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAppro;
    private int qteAppro;

    @ManyToOne
    @JoinColumn(name = "article_id", insertable = false, updatable = false)
    private Article article;
    private int article_id;
}
