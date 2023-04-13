package com.adocal.springexample.controller;

import com.adocal.springexample.models.Produit;
import com.adocal.springexample.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @PostMapping("/create")
    public  Produit create(@RequestBody Produit produit){
        return produitService.create(produit);
    }

    @GetMapping("/read")
    public List<Produit> read(){
        return produitService.read();
    }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable Long id,@RequestBody Produit produit){
        return produitService.edit(id, produit);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return produitService.delete(id);
    }
}
