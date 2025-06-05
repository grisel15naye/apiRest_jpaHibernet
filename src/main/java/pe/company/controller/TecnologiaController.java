package pe.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.model.Taller;
import pe.company.model.Tecnologia;
import pe.company.service.TecnologiaService;

import java.util.Collection;

@RestController
@RequestMapping("/tecnologia")
public class TecnologiaController {
    @Autowired
    private TecnologiaService tecnologiaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        Collection<Tecnologia>itemsTecnologia=tecnologiaService.findAll();
        return new ResponseEntity<>(itemsTecnologia, HttpStatus.OK);
    }

    @GetMapping("/buscar/{tecnologiaId}")
    private ResponseEntity<?> buscar(@PathVariable Long tecnologiaId){
        Tecnologia tecnologia=tecnologiaService.findById(tecnologiaId);
        if (tecnologia!=null){
            return new ResponseEntity<>(tecnologia, HttpStatus.OK);
        }
        return new ResponseEntity<>("tecnologia no encontrado", HttpStatus.NOT_FOUND);
    }
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Tecnologia tecnologia){
        tecnologiaService.insert(tecnologia);
        return new ResponseEntity<>("Taller "+tecnologia.getNombre()+" agregado correctamente",HttpStatus.CREATED);

    }

    @PutMapping("editar/{tecnologiaId}")
    public ResponseEntity<?> editar (@PathVariable Long tecnologiaId,
                                     @RequestBody Taller taller ){
        Tecnologia tecnologiaExistente=tecnologiaService.findById(tecnologiaId);
        if (tecnologiaExistente!=null){
            tecnologiaExistente.setNombre(taller.getNombre());
            tecnologiaService.update(tecnologiaExistente);
            return new ResponseEntity<>("Tecnologia "+tecnologiaExistente.getNombre()+" actualizado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error al actualizar", HttpStatus.NOT_FOUND);

    }



}
