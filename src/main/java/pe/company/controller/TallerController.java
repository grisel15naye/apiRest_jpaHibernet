package pe.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.model.Taller;
import pe.company.service.TallerService;

import java.util.Collection;

@RestController
@RequestMapping("/taller")
public class TallerController {
    @Autowired
    private TallerService tallerService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar (){
        Collection<Taller> itemsTaller=tallerService.finAll();
        return new ResponseEntity<>(itemsTaller, HttpStatus.OK);
    }

    @GetMapping("/buscar/{tallerId}")
    public ResponseEntity<?>buscar(@PathVariable Long tallerId){
        Taller taller =tallerService.findById(tallerId);

        if (taller!=null){
            return new ResponseEntity<>(taller, HttpStatus.OK);
        }
        return new ResponseEntity<>("instructor no encontrado", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar (@RequestBody Taller taller){
        tallerService.insert(taller);
        return new ResponseEntity<>("Taller "+taller.getNombre()+" agregado correctamente",HttpStatus.CREATED);

    }

    @PutMapping("editar/{tallerId}")
    public ResponseEntity<?> editar (@PathVariable Long tallerId,
                                     @RequestBody Taller taller ){
        Taller tallerExistente=tallerService.findById(tallerId);
        if (tallerExistente!=null){
            tallerExistente.setNombre(taller.getNombre());
            tallerExistente.setCosto(taller.getCosto());
            tallerService.update(tallerExistente);
            return new ResponseEntity<>("Taller "+tallerExistente.getNombre()+" actualizado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error al actualizar", HttpStatus.NOT_FOUND);

    }
}
