package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.Orden;
import uniandes.edu.co.proyecto.modelo.enums.EstadoOrden;

import java.sql.Date;
import java.util.Collection;

public interface OrdenRepository extends JpaRepository<Orden, Long> {

    @Query(value = "SELECT * FROM ordenes", nativeQuery = true)
    Collection<Orden> darOrdenes();

    @Query(value = "SELECT * FROM ordenes WHERE num_orden = :num_orden", nativeQuery = true)
    Orden darOrden(@Param("num_orden") Long numOrden);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenes (num_orden, fecha, estado, afiliado_num_doc, medico_num_registro, servicio_id) VALUES (:num_orden, :fecha, :estado, :afiliado_num_doc, :medico_num_registro, :servicio_id)", nativeQuery = true)
    void crearOrden(@Param("num_orden") Long numOrden, @Param("fecha") Date fecha, @Param("estado") EstadoOrden estado, @Param("afiliado_num_doc") Long afiliadoNumDoc, @Param("medico_num_registro") Long medicoNumRegistro, @Param("servicio_id") Long servicioId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes SET fecha = :fecha, estado = :estado, afiliado_num_doc = :afiliado_num_doc, medico_num_registro = :medico_num_registro, servicio_id = :servicio_id WHERE num_orden = :num_orden", nativeQuery = true)
    void actualizarOrden(@Param("num_orden") Long numOrden, @Param("fecha") Date fecha, @Param("estado") EstadoOrden estado, @Param("afiliado_num_doc") Long afiliadoNumDoc, @Param("medico_num_registro") Long medicoNumRegistro, @Param("servicio_id") Long servicioId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ordenes WHERE num_orden = :num_orden", nativeQuery = true)
    void eliminarOrden(@Param("num_orden") Long numOrden);
}