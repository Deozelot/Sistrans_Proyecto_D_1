package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.Beneficiario;
import uniandes.edu.co.proyecto.repositorios.BeneficiarioRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @GetMapping
    public Collection<Beneficiario> getAllBeneficiarios() {
        return beneficiarioRepository.darBeneficiarios();
    }

    @GetMapping("/{numDoc}")
    public ResponseEntity<Beneficiario> getBeneficiarioById(@PathVariable Long numDoc) {
        Optional<Beneficiario> beneficiario = Optional.ofNullable(beneficiarioRepository.darBeneficiario(numDoc));
        return beneficiario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Beneficiario> createBeneficiario(@RequestBody Beneficiario beneficiario) {
        beneficiarioRepository.crearBeneficiario(
                beneficiario.getNumDoc(),
                beneficiario.getParentesco().name(),
                beneficiario.getContribuyente().getNumDoc()
        );
        return ResponseEntity.ok(beneficiario);
    }

    @PutMapping("/{numDoc}")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long numDoc, @RequestBody Beneficiario beneficiario) {
        beneficiarioRepository.actualizarBeneficiario(
                numDoc,
                beneficiario.getParentesco().name(),
                beneficiario.getContribuyente().getNumDoc()
        );
        return ResponseEntity.ok(beneficiario);
    }

    @DeleteMapping("/{numDoc}")
    public ResponseEntity<Void> deleteBeneficiario(@PathVariable Long numDoc) {
        beneficiarioRepository.eliminarBeneficiario(numDoc);
        return ResponseEntity.noContent().build();
    }
}