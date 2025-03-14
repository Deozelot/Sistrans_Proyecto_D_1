package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.EPS;

import java.util.Collection;

public interface EPSRepository extends JpaRepository<EPS, Long> {

    @Query(value = "SELECT * FROM eps", nativeQuery = true)
    Collection<EPS> darEPS();

    @Query(value = "SELECT * FROM eps WHERE nit = :nit", nativeQuery = true)
    EPS darEPSPorNit(@Param("nit") Long nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO eps (nit, nombre, direccion, telefono) VALUES (:nit, :nombre, :direccion, :telefono)", nativeQuery = true)
    void crearEPS(@Param("nit") Long nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") Long telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE eps SET nombre = :nombre, direccion = :direccion, telefono = :telefono WHERE nit = :nit", nativeQuery = true)
    void actualizarEPS(@Param("nit") Long nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") Long telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM eps WHERE nit = :nit", nativeQuery = true)
    void eliminarEPS(@Param("nit") Long nit);
}