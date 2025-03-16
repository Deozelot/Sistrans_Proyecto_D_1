package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.Beneficiario;

import java.util.Collection;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    @Query(value = "SELECT * FROM beneficiarios", nativeQuery = true)
    Collection<Beneficiario> darBeneficiarios();

    @Query(value = "SELECT * FROM beneficiarios WHERE num_doc = :num_doc", nativeQuery = true)
    Beneficiario darBeneficiario(@Param("num_doc") Long numDoc);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO beneficiarios (num_doc, parentesco, contribuyente_num_doc) VALUES (:num_doc, :parentesco, :contribuyente_num_doc)", nativeQuery = true)
    void crearBeneficiario(@Param("num_doc") Long numDoc, @Param("parentesco") String parentesco, @Param("contribuyente_num_doc") Long contribuyenteNumDoc);

    @Modifying
    @Transactional
    @Query(value = "UPDATE beneficiarios SET parentesco = :parentesco, contribuyente_num_doc = :contribuyente_num_doc WHERE num_doc = :num_doc", nativeQuery = true)
    void actualizarBeneficiario(@Param("num_doc") Long numDoc, @Param("parentesco") String parentesco, @Param("contribuyente_num_doc") Long contribuyenteNumDoc);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM beneficiarios WHERE num_doc = :num_doc", nativeQuery = true)
    void eliminarBeneficiario(@Param("num_doc") Long numDoc);
}