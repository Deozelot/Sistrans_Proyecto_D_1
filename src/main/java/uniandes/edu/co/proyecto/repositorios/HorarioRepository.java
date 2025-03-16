package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.Horario;

import java.sql.Time;
import java.util.Collection;
import java.sql.Date;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @Query(value = "SELECT * FROM horarios", nativeQuery = true)
    Collection<Horario> darHorarios();

    @Query(value = "SELECT * FROM horarios WHERE id = :id", nativeQuery = true)
    Horario darHorario(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO horarios (id, dia, hora_inicio, hora_fin) VALUES (:id, :dia, :hora_inicio, :hora_fin)", nativeQuery = true)
    void crearHorario(@Param("id") Long id, @Param("dia") Date dia, @Param("hora_inicio") Time horaInicio, @Param("hora_fin") Time horaFin);

    @Modifying
    @Transactional
    @Query(value = "UPDATE horarios SET dia = :dia, hora_inicio = :hora_inicio, hora_fin = :hora_fin WHERE id = :id", nativeQuery = true)
    void actualizarHorario(@Param("id") Long id, @Param("dia") Date dia, @Param("hora_inicio") Time horaInicio, @Param("hora_fin") Time horaFin);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM horarios WHERE id = :id", nativeQuery = true)
    void eliminarHorario(@Param("id") Long id);
}