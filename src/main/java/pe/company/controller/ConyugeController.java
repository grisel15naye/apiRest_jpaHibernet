package pe.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.model.Conyuge;
import pe.company.service.ConyugeService;

import java.util.Collection;

@RestController
@RequestMapping("/conyuge")
public class ConyugeController {
    @Autowired
    private ConyugeService conyugeService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        Collection<Conyuge> itemsConyuge=conyugeService.findAll();
        return new ResponseEntity<>(itemsConyuge, HttpStatus.OK);
    }


    @GetMapping("/buscar/{conyugeDni}")
    private ResponseEntity<?> buscar (@PathVariable Long conyugeDni){
        Conyuge conyuge= conyugeService.findById(conyugeDni);
        if (conyuge!=null){
            return new ResponseEntity<>(conyuge, HttpStatus.OK);
        }
        return new ResponseEntity<>("instructor no encotrado", HttpStatus.NOT_FOUND);
    }


    @PostMapping("/agregar")
    public  ResponseEntity<?>agregar (@RequestBody Conyuge conyuge){
        try {
            conyugeService.insert(conyuge);
            return new ResponseEntity<>("conyuge "+conyuge.getNombre()+" agregado correctamente", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("error al agregar intente de nuevo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/editar/{conyugeDni}")
    public ResponseEntity<?>editar (@PathVariable Long conyugeDni,
                                    @RequestBody Conyuge conyuge){
        Conyuge conyugeexistente=conyugeService.findById(conyugeDni);
        if (conyugeexistente!=null){
            conyugeexistente.setNombre(conyuge.getNombre());
            conyugeService.update(conyugeexistente);
            return new ResponseEntity<>("Conyuge "+conyugeexistente.getNombre()+" actualizado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error al actualizar", HttpStatus.NOT_FOUND);

    }

}
