package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.HorarioServicioIPS;

import java.util.Collection;

public interface HorarioServicioIPSRepository extends JpaRepository<HorarioServicioIPS, Long> {

    @Query(value = "SELECT * FROM horarios_servicio_ips", nativeQuery = true)
    Collection<HorarioServicioIPS> darHorariosServicioIPS();

    @Query(value = "SELECT * FROM horarios_servicio_ips WHERE id = :id", nativeQuery = true)
    HorarioServicioIPS darHorarioServicioIPS(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO horarios_servicio_ips (id, dia, hora_inicio, hora_fin) VALUES (:id, :dia, :hora_inicio, :hora_fin)", nativeQuery = true)
    void crearHorarioServicioIPS(@Param("id") Long id, @Param("dia") String dia, @Param("hora_inicio") String horaInicio, @Param("hora_fin") String horaFin);

    @Modifying
    @Transactional
    @Query(value = "UPDATE horarios_servicio_ips SET dia = :dia, hora_inicio = :hora_inicio, hora_fin = :hora_fin WHERE id = :id", nativeQuery = true)
    void actualizarHorarioServicioIPS(@Param("id") Long id, @Param("dia") String dia, @Param("hora_inicio") String horaInicio, @Param("hora_fin") String horaFin);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM horarios_servicio_ips WHERE id = :id", nativeQuery = true)
    void eliminarHorarioServicioIPS(@Param("id") Long id);
}