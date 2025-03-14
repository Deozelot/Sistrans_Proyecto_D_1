package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.Orden;

import java.util.Collection;

public interface OrdenRepository extends JpaRepository<Orden, Long> {

    @Query(value = "SELECT * FROM ordenes", nativeQuery = true)
    Collection<Orden> darOrdenes();

    @Query(value = "SELECT * FROM ordenes WHERE id = :id", nativeQuery = true)
    Orden darOrden(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenes (id, descripcion, fecha) VALUES (:id, :descripcion, :fecha)", nativeQuery = true)
    void crearOrden(@Param("id") Long id, @Param("descripcion") String descripcion, @Param("fecha") String fecha);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes SET descripcion = :descripcion, fecha = :fecha WHERE id = :id", nativeQuery = true)
    void actualizarOrden(@Param("id") Long id, @Param("descripcion") String descripcion, @Param("fecha") String fecha);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ordenes WHERE id = :id", nativeQuery = true)
    void eliminarOrden(@Param("id") Long id);
}