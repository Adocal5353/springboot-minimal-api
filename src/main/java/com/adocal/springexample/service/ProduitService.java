package com.adocal.springexample.service;

import com.adocal.springexample.models.Produit;

import java.util.List;

public interface ProduitService {

    Produit create(Produit produit);

    List<Produit> read();

    Produit edit(Long id,Produit produit);
    String delete(Long id);
}
