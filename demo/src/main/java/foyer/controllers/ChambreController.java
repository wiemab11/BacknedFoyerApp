package foyer.controllers;

import foyer.entities.Chambre;
import foyer.entities.TypeChambre;
import foyer.services.IChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambre")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class ChambreController {

    private final IChambreService chambreService;

    @GetMapping("/findAll")
    public List<Chambre> findAll() {
        return chambreService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Chambre findById(@PathVariable String id) {
        return chambreService.findById(id);
    }

    @PostMapping("/addOrUpdate")
    public Chambre addOrUpdate(@RequestBody Chambre chambre) {
        return chambreService.addOrUpdate(chambre);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        chambreService.deleteById(id);
    }

    // Add other endpoints as needed
}