package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.HorarioServicioIPS;
import uniandes.edu.co.proyecto.repositorios.HorarioServicioIPSRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/horarios-servicio-ips")
public class HorarioServicioIPSController {

    @Autowired
    private HorarioServicioIPSRepository horarioServicioIPSRepository;

    @GetMapping
    public Collection<HorarioServicioIPS> getAllHorariosServicioIPS() {
        return horarioServicioIPSRepository.darHorariosServicioIPS();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioServicioIPS> getHorarioServicioIPSById(@PathVariable Long id) {
        Optional<HorarioServicioIPS> horarioServicioIPS = Optional.ofNullable(horarioServicioIPSRepository.darHorarioServicioIPS(id));
        return horarioServicioIPS.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HorarioServicioIPS> createHorarioServicioIPS(@RequestBody HorarioServicioIPS horarioServicioIPS) {
        horarioServicioIPSRepository.crearHorarioServicioIPS(
                horarioServicioIPS.getId(),
                horarioServicioIPS.getHorario().getId(),
                horarioServicioIPS.getServicio().getId(),
                horarioServicioIPS.getIps().getNit()
        );
        return ResponseEntity.ok(horarioServicioIPS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioServicioIPS> updateHorarioServicioIPS(@PathVariable Long id, @RequestBody HorarioServicioIPS horarioServicioIPS) {
        horarioServicioIPSRepository.actualizarHorarioServicioIPS(
                id,
                horarioServicioIPS.getHorario().getId(),
                horarioServicioIPS.getServicio().getId(),
                horarioServicioIPS.getIps().getNit()
        );
        return ResponseEntity.ok(horarioServicioIPS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorarioServicioIPS(@PathVariable Long id) {
        horarioServicioIPSRepository.eliminarHorarioServicioIPS(id);
        return ResponseEntity.noContent().build();
    }
}