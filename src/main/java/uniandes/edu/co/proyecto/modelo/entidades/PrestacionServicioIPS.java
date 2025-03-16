package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prestaciones_ServiciosIPSs")
public class PrestacionServicioIPS extends HorarioServicioIPS{

    @ManyToOne
    private Afiliado afiliado;

    @ManyToOne
    private Medico medico;

    public PrestacionServicioIPS(Afiliado afiliado, Medico medico) {
        super();
        this.afiliado = afiliado;
        this.medico = medico;
    }

    public PrestacionServicioIPS() {}

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
