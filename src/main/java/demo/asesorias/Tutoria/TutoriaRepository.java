package demo.asesorias.Tutoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutoriaRepository extends JpaRepository<Tutoria, Long> {
    List<Tutoria> findByEstudianteIdOrTutorId(Long estudianteId, Long tutorId);
}