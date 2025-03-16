package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.Servicio;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping
    public Collection<Servicio> getAllServicios() {
        return servicioRepository.darServicios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable Long id) {
        Optional<Servicio> servicio = Optional.ofNullable(servicioRepository.darServicio(id));
        return servicio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Servicio> createServicio(@RequestBody Servicio servicio) {
        servicioRepository.crearServicio(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getTipo(),
                servicio.getEps().getNit()
        );
        return ResponseEntity.ok(servicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable Long id, @RequestBody Servicio servicio) {
        servicioRepository.actualizarServicio(
                id,
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getTipo()
        );
        return ResponseEntity.ok(servicio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Long id) {
        servicioRepository.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }
}