package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.enums.TipoServicio;

import java.util.List;

@Entity
@Table(name= "Servicios")
public class ServicioSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoServicio tipo;

    @ManyToMany(mappedBy = "servicios")
    private List<EPS> epss;

    @OneToMany(mappedBy = "servicio")
    private List<HorarioServicioIPS> horariosServiciosIPSs;

    @OneToMany(mappedBy = "servicio")
    private List<Orden> ordenes;

    public ServicioSalud(Long id, String nombre, String descripcion, TipoServicio tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public ServicioSalud() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public List<EPS> getEpss() {
        return epss;
    }

    public void setEpss(List<EPS> epss) {
        this.epss = epss;
    }

    public List<HorarioServicioIPS> getHorarioServiciosIPSs() {
        return horariosServiciosIPSs;
    }

    public void setHorarioServiciosIPSs(List<HorarioServicioIPS> horarioServiciosIPSs) {
        this.horariosServiciosIPSs = horarioServiciosIPSs;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
}
