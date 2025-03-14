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
    @Query(value = "INSERT INTO beneficiarios (num_doc, tipo_doc, nombre, fecha_nacimiento, direccion, telefono, tipo_beneficiario, eps_nit) VALUES (:num_doc, :tipo_doc, :nombre, :fecha_nacimiento, :direccion, :telefono, :tipo_beneficiario, :eps_nit)", nativeQuery = true)
    void crearBeneficiario(@Param("num_doc") Long numDoc, @Param("tipo_doc") String tipoDoc, @Param("nombre") String nombre, @Param("fecha_nacimiento") java.sql.Timestamp fechaNacimiento, @Param("direccion") String direccion, @Param("telefono") Long telefono, @Param("tipo_beneficiario") String tipoBeneficiario, @Param("eps_nit") Long epsNit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE beneficiarios SET tipo_doc = :tipo_doc, nombre = :nombre, fecha_nacimiento = :fecha_nacimiento, direccion = :direccion, telefono = :telefono, tipo_beneficiario = :tipo_beneficiario, eps_nit = :eps_nit WHERE num_doc = :num_doc", nativeQuery = true)
    void actualizarBeneficiario(@Param("num_doc") Long numDoc, @Param("tipo_doc") String tipoDoc, @Param("nombre") String nombre, @Param("fecha_nacimiento") java.sql.Timestamp fechaNacimiento, @Param("direccion") String direccion, @Param("telefono") Long telefono, @Param("tipo_beneficiario") String tipoBeneficiario, @Param("eps_nit") Long epsNit);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM beneficiarios WHERE num_doc = :num_doc", nativeQuery = true)
    void eliminarBeneficiario(@Param("num_doc") Long numDoc);
}