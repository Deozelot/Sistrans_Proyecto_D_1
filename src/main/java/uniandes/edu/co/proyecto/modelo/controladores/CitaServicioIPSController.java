package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.CitaServicioIPS;
import uniandes.edu.co.proyecto.repositorios.CitaServicioIPSRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas-servicio-ips")
public class CitaServicioIPSController {

    @Autowired
    private CitaServicioIPSRepository citaServicioIPSRepository;

    @GetMapping
    public List<CitaServicioIPS> getAllCitasServicioIPS() {
        return citaServicioIPSRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaServicioIPS> getCitaServicioIPSById(@PathVariable Long id) {
        Optional<CitaServicioIPS> citaServicioIPS = citaServicioIPSRepository.findById(id);
        return citaServicioIPS.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CitaServicioIPS createCitaServicioIPS(@RequestBody CitaServicioIPS citaServicioIPS) {
        return citaServicioIPSRepository.save(citaServicioIPS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaServicioIPS> updateCitaServicioIPS(@PathVariable Long id, @RequestBody CitaServicioIPS citaServicioIPSDetails) {
        Optional<CitaServicioIPS> citaServicioIPS = citaServicioIPSRepository.findById(id);
        if (citaServicioIPS.isPresent()) {
            CitaServicioIPS updatedCitaServicioIPS = citaServicioIPS.get();
            updatedCitaServicioIPS.setHorario(citaServicioIPSDetails.getHorario());
            updatedCitaServicioIPS.setAfiliado(citaServicioIPSDetails.getAfiliado());
            updatedCitaServicioIPS.setServicio(citaServicioIPSDetails.getServicio());
            citaServicioIPSRepository.save(updatedCitaServicioIPS);
            return ResponseEntity.ok(updatedCitaServicioIPS);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitaServicioIPS(@PathVariable Long id) {
        Optional<CitaServicioIPS> citaServicioIPS = citaServicioIPSRepository.findById(id);
        if (citaServicioIPS.isPresent()) {
            citaServicioIPSRepository.delete(citaServicioIPS.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}