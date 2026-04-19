package foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import foyer.entities.Foyer;
import foyer.services.IFoyerService;
import java.util.List;

@RestController
@RequestMapping("/foyer")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
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
    public Foyer findById(@PathVariable String id) {
        return foyerService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        foyerService.deleteById(id);
    }

    @PostMapping("/ajouterFoyerEtAffecterAUniversite")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,
                                                    @RequestParam String idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }

    @DeleteMapping("/desaffecterFoyerAUniversite")
    public Foyer desaffecterFoyerAUniversite(@RequestParam String idUniversite) {
        return foyerService.desaffecterFoyerAUniversite(idUniversite);
    }
}
