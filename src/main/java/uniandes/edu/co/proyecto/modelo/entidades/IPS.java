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
    private List<ServicioSalud> listaServicios;

    @ManyToOne
    private EPS eps;

    @OneToMany
    private List<Medico> medicos;

    @OneToMany(mappedBy = "ips")
    private List<HorarioServicioIPS> horarioServicioIPSs;

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
        return listaServicios;
    }

    public void setListaServicios(List<ServicioSalud> listaServicios) {
        this.listaServicios = listaServicios;
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
        return horarioServicioIPSs;
    }

    public void setHorarioServicioIPSs(List<HorarioServicioIPS> horarioServicioIPSs) {
        this.horarioServicioIPSs = horarioServicioIPSs;
    }
}
