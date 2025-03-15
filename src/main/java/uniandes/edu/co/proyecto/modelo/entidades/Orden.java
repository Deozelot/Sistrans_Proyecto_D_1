package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.enums.EstadoOrden;

import java.util.Date;

@Entity
@Table(name = "Ordenes")
public class Orden {

    @Id
    private Long numOrden;

    private Date fecha;

    private EstadoOrden estado;

    @ManyToOne
    private Afiliado afiliado;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private ServicioSalud servicio;

    public Orden(Long numOrden, Date fecha, EstadoOrden estado) {
        this.numOrden = numOrden;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Orden() {}

    public Long getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(Long numOrden) {
        this.numOrden = numOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public ServicioSalud getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSalud servicio) {
        this.servicio = servicio;
    }
}
