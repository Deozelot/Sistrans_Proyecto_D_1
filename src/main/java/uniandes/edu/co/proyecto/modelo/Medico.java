package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Medicos")
public class Medico {

    private TipoDoc tipo;
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
    private List<PrestacionServicioEps> prestacioneServicioEps;

    public Medico(TipoDoc tipo, Long numDoc, String nombre, Especialidad especialidad, Long numRegistro) {
        this.tipo = tipo;
        this.numDoc = numDoc;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.numRegistro = numRegistro;
    }

    public Medico() {}

    public TipoDoc getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoc tipo) {
        this.tipo = tipo;
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
}
