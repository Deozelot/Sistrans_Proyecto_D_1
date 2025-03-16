package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.Horario;
import uniandes.edu.co.proyecto.repositorios.HorarioRepository;

import java.sql.Time;
import java.sql.Date;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioRepository horarioRepository;

    @GetMapping
    public Collection<Horario> getAllHorarios() {
        return horarioRepository.darHorarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable Long id) {
        Optional<Horario> horario = Optional.ofNullable(horarioRepository.darHorario(id));
        return horario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Horario> createHorario(@RequestBody Horario horario) {
        horarioRepository.crearHorario(
                horario.getId(),
                new Date(horario.getDia().getTime()),
                new Time(horario.getHoraInicio().getTime()),
                new Time(horario.getHoraFin().getTime())
        );
        return ResponseEntity.ok(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> updateHorario(@PathVariable Long id, @RequestBody Horario horario) {
        horarioRepository.actualizarHorario(
                id,
                new Date(horario.getDia().getTime()),
                new Time(horario.getHoraInicio().getTime()),
                new Time(horario.getHoraFin().getTime())
        );
        return ResponseEntity.ok(horario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id) {
        horarioRepository.eliminarHorario(id);
        return ResponseEntity.noContent().build();
    }
}