package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.enums.Especialidad;
import uniandes.edu.co.proyecto.modelo.enums.TipoDoc;

import java.util.List;

@Entity
@Table(name = "Medicos")
public class Medico {

    private TipoDoc tipoDoc;
    private Long numDoc;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Id
    private Long numRegistro;

    @ManyToOne
    private IPS ips;

    @OneToMany(mappedBy = "medico")
    private List<Orden> ordenes;

    @OneToMany(mappedBy = "medico")
    private List<PrestacionServicioIps> prestacioneServicioEps;

    public Medico(TipoDoc tipo, Long numDoc, String nombre, Especialidad especialidad, Long numRegistro) {
        this.tipoDoc = tipo;
        this.numDoc = numDoc;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.numRegistro = numRegistro;
    }

    public Medico() {}

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipo) {
        this.tipoDoc = tipo;
    }

    public Long getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Long numDoc) {
        this.numDoc = numDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Long getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(Long numRegistro) {
        this.numRegistro = numRegistro;
    }

    public IPS getIps() {
        return ips;
    }

    public void setIps(IPS ips) {
        this.ips = ips;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public List<PrestacionServicioIps> getPrestacioneServicioEps() {
        return prestacioneServicioEps;
    }

    public void setPrestacioneServicioEps(List<PrestacionServicioIps> prestacioneServicioEps) {
        this.prestacioneServicioEps = prestacioneServicioEps;
    }
}
