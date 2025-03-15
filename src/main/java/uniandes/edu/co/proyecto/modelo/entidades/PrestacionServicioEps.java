package uniandes.edu.co.proyecto.modelo.entidades;

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

    public PrestacionServicioEps(Afiliado afiliado, Medico medico) {
        super();
        this.afiliado = afiliado;
        this.medico = medico;
    }

    public PrestacionServicioEps() {}

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
}
