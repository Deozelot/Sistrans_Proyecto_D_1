package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.Medico;

import java.util.Collection;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(value = "SELECT * FROM medicos", nativeQuery = true)
    Collection<Medico> darMedicos();

    @Query(value = "SELECT * FROM medicos WHERE id = :id", nativeQuery = true)
    Medico darMedico(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO medicos (id, nombre, especialidad) VALUES (:id, :nombre, :especialidad)", nativeQuery = true)
    void crearMedico(@Param("id") Long id, @Param("nombre") String nombre, @Param("especialidad") String especialidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE medicos SET nombre = :nombre, especialidad = :especialidad WHERE id = :id", nativeQuery = true)
    void actualizarMedico(@Param("id") Long id, @Param("nombre") String nombre, @Param("especialidad") String especialidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM medicos WHERE id = :id", nativeQuery = true)
    void eliminarMedico(@Param("id") Long id);
}