package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.Afiliado;

import java.util.Collection;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {

    @Query(value = "SELECT * FROM afiliados", nativeQuery = true)
    Collection<Afiliado> darAfiliados();

    @Query(value = "SELECT * FROM afiliados WHERE num_doc = :num_doc", nativeQuery = true)
    Afiliado darAfiliado(@Param("num_doc") Long numDoc);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO afiliados (num_doc, tipo_doc, nombre, fecha_nacimiento, direccion, telefono, tipo_afiliado, eps_nit) VALUES (:num_doc, :tipo_doc, :nombre, :fecha_nacimiento, :direccion, :telefono, :tipo_afiliado, :eps_nit)", nativeQuery = true)
    void crearAfiliado(@Param("num_doc") Long numDoc, @Param("tipo_doc") String tipoDoc, @Param("nombre") String nombre, @Param("fecha_nacimiento") java.sql.Timestamp fechaNacimiento, @Param("direccion") String direccion, @Param("telefono") Long telefono, @Param("tipo_afiliado") String tipoAfiliado, @Param("eps_nit") Long epsNit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE afiliados SET tipo_doc = :tipo_doc, nombre = :nombre, fecha_nacimiento = :fecha_nacimiento, direccion = :direccion, telefono = :telefono, tipo_afiliado = :tipo_afiliado, eps_nit = :eps_nit WHERE num_doc = :num_doc", nativeQuery = true)
    void actualizarAfiliado(@Param("num_doc") Long numDoc, @Param("tipo_doc") String tipoDoc, @Param("nombre") String nombre, @Param("fecha_nacimiento") java.sql.Timestamp fechaNacimiento, @Param("direccion") String direccion, @Param("telefono") Long telefono, @Param("tipo_afiliado") String tipoAfiliado, @Param("eps_nit") Long epsNit);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM afiliados WHERE num_doc = :num_doc", nativeQuery = true)
    void eliminarAfiliado(@Param("num_doc") Long numDoc);
}