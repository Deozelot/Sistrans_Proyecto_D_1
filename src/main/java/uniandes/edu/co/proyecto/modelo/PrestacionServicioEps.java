package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PrestacionesServiciosEPSs")
public class PrestacionServicioEps extends HorarioServicioIPS{

    @ManyToOne
    private Afiliado afiliado;

    @ManyToOne
    private Medico medico;
}
