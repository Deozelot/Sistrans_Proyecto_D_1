package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.IPS;

import java.util.Collection;

public interface IPSRepository extends JpaRepository<IPS, Long> {

    @Query(value = "SELECT * FROM ipss", nativeQuery = true)
    Collection<IPS> darIPS();

    @Query(value = "SELECT * FROM ipss WHERE nit = :nit", nativeQuery = true)
    IPS darIPSPorId(@Param("nit") Long nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ipss (nit, nombre, direccion, telefono) VALUES (:nit, :nombre, :direccion, :telefono)", nativeQuery = true)
    void crearIPS(@Param("nit") Long nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ipss SET nombre = :nombre, direccion = :direccion, telefono = :telefono WHERE nit = :nit", nativeQuery = true)
    void actualizarIPS(@Param("nit") Long nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ipss WHERE nit = :nit", nativeQuery = true)
    void eliminarIPS(@Param("nit") Long nit);
}