package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Horarios_ServiciosIPSs")
@Inheritance(strategy = InheritanceType.JOINED)
public class HorarioServicioIPS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Horario horario;

    @ManyToOne
    private ServicioSalud servicio;

    @ManyToOne
    private IPS ips;

    public HorarioServicioIPS(Long id, Horario horario, ServicioSalud servicio, IPS ips) {
        this.id = id;
        this.horario = horario;
        this.servicio = servicio;
        this.ips = ips;
    }

    public HorarioServicioIPS() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public ServicioSalud getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSalud servicio) {
        this.servicio = servicio;
    }

    public IPS getIps() {
        return ips;
    }

    public void setIps(IPS ips) {
        this.ips = ips;
    }
}
