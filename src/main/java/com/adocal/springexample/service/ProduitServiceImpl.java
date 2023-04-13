package com.adocal.springexample.service;

import com.adocal.springexample.models.Produit;
import com.adocal.springexample.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    @Override
    public Produit create(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> read() {
        return produitRepository.findAll();
    }

    @Override
    public Produit edit(Long id, Produit produit) {
        return produitRepository.findById(id)
                .map(p->{
                    p.setPrix(produit.getPrix());
                    p.setNom(produit.getNom());
                    p.setDescription(produit.getDescription());
                    return  produitRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Produit non trouvé!! "));
    }

    @Override
    public String delete(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimé!";
    }
}
