package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.ServicioSalud;

import java.util.Collection;

public interface ServicioSaludRepository extends JpaRepository<ServicioSalud, Long> {

    @Query(value = "SELECT * FROM servicios_salud", nativeQuery = true)
    Collection<ServicioSalud> darServiciosSalud();

    @Query(value = "SELECT * FROM servicios_salud WHERE id = :id", nativeQuery = true)
    ServicioSalud darServicioSalud(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios_salud (id, nombre, descripcion) VALUES (:id, :nombre, :descripcion)", nativeQuery = true)
    void crearServicioSalud(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios_salud SET nombre = :nombre, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
    void actualizarServicioSalud(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios_salud WHERE id = :id", nativeQuery = true)
    void eliminarServicioSalud(@Param("id") Long id);
}