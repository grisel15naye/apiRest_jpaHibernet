package pe.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.model.Instructor;
import pe.company.model.InstructorTecnologia;
import pe.company.model.Tecnologia;
import pe.company.service.InstructorService;
import pe.company.service.TecnologiaService;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/instructor_tecnologia")
public class InstructorTecnologiaController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private TecnologiaService tecnologiaService;

    // Listar las tecnologias de un instructor dado su ID (por PathVariable, no por Body)
    @GetMapping("/listar/{instructorId}")
    public ResponseEntity<?> listar(@PathVariable Long instructorId) {
        Instructor instructor = instructorService.findById(instructorId);
        if (instructor != null) {
            Set<Tecnologia> tecnologias = instructor.getItemsTecnologia();
            return ResponseEntity.ok(tecnologias);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor no encontrado");
    }

    // Agregar una tecnología a un instructor
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Map<String, Long> payload) {
        // Esperamos recibir JSON como: { "instructorId": 1, "tecnologiaId": 2 }

        Long instructorId = payload.get("instructorId");
        Long tecnologiaId = payload.get("tecnologiaId");

        if (instructorId == null || tecnologiaId == null) {
            return ResponseEntity.badRequest().body("Faltan instructorId o tecnologiaId");
        }

        Instructor instructor = instructorService.findById(instructorId);
        Tecnologia tecnologia = tecnologiaService.findById(tecnologiaId);

        if (instructor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor no encontrado");
        }
        if (tecnologia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tecnologia no encontrada");
        }

        // Agregar tecnología si no está ya agregada
        if (instructor.getItemsTecnologia().contains(tecnologia)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Tecnologia ya asignada al instructor");
        }

        instructor.getItemsTecnologia().add(tecnologia);
        instructorService.insert(instructor);  // o update según tu servicio

        return ResponseEntity.status(HttpStatus.CREATED).body("Tecnología agregada al instructor correctamente");
    }

    // Opcional: eliminar una tecnología de un instructor
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminar(@RequestBody Map<String, Long> payload) {
        Long instructorId = payload.get("instructorId");
        Long tecnologiaId = payload.get("tecnologiaId");

        if (instructorId == null || tecnologiaId == null) {
            return ResponseEntity.badRequest().body("Faltan instructorId o tecnologiaId");
        }

        Instructor instructor = instructorService.findById(instructorId);
        Tecnologia tecnologia = tecnologiaService.findById(tecnologiaId);

        if (instructor == null || tecnologia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor o Tecnología no encontrada");
        }

        if (!instructor.getItemsTecnologia().contains(tecnologia)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tecnología no asignada a instructor");
        }

        instructor.getItemsTecnologia().remove(tecnologia);
        instructorService.insert(instructor); // o update

        return ResponseEntity.ok("Tecnología eliminada del instructor correctamente");
    }
}
