package tn.esprit.foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.services.IEtudiantService;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EtudiantRestController {

    private final IEtudiantService etudiantService;

    @PostMapping("/addOrUpdate")
    public Etudiant addOrUpdate(@RequestBody Etudiant e) {
        return etudiantService.addOrUpdate(e);
    }

    @GetMapping("/findAll")
    public List<Etudiant> findAll() {
        return etudiantService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Etudiant findById(@PathVariable long id) {
        return etudiantService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        etudiantService.deleteById(id);
    }
}
