package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.IPS;
import uniandes.edu.co.proyecto.repositorios.IPSRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/ips")
public class IPSController {

    @Autowired
    private IPSRepository ipsRepository;

    @GetMapping
    public Collection<IPS> getAllIPS() {
        return ipsRepository.darIPS();
    }

    @GetMapping("/{nit}")
    public ResponseEntity<IPS> getIPSByNit(@PathVariable Long nit) {
        Optional<IPS> ips = Optional.ofNullable(ipsRepository.darIPSPorId(nit));
        return ips.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<IPS> createIPS(@RequestBody IPS ips) {
        ipsRepository.crearIPS(
                ips.getNit(),
                ips.getNombre(),
                ips.getDireccion(),
                ips.getTelefono()
        );
        return ResponseEntity.ok(ips);
    }

    @PutMapping("/{nit}")
    public ResponseEntity<IPS> updateIPS(@PathVariable Long nit, @RequestBody IPS ips) {
        ipsRepository.actualizarIPS(
                nit,
                ips.getNombre(),
                ips.getDireccion(),
                ips.getTelefono()
        );
        return ResponseEntity.ok(ips);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Void> deleteIPS(@PathVariable Long nit) {
        ipsRepository.eliminarIPS(nit);
        return ResponseEntity.noContent().build();
    }
}