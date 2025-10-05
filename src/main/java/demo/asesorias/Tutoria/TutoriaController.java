package demo.asesorias.Tutoria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutorias")
public class TutoriaController {

    @Autowired
    private TutoriaRepository tutoriaRepository;

    @PostMapping
    public Tutoria crearTutoria(@RequestBody TutoriaRequestDTO dto) {
        Tutoria tutoria = new Tutoria();
        tutoria.setTutorId(dto.getTutorId());
        tutoria.setEstudianteId(dto.getEstudianteId());
        tutoria.setMateriaId(dto.getMateriaId());
        tutoria.setFecha(dto.getFecha());
        tutoria.setEstado(EstadoTutoria.PENDIENTE);
        return tutoriaRepository.save(tutoria);
    }

    @GetMapping("/user/{userId}")
    public List<Tutoria> obtenerTutoriasPorUsuario(@PathVariable("userId") Long userId) {
        return tutoriaRepository.findByEstudianteIdOrTutorId(userId, userId);
    }

    @DeleteMapping("/{id}")
    public void cancelarTutoria(@PathVariable("id") Long id) {
        tutoriaRepository.deleteById(id);
    }

    @PutMapping("/{id}/estado")
    public Tutoria cambiarEstado(@PathVariable("id") Long id, @RequestBody CambiarEstadoDTO estadoDTO) {
        Tutoria tutoria = tutoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutoria no encontrada"));
        tutoria.setEstado(estadoDTO.getEstado());
        return tutoriaRepository.save(tutoria);
    }
}
