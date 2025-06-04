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
    @PostMapping("/agregar")
    public  ResponseEntity<?>agregar (@RequestBody Conyuge conyuge){
        conyugeService.insert(conyuge);
        return new ResponseEntity<>("conyuge "+conyuge.getNombre()+" correcta mente", HttpStatus.OK);
    }

}
