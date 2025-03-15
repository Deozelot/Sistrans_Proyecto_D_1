package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "Horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dia;
    private Time horaInicio;
    private Time horaFin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HorarioServicioIPS> getHorariosServiciosIPSs() {
        return horariosServiciosIPSs;
    }

    public void setHorariosServiciosIPSs(List<HorarioServicioIPS> horariosServiciosIPSs) {
        this.horariosServiciosIPSs = horariosServiciosIPSs;
    }

    @OneToMany(mappedBy = "horario")
    private List<HorarioServicioIPS> horariosServiciosIPSs;

    public Horario(Date dia, Time horaInicio, Time horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Horario() {}

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
}
