package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.Orden;
import uniandes.edu.co.proyecto.repositorios.OrdenRepository;

import java.sql.Date;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping
    public Collection<Orden> getAllOrdenes() {
        return ordenRepository.darOrdenes();
    }

    @GetMapping("/{numOrden}")
    public ResponseEntity<Orden> getOrdenByNumOrden(@PathVariable Long numOrden) {
        Optional<Orden> orden = Optional.ofNullable(ordenRepository.darOrden(numOrden));
        return orden.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Orden> createOrden(@RequestBody Orden orden) {
        ordenRepository.crearOrden(
                orden.getNumOrden(),
                new Date(orden.getFecha().getTime()),
                orden.getEstado(),
                orden.getAfiliado().getNumDoc(),
                orden.getMedico().getNumRegistro(),
                orden.getServicio().getId()
        );
        return ResponseEntity.ok(orden);
    }

    @PutMapping("/{numOrden}")
    public ResponseEntity<Orden> updateOrden(@PathVariable Long numOrden, @RequestBody Orden orden) {
        ordenRepository.actualizarOrden(
                numOrden,
                new Date(orden.getFecha().getTime()),
                orden.getEstado(),
                orden.getAfiliado().getNumDoc(),
                orden.getMedico().getNumRegistro(),
                orden.getServicio().getId()
        );
        return ResponseEntity.ok(orden);
    }

    @DeleteMapping("/{numOrden}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Long numOrden) {
        ordenRepository.eliminarOrden(numOrden);
        return ResponseEntity.noContent().build();
    }
}