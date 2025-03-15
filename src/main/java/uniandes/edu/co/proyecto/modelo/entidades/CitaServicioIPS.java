package uniandes.edu.co.proyecto.modelo.entidades;

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

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
