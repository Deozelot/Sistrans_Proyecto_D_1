package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "ServiciosSalud")
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
    private List<HorarioServicioIPS> horarioServiciosIPSs;

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
}
