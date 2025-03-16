package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.IPS;
import uniandes.edu.co.proyecto.modelo.entidades.Servicio;
import uniandes.edu.co.proyecto.repositorios.IPSRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ips")
public class IPSController {

    @Autowired
    private IPSRepository ipsRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping
    public Collection<IPS> getAllIPS() {
        return ipsRepository.darIPS();
    }

    @GetMapping("/{nit}")
    public ResponseEntity<IPS> getIPSByNit(@PathVariable Long nit) {
        Optional<IPS> ips = Optional.ofNullable(ipsRepository.darIPSPorNit(nit));
        return ips.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<IPS> createIPS(@RequestBody IPS ips) {
        ipsRepository.crearIPS(
                ips.getNit(),
                ips.getNombre(),
                ips.getDireccion(),
                ips.getTelefono(),
                ips.getEps().getNit()
        );
        return ResponseEntity.ok(ips);
    }

    @PutMapping("/{nit}")
    public ResponseEntity<IPS> updateIPS(@PathVariable Long nit, @RequestBody IPS ips) {
        ipsRepository.actualizarIPS(
                nit,
                ips.getNombre(),
                ips.getDireccion(),
                ips.getTelefono(),
                ips.getEps().getNit()
        );
        return ResponseEntity.ok(ips);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Void> deleteIPS(@PathVariable Long nit) {
        ipsRepository.eliminarIPS(nit);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{ipsNit}/{servicioId}")
    public ResponseEntity<IPS> assignServicesToIPS(@PathVariable Long ipsNit, @PathVariable Long servicioId) {
        IPS ipsExistente = ipsRepository.darIPSPorNit(ipsNit);
        if (ipsExistente == null) {
            return ResponseEntity.notFound().build();
        }
        Servicio servicioExistente = servicioRepository.darServicio(ipsNit);
        if (servicioExistente == null) {
            return ResponseEntity.notFound().build();
        }

        List<Servicio> servicios =  ipsExistente.getServicios();
        servicios.add(servicioExistente);
        ipsExistente.setServicios(servicios);

        List<IPS> ipss = servicioExistente.getIpss();
        ipss.add(ipsExistente);
        servicioExistente.setIpss(ipss);

        ipsRepository.save(ipsExistente);
        servicioRepository.save(servicioExistente);
        return ResponseEntity.ok(ipsExistente);
    }

}