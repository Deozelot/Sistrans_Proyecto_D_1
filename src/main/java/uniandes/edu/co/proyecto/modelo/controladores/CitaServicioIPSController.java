package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.CitaServicioIPS;
import uniandes.edu.co.proyecto.repositorios.CitaServicioIPSRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/citas-servicio-ips")
public class CitaServicioIPSController {

    @Autowired
    private CitaServicioIPSRepository citaServicioIPSRepository;

    @GetMapping
    public Collection<CitaServicioIPS> getAllCitasServicioIPS() {
        return citaServicioIPSRepository.darCitasServicioIPS();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaServicioIPS> getCitaServicioIPSById(@PathVariable Long id) {
        Optional<CitaServicioIPS> citaServicioIPS = Optional.ofNullable(citaServicioIPSRepository.darCitaServicioIPS(id));
        return citaServicioIPS.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CitaServicioIPS> createCitaServicioIPS(@RequestBody CitaServicioIPS citaServicioIPS) {
        citaServicioIPSRepository.crearCitaServicioIPS(
                citaServicioIPS.getId(),
                citaServicioIPS.getAfiliado().getNumDoc(),
                citaServicioIPS.getOrden().getNumOrden()
        );
        return ResponseEntity.ok(citaServicioIPS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaServicioIPS> updateCitaServicioIPS(@PathVariable Long id, @RequestBody CitaServicioIPS citaServicioIPS) {
        citaServicioIPSRepository.actualizarCitaServicioIPS(
                id,
                citaServicioIPS.getAfiliado().getNumDoc(),
                citaServicioIPS.getOrden().getNumOrden()
        );
        return ResponseEntity.ok(citaServicioIPS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitaServicioIPS(@PathVariable Long id) {
        citaServicioIPSRepository.eliminarCitaServicioIPS(id);
        return ResponseEntity.noContent().build();
    }
}