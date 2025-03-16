package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.EPS;

import java.util.Collection;

public interface EPSRepository extends JpaRepository<EPS, Long> {

    @Query(value = "SELECT * FROM epss", nativeQuery = true)
    Collection<EPS> darEPS();

    @Query(value = "SELECT * FROM epss WHERE nit = :nit", nativeQuery = true)
    EPS darEPSPorNit(@Param("nit") Long nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO epss (nit, nombre) VALUES (:nit, :nombre)", nativeQuery = true)
    void crearEPS(@Param("nit") Long nit, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE epss SET nombre = :nombre WHERE nit = :nit", nativeQuery = true)
    void actualizarEPS(@Param("nit") Long nit, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM epss WHERE nit = :nit", nativeQuery = true)
    void eliminarEPS(@Param("nit") Long nit);
}