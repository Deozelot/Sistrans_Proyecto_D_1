package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.CitaServicioIPS;

import java.util.Collection;

public interface CitaServicioIPSRepository extends JpaRepository<CitaServicioIPS, Long> {

    @Query(value = "SELECT * FROM CitasServiciosEPSs", nativeQuery = true)
    Collection<CitaServicioIPS> darCitasServicioIPS();

    @Query(value = "SELECT * FROM CitasServiciosEPSs WHERE id = :id", nativeQuery = true)
    CitaServicioIPS darCitaServicioIPS(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CitasServiciosEPSs (id, afiliado_id, orden_id) VALUES (:id, :afiliado_id, :orden_id)", nativeQuery = true)
    void crearCitaServicioIPS(@Param("id") Long id, @Param("afiliado_id") Long afiliadoId, @Param("orden_id") Long ordenId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CitasServiciosEPSs SET afiliado_id = :afiliado_id, orden_id = :orden_id WHERE id = :id", nativeQuery = true)
    void actualizarCitaServicioIPS(@Param("id") Long id, @Param("afiliado_id") Long afiliadoId, @Param("orden_id") Long ordenId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CitasServiciosEPSs WHERE id = :id", nativeQuery = true)
    void eliminarCitaServicioIPS(@Param("id") Long id);
}