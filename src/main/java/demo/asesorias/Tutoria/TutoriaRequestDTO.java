package demo.asesorias.Tutoria;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TutoriaRequestDTO {
    private Long tutorId;
    private Long estudianteId;
    private Long materiaId;
    private LocalDateTime fecha;
}