package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.Medico;
import uniandes.edu.co.proyecto.modelo.enums.Especialidad;
import uniandes.edu.co.proyecto.modelo.enums.TipoDoc;

import java.util.Collection;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(value = "SELECT * FROM medicos", nativeQuery = true)
    Collection<Medico> darMedicos();

    @Query(value = "SELECT * FROM medicos WHERE num_registro = :num_registro", nativeQuery = true)
    Medico darMedico(@Param("num_registro") Long numRegistro);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO medicos (tipo_doc, num_doc, nombre, especialidad, num_registro) VALUES (:tipo_doc, :num_doc, :nombre, :especialidad, :num_registro)", nativeQuery = true)
    void crearMedico(@Param("tipo_doc") TipoDoc tipoDoc, @Param("num_doc") Long numDoc, @Param("nombre") String nombre, @Param("especialidad") Especialidad especialidad, @Param("num_registro") Long numRegistro);

    @Modifying
    @Transactional
    @Query(value = "UPDATE medicos SET tipo_doc = :tipo_doc, num_doc = :num_doc, nombre = :nombre, especialidad = :especialidad WHERE num_registro = :num_registro", nativeQuery = true)
    void actualizarMedico(@Param("tipo_doc") TipoDoc tipoDoc, @Param("num_doc") Long numDoc, @Param("nombre") String nombre, @Param("especialidad") Especialidad especialidad, @Param("num_registro") Long numRegistro);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM medicos WHERE num_registro = :num_registro", nativeQuery = true)
    void eliminarMedico(@Param("num_registro") Long numRegistro);
}