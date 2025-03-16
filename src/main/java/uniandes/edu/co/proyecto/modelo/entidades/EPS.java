package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EPSs")
public class EPS {

    private String nombre;

    @Id
    private Long nit;

    @OneToMany(mappedBy = "eps", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Afiliado> afiliados = new ArrayList<>();

    @OneToMany(mappedBy = "eps", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios = new ArrayList<>();

    @OneToMany(mappedBy = "eps", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IPS> ipss = new ArrayList<>();

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

    public List<Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<IPS> getIpss() {
        return ipss;
    }

    public void setIpss(List<IPS> ipss) {
        this.ipss = ipss;
    }




}
