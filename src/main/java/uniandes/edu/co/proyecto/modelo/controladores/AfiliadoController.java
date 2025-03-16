package uniandes.edu.co.proyecto.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.entidades.Afiliado;
import uniandes.edu.co.proyecto.repositorios.AfiliadoRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @GetMapping
    public Collection<Afiliado> getAllAfiliados() {
        return afiliadoRepository.darAfiliados();
    }

    @GetMapping("/{numDoc}")
    public ResponseEntity<Afiliado> getAfiliadoById(@PathVariable Long numDoc) {
        Optional<Afiliado> afiliado = Optional.ofNullable(afiliadoRepository.darAfiliado(numDoc));
        return afiliado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Afiliado> createAfiliado(@RequestBody Afiliado afiliado) {
        afiliadoRepository.crearAfiliado(
                afiliado.getNumDoc(),
                afiliado.getTipoDoc().name(),
                afiliado.getNombre(),
                new java.sql.Date(afiliado.getFechaNacimiento().getTime()),
                afiliado.getDireccion(),
                afiliado.getTelefono(),
                afiliado.getClass().getSimpleName().toLowerCase(),
                afiliado.getEps().getNit()
        );
        return ResponseEntity.ok(afiliado);
    }

    @PutMapping("/{numDoc}")
    public ResponseEntity<Afiliado> updateAfiliado(@PathVariable Long numDoc, @RequestBody Afiliado afiliado) {
        afiliadoRepository.actualizarAfiliado(
                numDoc,
                afiliado.getTipoDoc().name(),
                afiliado.getNombre(),
                new java.sql.Date(afiliado.getFechaNacimiento().getTime()),
                afiliado.getDireccion(),
                afiliado.getTelefono(),
                afiliado.getClass().getSimpleName().toLowerCase(),
                afiliado.getEps().getNit()
        );
        return ResponseEntity.ok(afiliado);
    }

    @DeleteMapping("/{numDoc}")
    public ResponseEntity<Void> deleteAfiliado(@PathVariable Long numDoc) {
        afiliadoRepository.eliminarAfiliado(numDoc);
        return ResponseEntity.noContent().build();
    }
}