package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.Servicio;
import uniandes.edu.co.proyecto.modelo.enums.TipoServicio;

import java.util.Collection;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServiciosSalud();

    @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicioSalud(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (id, nombre, descripcion, tipo) VALUES (:id, :nombre, :descripcion, :tipo)", nativeQuery = true)
    void crearServicioSalud(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("tipo") TipoServicio tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET nombre = :nombre, descripcion = :descripcion, tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarServicioSalud(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("tipo") TipoServicio tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicioSalud(@Param("id") Long id);
}