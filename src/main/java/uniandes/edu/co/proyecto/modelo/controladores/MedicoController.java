package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.Medico;
import uniandes.edu.co.proyecto.repositorios.MedicoRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public Collection<Medico> getAllMedicos() {
        return medicoRepository.darMedicos();
    }

    @GetMapping("/{numRegistro}")
    public ResponseEntity<Medico> getMedicoByNumRegistro(@PathVariable Long numRegistro) {
        Optional<Medico> medico = Optional.ofNullable(medicoRepository.darMedico(numRegistro));
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody Medico medico) {
        medicoRepository.crearMedico(
                medico.getTipoDoc(),
                medico.getNumDoc(),
                medico.getNombre(),
                medico.getEspecialidad(),
                medico.getNumRegistro()
        );
        return ResponseEntity.ok(medico);
    }

    @PutMapping("/{numRegistro}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long numRegistro, @RequestBody Medico medico) {
        medicoRepository.actualizarMedico(
                medico.getTipoDoc(),
                medico.getNumDoc(),
                medico.getNombre(),
                medico.getEspecialidad(),
                numRegistro
        );
        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{numRegistro}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long numRegistro) {
        medicoRepository.eliminarMedico(numRegistro);
        return ResponseEntity.noContent().build();
    }
}