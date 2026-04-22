package foyer.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import foyer.entities.Bloc;
import foyer.services.IBlocService;
import java.util.List;


@RestController
@RequestMapping("/bloc")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
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
    public Bloc findById(@PathVariable String id) {
        return blocService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        blocService.deleteById(id);
    }

    // ---- Service 03 ----
    @PutMapping("/affecterChambresABloc")
    public Bloc affecterChambresABloc(@RequestParam String nomBloc,
                                      @RequestBody List<Long> numChambres) {
        List<String> numChambresStr = numChambres.stream().map(String::valueOf).toList();
        return blocService.affecterChambresABloc(numChambresStr, nomBloc);
    }

    // ---- Service 04 ----
    @PutMapping("/affecterBlocAFoyer")
    public Bloc affecterBlocAFoyer(@RequestParam String nomBloc,
                                   @RequestParam String nomFoyer) {
        return blocService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }
}
