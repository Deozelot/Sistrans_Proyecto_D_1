package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "IPSs")
public class IPS {

    @Id
    private Long nit;

    private String nombre;

    private String direccion;

    private Long telefono;

    @ManyToMany
    private List<ServicioSalud> servicios;

    @ManyToOne
    private EPS eps;

    @OneToMany
    private List<Medico> medicos;

    @OneToMany(mappedBy = "ips")
    private List<HorarioServicioIPS> horariosServicioIPSs;

    public IPS(Long nit, String nombre, String direccion, Long telefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public IPS() {}

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public List<ServicioSalud> getListaServicios() {
        return servicios;
    }

    public void setListaServicios(List<ServicioSalud> listaServicios) {
        this.servicios = listaServicios;
    }

    public EPS getEps() {
        return eps;
    }

    public void setEps(EPS eps) {
        this.eps = eps;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<HorarioServicioIPS> getHorarioServicioIPSs() {
        return horariosServicioIPSs;
    }

    public void setHorarioServicioIPSs(List<HorarioServicioIPS> horarioServicioIPSs) {
        this.horariosServicioIPSs = horarioServicioIPSs;
    }
}
