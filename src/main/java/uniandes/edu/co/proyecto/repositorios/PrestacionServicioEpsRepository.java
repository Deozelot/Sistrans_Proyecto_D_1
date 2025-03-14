package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.PrestacionServicioEps;

import java.util.Collection;

public interface PrestacionServicioEpsRepository extends JpaRepository<PrestacionServicioEps, Long> {

    @Query(value = "SELECT * FROM prestaciones_servicio_eps", nativeQuery = true)
    Collection<PrestacionServicioEps> darPrestacionesServicioEps();

    @Query(value = "SELECT * FROM prestaciones_servicio_eps WHERE id = :id", nativeQuery = true)
    PrestacionServicioEps darPrestacionServicioEps(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestaciones_servicio_eps (id, nombre, descripcion) VALUES (:id, :nombre, :descripcion)", nativeQuery = true)
    void crearPrestacionServicioEps(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestaciones_servicio_eps SET nombre = :nombre, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
    void actualizarPrestacionServicioEps(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestaciones_servicio_eps WHERE id = :id", nativeQuery = true)
    void eliminarPrestacionServicioEps(@Param("id") Long id);
}