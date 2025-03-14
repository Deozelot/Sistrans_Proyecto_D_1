package uniandes.edu.co.proyecto.repositorios;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.entidades.IPS;

import java.util.Collection;

public interface IPSRepository extends JpaRepository<IPS, Long> {

    @Query(value = "SELECT * FROM ips", nativeQuery = true)
    Collection<IPS> darIPS();

    @Query(value = "SELECT * FROM ips WHERE id = :id", nativeQuery = true)
    IPS darIPSPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ips (id, nombre, direccion, telefono) VALUES (:id, :nombre, :direccion, :telefono)", nativeQuery = true)
    void crearIPS(@Param("id") Long id, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") Long telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ips SET nombre = :nombre, direccion = :direccion, telefono = :telefono WHERE id = :id", nativeQuery = true)
    void actualizarIPS(@Param("id") Long id, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") Long telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ips WHERE id = :id", nativeQuery = true)
    void eliminarIPS(@Param("id") Long id);
}