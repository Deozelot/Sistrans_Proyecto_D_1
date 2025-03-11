package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "EPSs")
public class EPS {

    private String nombre;

    @Id
    private Long nit;

    @OneToMany(mappedBy = "eps", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Afiliado> afiliados;

    @ManyToMany
    private List<ServicioSalud> servicios;

    @OneToMany(mappedBy = "eps", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IPS> ipss;

    public EPS(String nombre, Long nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public EPS() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }
}
