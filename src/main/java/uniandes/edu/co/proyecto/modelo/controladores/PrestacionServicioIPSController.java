package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.PrestacionServicioIPS;
import uniandes.edu.co.proyecto.repositorios.PrestacionServicioIPSRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/prestaciones-servicio-ips")
public class PrestacionServicioIPSController {

    @Autowired
    private PrestacionServicioIPSRepository prestacionServicioIpsRepository;

    @GetMapping
    public Collection<PrestacionServicioIPS> getAllPrestacionesServicioIps() {
        return prestacionServicioIpsRepository.darPrestacionesServicioIps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestacionServicioIPS> getPrestacionServicioIpsById(@PathVariable Long id) {
        Optional<PrestacionServicioIPS> prestacionServicioIps = Optional.ofNullable(prestacionServicioIpsRepository.darPrestacionServicioIps(id));
        return prestacionServicioIps.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PrestacionServicioIPS> createPrestacionServicioIps(@RequestBody PrestacionServicioIPS prestacionServicioIps) {
        prestacionServicioIpsRepository.crearPrestacionServicioIps(
                prestacionServicioIps.getId(),
                prestacionServicioIps.getAfiliado().getNumDoc(),
                prestacionServicioIps.getMedico().getNumRegistro()
        );
        return ResponseEntity.ok(prestacionServicioIps);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestacionServicioIPS> updatePrestacionServicioIps(@PathVariable Long id, @RequestBody PrestacionServicioIPS prestacionServicioIps) {
        prestacionServicioIpsRepository.actualizarPrestacionServicioIps(
                id,
                prestacionServicioIps.getAfiliado().getNumDoc(),
                prestacionServicioIps.getMedico().getNumRegistro()
        );
        return ResponseEntity.ok(prestacionServicioIps);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestacionServicioIps(@PathVariable Long id) {
        prestacionServicioIpsRepository.eliminarPrestacionServicioIps(id);
        return ResponseEntity.noContent().build();
    }
}