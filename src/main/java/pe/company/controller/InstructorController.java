package pe.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.model.Conyuge;
import pe.company.model.Instructor;
import pe.company.service.InstructorService;

import java.util.Collection;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<Instructor>itemsInstructor=instructorService.findAll();
        return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
    }

    @GetMapping("/buscar/{instructorId}")
    public ResponseEntity <?> buscar(@PathVariable Long instructorId){
        Instructor instructor= instructorService.findById(instructorId);

        if (instructor!=null){
            return new ResponseEntity<>(instructor, HttpStatus.OK);
        }
        return new ResponseEntity<>("Instructor no encontrado",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?>agregar(@RequestBody Instructor instructor){
        {
            try {
                instructorService.insert(instructor);
                return new ResponseEntity<>("Instructor"+instructor.getNombre()+" "+instructor.getApellidos()+" creado correctamente", HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>("error al agregar", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


    }
    @PutMapping("/editar/{instructorId}")
    public ResponseEntity<?>editar (@PathVariable Long instructorId,
                                    @RequestBody Instructor instructor){
        Instructor instructorexistente=instructorService.findById(instructorId);
        if (instructorexistente!=null){
            instructorexistente.setNombre(instructor.getNombre());
            instructorexistente.setApellidos(instructor.getApellidos());
            instructorexistente.setPassword(instructor.getPassword());
            instructorexistente.setEmail(instructor.getEmail());

            if (instructor.getConyuge()!=null && instructorexistente.getConyuge()!=null){
                Conyuge conyugeactual=instructorexistente.getConyuge();
                Conyuge conyugenuevo=instructor.getConyuge();

                conyugeactual.setNombre(conyugenuevo.getNombre());
            }

            instructorService.update(instructorexistente);
            return new ResponseEntity<>("instructor"+instructorexistente.getNombre()+"actualizado correctamente",HttpStatus.OK);
        }
        return new ResponseEntity<>("Error al actualizar", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{instructorId}")
    public ResponseEntity<?> borrar(@PathVariable Long instructorId)
    {
        Instructor instructor =instructorService.findById(instructorId);
        if (instructor!=null)
        {
            instructorService.delete(instructorId);
            return new ResponseEntity<>("Instructo Eliminado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("no se pudo eliminar al instructor", HttpStatus.NOT_FOUND);
    }
}
