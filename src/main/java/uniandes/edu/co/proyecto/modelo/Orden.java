package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

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
}
