package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CitasServiciosEPSs")
public class CitaServicioIPS extends HorarioServicioIPS {


    @ManyToOne
    private Afiliado afiliado;

    @OneToOne
    private Orden orden;
}
