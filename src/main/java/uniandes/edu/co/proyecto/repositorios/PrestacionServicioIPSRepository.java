package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.PrestacionServicioIPS;

import java.util.Collection;

public interface PrestacionServicioIPSRepository extends JpaRepository<PrestacionServicioIPS, Long> {

    @Query(value = "SELECT * FROM prestaciones_serviciosipss", nativeQuery = true)
    Collection<PrestacionServicioIPS> darPrestacionesServicioIps();

    @Query(value = "SELECT * FROM prestaciones_serviciosipss WHERE id = :id", nativeQuery = true)
    PrestacionServicioIPS darPrestacionServicioIps(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestaciones_serviciosipss (id, afiliado_num_doc, medico_num_registro) VALUES (:id, :afiliado_num_doc, :medico_num_registro)", nativeQuery = true)
    void crearPrestacionServicioIps(@Param("id") Long id, @Param("afiliado_num_doc") Long afiliadoNumDoc, @Param("medico_num_registro") Long medicoNumRegistro);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestaciones_serviciosipss SET afiliado_num_doc = :afiliado_num_doc, medico_num_registro = :medico_num_registro WHERE id = :id", nativeQuery = true)
    void actualizarPrestacionServicioIps(@Param("id") Long id, @Param("afiliado_num_doc") Long afiliadoNumDoc, @Param("medico_num_registro") Long medicoNumRegistro);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestaciones_serviciosipss WHERE id = :id", nativeQuery = true)
    void eliminarPrestacionServicioIps(@Param("id") Long id);
}