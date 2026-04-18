package tn.esprit.foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.services.IBlocService;
import java.util.List;

@RestController
@RequestMapping("/bloc")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class BlocRestController {

    private final IBlocService blocService;

    // ---- CRUD ----
    @PostMapping("/addOrUpdate")
    public Bloc addOrUpdate(@RequestBody Bloc b) {
        return blocService.addOrUpdate(b);
    }

    @GetMapping("/findAll")
    public List<Bloc> findAll() {
        return blocService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Bloc findById(@PathVariable long id) {
        return blocService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        blocService.deleteById(id);
    }

    // ---- Service 03 ----
    @PutMapping("/affecterChambresABloc")
    public Bloc affecterChambresABloc(@RequestParam String nomBloc,
                                      @RequestBody List<Long> numChambres) {
        return blocService.affecterChambresABloc(numChambres, nomBloc);
    }

    // ---- Service 04 ----
    @PutMapping("/affecterBlocAFoyer")
    public Bloc affecterBlocAFoyer(@RequestParam String nomBloc,
                                   @RequestParam String nomFoyer) {
        return blocService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }
}
