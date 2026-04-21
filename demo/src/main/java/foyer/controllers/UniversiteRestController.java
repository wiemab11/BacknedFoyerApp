package foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import foyer.entities.Universite;
import foyer.services.IUniversiteService;
import java.util.List;

@RestController
@RequestMapping("/universite")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"})
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
    public Universite findById(@PathVariable String id) {
        return universiteService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        universiteService.deleteById(id);
    }

    @PutMapping("/affecterFoyerAUniversite")
    public Universite affecterFoyerAUniversite(@RequestParam String idFoyer,
                                               @RequestParam String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecterFoyerAUniversite")
    public Universite desaffecterFoyerAUniversite(@RequestParam String idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
