package tn.esprit.foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Universite;
import tn.esprit.foyer.services.IUniversiteService;
import java.util.List;

@RestController
@RequestMapping("/universite")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class UniversiteRestController {

    private final IUniversiteService universiteService;

    @PostMapping("/addOrUpdate")
    public Universite addOrUpdate(@RequestBody Universite u) {
        return universiteService.addOrUpdate(u);
    }

    @GetMapping("/findAll")
    public List<Universite> findAll() {
        return universiteService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Universite findById(@PathVariable long id) {
        return universiteService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        universiteService.deleteById(id);
    }

    @PutMapping("/affecterFoyerAUniversite")
    public Universite affecterFoyerAUniversite(@RequestParam long idFoyer,
                                               @RequestParam String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecterFoyerAUniversite")
    public Universite desaffecterFoyerAUniversite(@RequestParam long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
