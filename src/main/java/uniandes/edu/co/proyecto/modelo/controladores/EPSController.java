package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.EPS;
import uniandes.edu.co.proyecto.repositorios.EPSRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/eps")
public class EPSController {

    @Autowired
    private EPSRepository epsRepository;

    @GetMapping
    public Collection<EPS> getAllEPS() {
        return epsRepository.darEPS();
    }

    @GetMapping("/{nit}")
    public ResponseEntity<EPS> getEPSByNit(@PathVariable Long nit) {
        Optional<EPS> eps = Optional.ofNullable(epsRepository.darEPSPorNit(nit));
        return eps.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EPS> createEPS(@RequestBody EPS eps) {
        epsRepository.crearEPS(
                eps.getNit(),
                eps.getNombre()
        );
        return ResponseEntity.ok(eps);
    }

    @PutMapping("/{nit}")
    public ResponseEntity<EPS> updateEPS(@PathVariable Long nit, @RequestBody EPS eps) {
        epsRepository.actualizarEPS(
                nit,
                eps.getNombre()
        );
        return ResponseEntity.ok(eps);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Void> deleteEPS(@PathVariable Long nit) {
        epsRepository.eliminarEPS(nit);
        return ResponseEntity.noContent().build();
    }
}