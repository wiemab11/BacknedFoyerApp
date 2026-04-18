package tn.esprit.foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.services.IFoyerService;
import java.util.List;

@RestController
@RequestMapping("/foyer")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class FoyerRestController {

    private final IFoyerService foyerService;

    @PostMapping("/addOrUpdate")
    public Foyer addOrUpdate(@RequestBody Foyer f) {
        return foyerService.addOrUpdate(f);
    }

    @GetMapping("/findAll")
    public List<Foyer> findAll() {
        return foyerService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Foyer findById(@PathVariable long id) {
        return foyerService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        foyerService.deleteById(id);
    }

    @PostMapping("/ajouterFoyerEtAffecterAUniversite")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,
                                                    @RequestParam long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
