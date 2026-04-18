package tn.esprit.foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.TypeChambre;
import tn.esprit.foyer.services.IChambreService;
import java.util.List;

@RestController
@RequestMapping("/chambre")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ChambreRestController {

    private final IChambreService chambreService;

    @PostMapping("/addOrUpdate")
    public Chambre addOrUpdate(@RequestBody Chambre c) { return chambreService.addOrUpdate(c); }

    @GetMapping("/findAll")
    public List<Chambre> findAll() { return chambreService.findAll(); }

    @GetMapping("/findById/{id}")
    public Chambre findById(@PathVariable long id) { return chambreService.findById(id); }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) { chambreService.deleteById(id); }

    @GetMapping("/getChambresParNomBloc")
    public List<Chambre> getChambresParNomBloc(@RequestParam String nomBloc) {
        return chambreService.getChambresParNomBloc(nomBloc);
    }

    @GetMapping("/nbChambreParTypeEtBloc")
    public long nbChambreParTypeEtBloc(@RequestParam TypeChambre type, @RequestParam long idBloc) {
        return chambreService.nbChambreParTypeEtBloc(type, idBloc);
    }

    @GetMapping("/getChambresNonReserveParNomFoyerEtTypeChambre")
    public List<Chambre> getChambresNonReserve(@RequestParam String nomFoyer,
                                               @RequestParam TypeChambre type) {
        return chambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer, type);
    }
}
