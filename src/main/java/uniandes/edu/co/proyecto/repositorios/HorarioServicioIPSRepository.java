package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.HorarioServicioIPS;

import java.util.Collection;

public interface HorarioServicioIPSRepository extends JpaRepository<HorarioServicioIPS, Long> {

    @Query(value = "SELECT * FROM horarios_serviciosipss", nativeQuery = true)
    Collection<HorarioServicioIPS> darHorariosServicioIPS();

    @Query(value = "SELECT * FROM horarios_serviciosipss WHERE id = :id", nativeQuery = true)
    HorarioServicioIPS darHorarioServicioIPS(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO horarios_serviciosipss (id, horario_id, servicio_id, ips_nit) VALUES (:id, :horario_id, :servicio_id, :ips_nit)", nativeQuery = true)
    void crearHorarioServicioIPS(@Param("id") Long id, @Param("horario_id") Long horarioId, @Param("servicio_id") Long servicioId, @Param("ips_nit") Long ipsNit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE horarios_serviciosipss SET  horario_id = :horario_id, servicio_id = :servicio_id, ips_nit = :ips_nit WHERE id = :id", nativeQuery = true)
    void actualizarHorarioServicioIPS(@Param("id") Long id, @Param("horario_id") Long horarioId, @Param("servicio_id") Long servicioId, @Param("ips_nit") Long ipsNit);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM horarios_serviciosipss WHERE id = :id", nativeQuery = true)
    void eliminarHorarioServicioIPS(@Param("id") Long id);
}