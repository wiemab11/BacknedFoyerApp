package foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import foyer.entities.Etudiant;
import foyer.services.IEtudiantService;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
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
    public Etudiant findById(@PathVariable String id) {
        return etudiantService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        etudiantService.deleteById(id);
    }
}