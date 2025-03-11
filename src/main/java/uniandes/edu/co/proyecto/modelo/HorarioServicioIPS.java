package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "HorariosServiciosIPSs")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
